package io.github.gh0stinthesh311.domain;

import io.github.gh0stinthesh311.constants.SupportedDataType;
import io.github.gh0stinthesh311.constants.SysMessages;
import io.github.gh0stinthesh311.exceptions.UnsupportedDataTypeException;

import java.util.Arrays;

import static io.github.gh0stinthesh311.constants.SupportedDataType.getSupportedDataTypes;

public class Column {
    private String name;
    private Class<?> dataWrapper;

    public Column(String name, String dataType) {
        this.name = name;
        if (!validateType(dataType)) {
            throw new UnsupportedDataTypeException(dataType + SysMessages.DATATYPE_NOT_FOUND.getMessage());
        } else if (dataType.toUpperCase().equals(SupportedDataType.INT.toString())) {
            this.dataWrapper = SupportedDataType.INT.getAssociatedClass();
        } else if (dataType.toUpperCase().equals(SupportedDataType.VARCHAR.toString())) {
            this.dataWrapper = SupportedDataType.VARCHAR.getAssociatedClass();
        } else if (dataType.toUpperCase().equals(SupportedDataType.TEXT.toString())) {
            this.dataWrapper = SupportedDataType.TEXT.getAssociatedClass();
        } else if (dataType.toUpperCase().equals(SupportedDataType.BOOLEAN.toString())) {
            this.dataWrapper = SupportedDataType.BOOLEAN.getAssociatedClass();
        } else if (dataType.toUpperCase().equals(SupportedDataType.DATE.toString())) {
            this.dataWrapper = SupportedDataType.DATE.getAssociatedClass();
        } else if (dataType.toUpperCase().equals(SupportedDataType.TIME.toString())) {
            this.dataWrapper = SupportedDataType.TIME.getAssociatedClass();
        }
    }

    public boolean validateType(String dataType) {
        return Arrays.asList(getSupportedDataTypes()).contains(dataType.toUpperCase());
    }

    @Override
    public String toString() {
        return dataWrapper.toString();
    }
}
