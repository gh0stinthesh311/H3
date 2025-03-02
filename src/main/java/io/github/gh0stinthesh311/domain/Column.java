package io.github.gh0stinthesh311.domain;

import io.github.gh0stinthesh311.constants.SupportedDataTypes;
import io.github.gh0stinthesh311.custom_classes.LimitedArrayList;

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
