package io.github.gh0stinthesh311.domain;

import java.util.HashMap;
import java.util.Map;

public class Row {
    Map<String, Object> value; // Column Name → Value. For example - "Id" = "3"

    public Row() {
        this.value = new HashMap<>();
    }

    public void addValue(String columnName, Object value) {

        // from column name validate the type of data that shall be created as row
        this.value.put(columnName, value); // validate data type from column
    }

    public Map<String, Object> getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "\nRow " + value;
    }
}

