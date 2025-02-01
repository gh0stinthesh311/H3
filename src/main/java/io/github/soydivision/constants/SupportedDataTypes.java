package io.github.soydivision.constants;

public enum SupportedDataTypes {
    INT(Integer.class),
    VARCHAR(String.class),
    TEXT(String.class),
    BOOLEAN(Boolean.class),
    DATE(java.util.Date.class),
    TIME(java.sql.Time.class);

    private final Class<?> associatedClass;

    SupportedDataTypes(Class<?> associatedClass) {
        this.associatedClass = associatedClass;
    }

    public Class<?> getAssociatedClass() {
        return associatedClass;
    }
}
