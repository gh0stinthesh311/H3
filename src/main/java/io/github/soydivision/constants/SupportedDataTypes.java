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

    public static String[] getSupportedDataTypes() {
        String[] supportedDataTypes = new String[SupportedDataTypes.values().length];
        int i = 0;
        for (SupportedDataTypes supportedDataType : SupportedDataTypes.values()) {
            supportedDataTypes[i++] = supportedDataType.name().toString();
        }
        return supportedDataTypes;
    }
}
