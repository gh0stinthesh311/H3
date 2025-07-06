package io.github.gh0stinthesh311.domain;

import io.github.gh0stinthesh311.constants.SupportedDataType;
import io.github.gh0stinthesh311.constants.SysMessages;
import io.github.gh0stinthesh311.exceptions.UnsupportedDataTypeException;

import java.util.Arrays;

import static io.github.gh0stinthesh311.constants.SupportedDataType.getSupportedDataTypes;

public class Column {
    private SupportedDataType dataType;

    public Column(String dataType) {
        if (!validateType(dataType)) {
            throw new UnsupportedDataTypeException(dataType + SysMessages.DATATYPE_NOT_FOUND.getMessage());
        } else if (dataType.toUpperCase().equals(SupportedDataType.INT.toString())) {
            this.dataType = SupportedDataType.INT;
        } else if (dataType.toUpperCase().equals(SupportedDataType.VARCHAR.toString())) {
            this.dataType = SupportedDataType.VARCHAR;
        } else if (dataType.toUpperCase().equals(SupportedDataType.TEXT.toString())) {
            this.dataType = SupportedDataType.TEXT;
        } else if (dataType.toUpperCase().equals(SupportedDataType.BOOLEAN.toString())) {
            this.dataType = SupportedDataType.BOOLEAN;
        } else if (dataType.toUpperCase().equals(SupportedDataType.DATE.toString())) {
            this.dataType = SupportedDataType.DATE;
        } else if (dataType.toUpperCase().equals(SupportedDataType.TIME.toString())) {
            this.dataType = SupportedDataType.TIME;
        }
    }

    public SupportedDataType getDataType() {
        return dataType;
    }

    public void setDataType(SupportedDataType dataType) {
        this.dataType = dataType;
    }

    public boolean validateType(String dataType) {
        return Arrays.asList(getSupportedDataTypes()).contains(dataType.toUpperCase());
    }

    @Override
    public String toString() {
        return dataType.toString();
    }
}
