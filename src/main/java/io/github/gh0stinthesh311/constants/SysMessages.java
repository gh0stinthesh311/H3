package io.github.gh0stinthesh311.constants;

public enum SysMessages {
    DATATYPE_FOUND(" data type found"),


    SUCCESS_CREATE("Successfully created."),
    SUCCESS_UPDATE("Successfully updated."),
    SUCCESS_DELETE("Successfully deleted."),
    ERROR_NOT_FOUND("Record not found."),
    ERROR_DUPLICATE("Duplicate entry detected."),
    ERROR_DATABASE("Database error occurred.");

    private String message;

    SysMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
