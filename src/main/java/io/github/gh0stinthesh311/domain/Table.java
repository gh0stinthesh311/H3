package io.github.gh0stinthesh311.domain;

import io.github.gh0stinthesh311.constants.SupportedDataType;
import io.github.gh0stinthesh311.constants.SysMessages;
import io.github.gh0stinthesh311.exceptions.DataBoxingException;
import io.github.gh0stinthesh311.memory.Memory;
import io.github.gh0stinthesh311.utils.LogUtil;

import java.util.*;
import java.util.stream.Collectors;

import static io.github.gh0stinthesh311.utils.Formatter.wrapWithQuotes;
import static io.github.gh0stinthesh311.utils.StringUtils.extractContentBetweenParentheses;
import static io.github.gh0stinthesh311.utils.StringUtils.validateNonEmptyContentBetweenParentheses;

public class Table {
    String name;
    private final List<Column> columns; // row should be tied to column and also
    private final List<Row> rows; // row should be tied to column and also
    private final Map<String, Integer> columnIndexByName;

    public Table(String name) {
        this.name = name;
        this.columns = new ArrayList<>();
        this.rows = new ArrayList<>();
        this.columnIndexByName = new HashMap<>();
    }

    /*Column management section*/

    // remake this whole bullshit to do
    public void createColumns(String SQL, Table table) {
        if (validateNonEmptyContentBetweenParentheses(SQL)) {
            LogUtil.info("Creating columns for table " + wrapWithQuotes(table.getName()));
            String extractedColumnDefinitions = extractColumnDefinitions(SQL);
            String[] columnDefinitions = extractedColumnDefinitions.split(",");
            for (String columnDefinition : columnDefinitions) {
                LogUtil.info("Parsing column definition " + wrapWithQuotes(columnDefinition));
                String[] parsedColumnDefinition = parseAndReturnColumnDefinition(columnDefinition);
                System.out.println("parsedColumnDefinition[0]: " + parsedColumnDefinition[0]);
                System.out.println("parsedColumnDefinition[1]: " + parsedColumnDefinition[1]);
                table.addColumn(parsedColumnDefinition[0], parsedColumnDefinition[1]);
            }
        } else {
            LogUtil.info("No column definitions found in statement " + wrapWithQuotes(SQL));
            Memory.getInstance().getCurrentDatabase().dropTable(table.getName());
        }
    }

    public void addColumn(String columnName, String columnType) {
        LogUtil.info("Adding column " + wrapWithQuotes(columnName) + " to table " + wrapWithQuotes(this.name) + ", type " + wrapWithQuotes(columnType));
        this.columns.add(new Column(columnName, columnType));
        LogUtil.info("Table " + wrapWithQuotes(this.getName()) + " contains following " + this.columns.size() + " column(s):");
//        String columnsAsString = columns.entrySet()
//                .stream()
//                .map(entry -> entry.getKey() + " " + entry.getValue())
//                .collect(Collectors.joining(", "));
//        LogUtil.info(wrapWithQuotes(columnsAsString));
    }

    public String extractColumnDefinitions(String SQL) {
        String columnDefinitions = SQL.substring(SQL.indexOf("(") + 1, SQL.lastIndexOf(")")).trim();
//        if (columnDefinitions.isEmpty()) {
//            LogUtil.info("Column definitions are empty:" + wrapWithQuotes(columnDefinitions));
//        }
        LogUtil.info("Extracted column definition(s) " + wrapWithQuotes(columnDefinitions));
        return columnDefinitions;
    }

    public boolean columnExists() {
        return true;
    }

    public void addValueToColumn(String value, Column column) {
    }

    public String[] parseAndReturnColumnDefinition(String columnDefinition) {
        String[] columnDefinitionTokens = columnDefinition.split(" ");
        String columnDefinitionType;
        if (columnDefinitionTokens[1].contains("(") || columnDefinitionTokens[1].contains(")")) {
            columnDefinitionType = columnDefinitionTokens[1].replaceAll("\\([^)]*\\)", "");
            System.out.println("Data type parameter removed from " + wrapWithQuotes(columnDefinitionType));
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

//    public Column getColumnByName(String columnName) {
//        return columns.get(columnName);
//    }



    /*Row management section*/

    // Reimplement logic. First create one new Row. Then
    // using cycle add each individual value to

    // create row , addValueToRow then finally addRow to table. on each cycle ensure column does exist
    // and data type is supported
    //
    //


//    public void addRow(String SQL) {
//        ArrayList<String> contents = extractContentBetweenParentheses(SQL);
//        String[] columnList = contents.get(0).split(",");
//        String[] individualColumnValues = contents.get(1).split(",");
//        for (int i = 0; i < columnList.length; i++) {
//            if (columns.containsKey(columnList[i])) {
//                insertValueIntoTable(individualColumnValues[i], columnList[i]);
//            } else {
//                // in psql ERROR:  column "phone" of relation "users" does not exist
//                System.out.println("No column " + columnList[i] + " in table " + this.name + " found."); // add err message to do
//                // add also abortion procedure
//            }
//        }
//    }

//    public void insertValueIntoTable(String value, String columnName) {
//        // if target column is ok with value being passed then it adds. target column should provide
//        // associated class and then add this value boxing it to class
//        // if column type is int then only numbers, if string then only strings or alphanumerical
////        columns.get(columnName).
////        Object object = columns.get(columnName).getDataType().getAssociatedClass();
//        Class<?> targetClass = columns.get(columnName).getDataType().getAssociatedClass();
//        Object boxedValue;
//        if (targetClass == Integer.class) {
//            boxedValue = Integer.parseInt(value);
//        } else if (targetClass == String.class) {
//            boxedValue = value;
//        } else if (targetClass == Boolean.class) {
//            boxedValue = Boolean.parseBoolean(value);
//        } else {
//            throw new DataBoxingException(SysMessages.DATATYPE_PARSING_FAILED.getMessage() + targetClass);
//        }
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
//        LogUtil.info("Object to hold data:" + boxedValue.getClass());
//        Row row = new Row();
//        row.addValue(columnName, boxedValue);
//        this.rows.add(row);
//    }


    public List<Row> getRows() {
        return rows;
    }

    public int getNumberOfRows() {
        return rows.size();
    }


    @Override
    public String toString() {
        return "Table: " + name + " \ncolumns = " + columns;

    }
}