package io.github.soydivision.domain;

import java.util.HashMap;
import java.util.Map;

public class Row {
    Map<String, Object> value; // Column Name → Value. For example - "Id" = "3"

    public Row() {
        this.value = new HashMap<>();
    }

    public void addValue(String columnName, Object value) {
        this.value.put(columnName, value);
    }

    public Map<String, Object> getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "\nRow " + value;
    }
}

