package io.github.gh0stinthesh311.domain;

import io.github.gh0stinthesh311.constants.SupportedDataTypes;
import io.github.gh0stinthesh311.constants.SysMessages;
import io.github.gh0stinthesh311.custom_classes.LimitedArrayList;
import io.github.gh0stinthesh311.exceptions.UnsupportedDataTypeException;

import java.util.Arrays;
import java.util.List;

import static io.github.gh0stinthesh311.constants.SupportedDataTypes.getSupportedDataTypes;

public class Column {
    //    String name;
//    List<Row> rows = new LimitedArrayList<>();
    String dataType;
//    boolean isPrimaryKey;

    public Column(String dataType) {
        if (!validateType(dataType)) {
            throw new UnsupportedDataTypeException(dataType + SysMessages.DATATYPE_NOT_FOUND.getMessage());
        }
        this.dataType = dataType;
    }

    public boolean validateType(String value) {
        return Arrays.asList(getSupportedDataTypes()).contains(value.toUpperCase());
    }



    @Override
    public String toString() {
        return dataType;
    }
}
