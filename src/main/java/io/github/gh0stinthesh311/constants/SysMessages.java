package io.github.gh0stinthesh311.constants;

public enum SysMessages {
    DATATYPE_FOUND(" data type found"),
    DATATYPE_NOT_FOUND(" is not a supported data type"),
    SUCCESS_CREATE("Successfully created."),
    SUCCESS_UPDATE("Successfully updated."),
    SUCCESS_DELETE("Successfully deleted."),
    ERROR_NOT_FOUND("Record not found."),
    ERROR_DUPLICATE("Duplicate entry detected."),
    ERROR_DATABASE("Database error occurred."),
    MAX_TABLE_SIZE_EXCEEDED("Exceeded max table size.");

    private String message;

    SysMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
