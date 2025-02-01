package io.github.soydivision.domain;

import io.github.soydivision.constants.SupportedDataTypes;
import io.github.soydivision.custom_classes.LimitedArrayList;

import java.util.List;

public class Column {
    String name;
    List<Row> rows = new LimitedArrayList<>();
    Class<?> dataType;
    boolean isPrimaryKey;

    public Column(String name, SupportedDataTypes dataType) {
        this.name = name;
        this.dataType = dataType.getAssociatedClass();
    }

    public void addRow(Row row) {
        // try to box row value and add to list
        // search column name among the row names and if one equal then try to box the value ot this.dataType
        // on fail throw exception
    }


    @Override
    public String toString() {
        return "Column{" +
                "name='" + name + '\'' +
                ", rows=" + rows +
                ", dataType=" + dataType +
                '}';
    }
}
