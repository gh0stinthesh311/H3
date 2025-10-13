package io.github.gh0stinthesh311.domain;

import io.github.gh0stinthesh311.constants.SupportedDataType;
import io.github.gh0stinthesh311.constants.SysMessages;
import io.github.gh0stinthesh311.exceptions.DataBoxingException;
import io.github.gh0stinthesh311.memory.Memory;
import io.github.gh0stinthesh311.utils.LogUtil;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import static io.github.gh0stinthesh311.utils.Formatter.wrapWithQuotes;
import static io.github.gh0stinthesh311.utils.StringUtils.extractContentBetweenParentheses;

public class Table {
    String name;
    Map<String, Column> columns; // name and column type
    ArrayList<Row> rows = new ArrayList<>();

    public Table(String name) {
        this.name = name;
        this.columns = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
    }

    public void createColumns(String SQL, Table table) {
        // to do add validation for empty column definitions - "CREATE TABLE ninjas;" is invalid
        LogUtil.info("Creating columns for " + wrapWithQuotes(table.getName()));
        String extractedColumnDefinitions = extractColumnDefinitions(SQL);
        if (extractedColumnDefinitions.isEmpty()) {
            LogUtil.info("Column definitions are empty:" + wrapWithQuotes(extractedColumnDefinitions) + ". Define at least one column ");
            Memory.getInstance().getCurrentDatabase().dropTable(table.getName());
        } else {
            String[] columnDefinitions = extractedColumnDefinitions.split(",");
            for (String columnDefinition : columnDefinitions) {
                LogUtil.info("Parsing column definition " + wrapWithQuotes(columnDefinition));
                String[] parsedColumnDefinition = parseAndReturnColumnDefinition(columnDefinition);
                table.addColumn(parsedColumnDefinition[0], parsedColumnDefinition[1]);
            }
        }
    }

    public void addColumn(String columnName, String columnType) {
        LogUtil.info("Adding column " + wrapWithQuotes(columnName) + " to table " + wrapWithQuotes(this.name) + ", type " + wrapWithQuotes(columnType));
        this.columns.put(columnName, new Column(columnType));
        LogUtil.info("Table " + wrapWithQuotes(this.getName()) + " contains following " + this.columns.size() + " column(s)");
        columns.forEach((key, value) -> LogUtil.info(key + " " + value));
    }

    public String extractColumnDefinitions(String SQL) {
        String columnDefinitions = SQL.substring(SQL.indexOf("(") + 1, SQL.lastIndexOf(")")).trim();
//        if (columnDefinitions.isEmpty()) {
//            LogUtil.info("Column definitions are empty:" + wrapWithQuotes(columnDefinitions));
//        }
        LogUtil.info("Extracted column definitions " + wrapWithQuotes(columnDefinitions));
        return columnDefinitions;
    }

    public String[] parseAndReturnColumnDefinition(String columnDefinition) {
        String[] columnDefinitionTokens = columnDefinition.split(" ");
        String columnDefinitionType;
        if (columnDefinitionTokens[1].contains("(") || columnDefinitionTokens[1].contains(")")) {
            columnDefinitionType = columnDefinitionTokens[1].replaceAll("\\([^)]*\\)", "");
            System.out.println("Data type parameter removed from:" + wrapWithQuotes(columnDefinitionType));
        } else {
            columnDefinitionType = columnDefinitionTokens[1];
        }
        if (columnDefinitionType.toUpperCase().equals(SupportedDataType.INT.name())) {
            LogUtil.info(SupportedDataType.INT.name() + SysMessages.DATATYPE_FOUND.getMessage());
        } else if (columnDefinitionType.toUpperCase().equals(SupportedDataType.VARCHAR.name())) {
            LogUtil.info(SupportedDataType.VARCHAR.name() + SysMessages.DATATYPE_FOUND.getMessage());
        } else if (columnDefinitionType.toUpperCase().equals(SupportedDataType.TEXT.name())) {
            LogUtil.info(SupportedDataType.TEXT.name() + SysMessages.DATATYPE_FOUND.getMessage());
        } else if (columnDefinitionType.toUpperCase().equals(SupportedDataType.BOOLEAN.name())) {
            LogUtil.info(SupportedDataType.BOOLEAN.name() + SysMessages.DATATYPE_FOUND.getMessage());
        } else if (columnDefinitionType.toUpperCase().equals(SupportedDataType.DATE.name())) {
            LogUtil.info(SupportedDataType.DATE.name() + SysMessages.DATATYPE_FOUND.getMessage());
        } else if (columnDefinitionType.toUpperCase().equals(SupportedDataType.TIME.name())) {
            LogUtil.info(SupportedDataType.TIME.name() + SysMessages.DATATYPE_FOUND.getMessage());
        }
        return new String[]{columnDefinitionTokens[0], columnDefinitionType};
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Column getColumnByName(String columnName) {
        return columns.get(columnName);
    }

    public void addRow(String SQL) {
        ArrayList<String> contents = extractContentBetweenParentheses(SQL);
        String[] columnList = contents.get(0).split(",");
        String[] individualColumnValues = contents.get(1).split(",");
        for (int i = 0; i < columnList.length; i++) {
            if (columns.containsKey(columnList[i])) {
                insertValueIntoTable(individualColumnValues[i], columnList[i]);
            } else {
                System.out.println("No column " + columnList[i] + " in table " + this.name + " found."); // add err message to do
            }
        }
    }

    public void insertValueIntoTable(String value, String columnName) {
        // if target column is ok with value being passed then it adds. target column should provide
        // associated class and then add this value boxing it to class
        // if column type is int then only numbers, if string then only strings or alphanumerical
//        columns.get(columnName).
//        Object object = columns.get(columnName).getDataType().getAssociatedClass();
        Class<?> targetClass = columns.get(columnName).getDataType().getAssociatedClass();
        Object boxedValue;
        if (targetClass == Integer.class) {
            boxedValue = Integer.parseInt(value);
        } else if (targetClass == String.class) {
            boxedValue = value;
        } else if (targetClass == Boolean.class) {
            boxedValue = Boolean.parseBoolean(value);
        } else {
            throw new DataBoxingException(SysMessages.DATATYPE_PARSING_FAILED.getMessage() + targetClass);
        }
//        columns.get(columnName).getDataType().getAssociatedClass()
//        System.out.println(object);
//        if (object instanceof Integer) {
//            try {
//                obj = Integer.parseInt(str); // parse and auto-box
//                System.out.println("Boxed successfully: " + obj);
//            } catch (NumberFormatException e) {
//                System.out.println("Invalid number: " + str);
//            }

        // To do insert this value into object that will carry it (Integer for int and so on)
        LogUtil.info("Object to hold data:" + boxedValue.getClass());
        Row row = new Row();
        row.addValue(columnName, boxedValue);
        this.rows.add(row);
    }

    public boolean columnExists() {
        return true;
    }

    public void addValueToColumn(String value, Column column) {

    }

    @Override
    public String toString() {
        return "Table: " + name + " \ncolumns = " + columns;

    }
}