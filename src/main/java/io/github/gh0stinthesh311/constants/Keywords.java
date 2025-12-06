package io.github.gh0stinthesh311.constants;

public enum Keywords {
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
    set("SET"),
    database("DATABASE"),
    asterisk("*"),
    table("TABLE");

    private String value;

    Keywords(String value) {
        this.value = value;
    }

//    public static String[] getNames(Class<? extends Enum<?>> e) {
//        return Arrays.stream(e.getEnumConstants()).map(Enum::name).toArray(String[]::new);
//    }

    public String getValue() {
        return value;
    }

    public static String[] getSQLKeyWords() {
        String[] keywords = new String[Keywords.values().length];
        int i = 0;
        for (Keywords keyword : Keywords.values()) {
            keywords[i++] = keyword.getValue();
        }
        return keywords;
    }
}


