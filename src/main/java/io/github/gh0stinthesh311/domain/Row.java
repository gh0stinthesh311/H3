package io.github.gh0stinthesh311.domain;

import io.github.gh0stinthesh311.utils.LogUtil;

import java.util.HashMap;
import java.util.Map;

public class Row {
    Map<String, Object> rowValues; // Column Name → Value. For example - "Id" = "3"

    public Row() {
        this.rowValues = new HashMap<>();
    }

    public void addValue(String columnName, Object valueContainer) {
        this.rowValues.put(columnName, valueContainer);
        LogUtil.info("Value has been added:" + rowValues.get(columnName));
//                + "  to column:" + columnName + " to table " + this.name + ", type:" + columnType);
        rowValues.forEach((key, value) -> System.out.println(key + " " + value));
        System.out.println(rowValues.get(columnName).toString());
    }

    public Map<String, Object> getRowValues() {
        return rowValues;
    }

    @Override
    public String toString() {
        return "\nRow " + rowValues;
    }
}

