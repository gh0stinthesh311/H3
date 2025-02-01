package io.github.soydivision.constants;

public enum SQLKeywords {
    select("SELECT"),
    insert("INSERT"),
    update("UPDATE"),
    delete("DELETE"),
    create("CREATE"),
    alter("ALTER"),
    drop("DROP"),
    begin("BEGIN"),
    commit("COMMIT"),
    rollback("ROLLBACK"),
    grant("GRANT"),
    revoke("REVOKE"),
    where("WHERE"),
    from("FROM"),
    join("JOIN"),
    order("ORDER"),
    group("GROUP"),
    having("HAVING"),
    values("VALUES"),
    into("INTO"),
    set("SET");

    private String value;

    SQLKeywords(String value) {
        this.value = value;
    }

//    public static String[] getNames(Class<? extends Enum<?>> e) {
//        return Arrays.stream(e.getEnumConstants()).map(Enum::name).toArray(String[]::new);
//    }

    public String getValue() {
        return value;
    }

    public static String[] getSQLKeyWords() {
        String[] keywords = new String[SQLKeywords.values().length];
        int i = 0;
        for (SQLKeywords keyword : SQLKeywords.values()) {
            keywords[i++] = keyword.getValue();
        }
        return keywords;
    }
}


