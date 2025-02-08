package io.github.soydivision.domain;

import java.util.HashMap;
import java.util.Set;

public class Table {
    String name;
    //    List<ColumnMetadata> columns;
    HashMap<String, Column> columns;
    //    List<Row> rows;
    Set<String> columnsNames;

    public Table(String name, HashMap<String, Column> columns) {
        this.name = name;
        this.columns = columns;
    }

    public Table(String name) {
        this.name = name;
        this.columns = new HashMap();
    }

//    public void addColumn(ColumnMetadata columnMetadata) {
//        this.getColumns().add(columnMetadata);
//    }

//    public void addRow(Row row) {
//        if (columnExistsInTable(row)) {
//            rows.add(row);
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

    public Set<String> getColumnsNames() {
        return columnsNames;
    }

    public void setColumnsNames(Set<String> columnsNames) {
        this.columnsNames = columnsNames;
    }

//    public int getNumberOfRows() {
//        return rows.size();
//    }

    @Override
    public String toString() {
        return "Table: " + name + " \ncolumns = " + columns;

    }
}