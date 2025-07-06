package io.github.gh0stinthesh311.constants;

public enum SupportedDataType {
    INT(Integer.class),
    VARCHAR(String.class),
    TEXT(String.class),
    BOOLEAN(Boolean.class),
    DATE(java.util.Date.class),
    TIME(java.sql.Time.class);

    private final Class<?> associatedClass;

    SupportedDataType(Class<?> associatedClass) {
        this.associatedClass = associatedClass;
    }

    public Class<?> getAssociatedClass() {
        return associatedClass;
    }

    public static String[] getSupportedDataTypes() {
        String[] supportedDataTypes = new String[SupportedDataType.values().length];
        int i = 0;
        for (SupportedDataType supportedDataType : SupportedDataType.values()) {
            supportedDataTypes[i++] = supportedDataType.name().toString();
        }
        return supportedDataTypes;
    }
}
