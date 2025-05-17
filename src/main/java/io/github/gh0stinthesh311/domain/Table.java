package io.github.gh0stinthesh311.domain;

import io.github.gh0stinthesh311.constants.SupportedDataTypes;
import io.github.gh0stinthesh311.constants.SysMessages;
import io.github.gh0stinthesh311.utils.LogUtil;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;
import java.util.stream.Collectors;

public class Table {
    String name;
//    HashMap<String, Column> columns;
//    Set<String> columnsNames;
    // add rows here 

    public Table(String name, HashMap<String, Column> columns) {
        this.name = name;
        this.columns = columns;
    }

    public Table(String name) {
        this.name = name;
        this.columns = new HashMap();
    }

    public void addColumn(String columnName, String columnType) {
        LogUtil.info("Adding column: " + columnName + " to table " + this.name + ", type: " + columnType);
        this.columns.put(columnName, new Column(columnName, columnType));
        LogUtil.info("Table: " + this.getName() + " contains " + columns.size() + " columns");
        System.out.println(this.columns);
    }

    public void createColumns(String SQL, Table table) {
        String[] columnDefinitions = extractColumnDefinitions(SQL).split(",");
        for (String columnDefinition : columnDefinitions) {
            LogUtil.info("Parsing column definition: " + columnDefinition);
            String[] parsedColumnDefinition = parseAndReturnColumnDefinition(columnDefinition);
            table.addColumn(parsedColumnDefinition[0], parsedColumnDefinition[1]);
        }
    }

    // Move as service
    public String extractColumnDefinitions(String SQL) {
        String columnDefinitions = SQL.substring(SQL.indexOf("(") + 1, SQL.lastIndexOf(")")).trim();
        LogUtil.info("Extracted column definitions: " + columnDefinitions);
        return columnDefinitions;
    }
    // Move as service

    public String[] parseAndReturnColumnDefinition(String columnDefinition) {
        String[] columnDefinitionTokens = columnDefinition.split(" ");
        // to do - this should be made in normalize section
        // removes "(", ")" and everything in between, so that VARCHAR(256) -> VARCHAR
        String dataTypeParameterRemoved = columnDefinitionTokens[1].replaceAll("\\([^)]*\\)", "");
        System.out.println("dataTypeParameterRemoved:" + dataTypeParameterRemoved);
//
//        if (dataTypeParameterRemoved.toUpperCase().equals(SupportedDataTypes.INT.name())) {
//            LogUtil.info(SupportedDataTypes.INT.name() + SysMessages.DATATYPE_FOUND.getMessage());
//        } else if (dataTypeParameterRemoved.toUpperCase().equals(SupportedDataTypes.VARCHAR.name())) {
//            LogUtil.info(SupportedDataTypes.VARCHAR.name() + SysMessages.DATATYPE_FOUND.getMessage());
//        } else if (dataTypeParameterRemoved.toUpperCase().equals(SupportedDataTypes.TEXT.name())) {
//            LogUtil.info(SupportedDataTypes.TEXT.name() + SysMessages.DATATYPE_FOUND.getMessage());
//        } else if (dataTypeParameterRemoved.toUpperCase().equals(SupportedDataTypes.BOOLEAN.name())) {
//            LogUtil.info(SupportedDataTypes.BOOLEAN.name() + SysMessages.DATATYPE_FOUND.getMessage());
//        } else if (dataTypeParameterRemoved.toUpperCase().equals(SupportedDataTypes.DATE.name())) {
//            LogUtil.info(SupportedDataTypes.DATE.name() + SysMessages.DATATYPE_FOUND.getMessage());
//        } else if (dataTypeParameterRemoved.toUpperCase().equals(SupportedDataTypes.TIME.name())) {
//            LogUtil.info(SupportedDataTypes.TIME.name() + SysMessages.DATATYPE_FOUND.getMessage());
//        }
//        System.out.println(Arrays.asList(columnDefinitionTokens));
        Set<String> supportedTypes = Arrays.stream(SupportedDataTypes.values())
                .map(Enum::name)
                .collect(Collectors.toSet());
        if (supportedTypes.contains(dataTypeParameterRemoved.toUpperCase())) {
            LogUtil.info(dataTypeParameterRemoved.toUpperCase() + SysMessages.DATATYPE_FOUND.getMessage());
        } else {
            LogUtil.warn(dataTypeParameterRemoved.toUpperCase() + SysMessages.DATATYPE_NOT_FOUND.getMessage());
        }
        return new String[]{columnDefinitionTokens[0], dataTypeParameterRemoved};
    }


//    public void addColumn(ColumnMetadata columnMetadata) {
//        this.getColumns().add(columnMetadata);
//    }

    public Row parseRow(String sql) {
        return new Row();
    }


//    public void addRow(String sql) {
//
//        if (columnExistsInTable(row)) {
////            rows.add(parseRow(sql));
//        }
//    }

//    public boolean columnExistsInTable(Row row) {
//        boolean columnExists = false;
//        for (String key : row.getValue().keySet()) { // Basically check if Column for newly added row exists in current Table
//            if (!this.getColumnsNamesSet().contains(key)) {
//                throw new IllegalArgumentException("Table " + this.name + " has no " + key + " column for " + row.getValue().get(key) + " value");
//            }
//            columnExists = true;
//        }
//        return columnExists;
//    }

//    public boolean dataTypeMatches(Row row) {
//        boolean rowAndColumnDataTypesMatch = false;
//        // get rows column name
//        String columnNameOfRow = row.getValue().keySet().toString();
//        // which corresponds with target column
//
//
//        // get column data type
//        // try to convert to target data type of column
//        // on fail throw
//        return false;
//    }

//    public Set<String> getColumnsNamesSet() {
//        return this.columnsNames = columns.stream()
//                .map(ColumnMetadata::getName)
//                .collect(Collectors.toSet());
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public List<ColumnMetadata> getColumns() {
//        return columns;
//    }

//    public void setColumns(List<ColumnMetadata> columns) {
//        this.columns = columns;
//    }

//    public List<Row> getRows() {
//        return rows;
//    }

//    public void setRows(List<Row> rows) {
//        this.rows = rows;
//    }

//    public Set<String> getColumnsNames() {
//        return columnsNames;
//    }

    public Column getColumnByName(String columnName) {
        return columns.get(columnName);
    }


//    public void setColumnsNames(Set<String> columnsNames) {
//        this.columnsNames = columnsNames;
//    }

//    public int getNumberOfRows() {
//        return rows.size();
//    }

    @Override
    public String toString() {
        return "Table: " + name + " \ncolumns = " + columns;

    }


}