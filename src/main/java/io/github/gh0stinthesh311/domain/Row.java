package io.github.gh0stinthesh311.domain;

import io.github.gh0stinthesh311.utils.LogUtil;

import java.util.HashMap;
import java.util.Map;

public class Row {
    /*  This means that Row can have values (Name → Value) such as:
      Row can not have two values for "id" or any other column name
      id = 1
      Make = Toyota
      Mileage = 280 000 miles
    */
    Map<String, Object> rowValues;

    public Row() {
        this.rowValues = new HashMap<>();
    }

    public void addValue(String columnName, Object valueContainer) {
        this.rowValues.put(columnName, valueContainer);
        LogUtil.info("Value has been added:" + rowValues.get(columnName));
//        rowValues.forEach((key, value) -> System.out.println(key + " " + value));
//        System.out.println(rowValues.get(columnName).toString());
    }

    public Map<String, Object> getRowValues() {
        return rowValues;
    }

    @Override
    public String toString() {
        return "\nRow " + rowValues;
    }
}

