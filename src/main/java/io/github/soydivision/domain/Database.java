package io.github.soydivision.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Database {
    String name;
    String DEFAULT_DATABASE_NAME = "DEFAULT_DATABASE";
    private Map<String, Table> tables;

    int MAX_TABLES_NUMBER;

    public Database() {
        this.tables = new HashMap<>();
        this.name = DEFAULT_DATABASE_NAME;
    }

    public Database(String name) {
        this.tables = new HashMap<>();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Database " + this.getName() + " includes tables " + tables;
    }

    public void addTable(Table table) {
        this.tables.put(table.getName(), table);
    }

    public void dropTable(String name) {
        this.tables.remove(name);
    }

    public int getNumberOfTables() {
        return this.tables.size();
    }

    public List getTablesList() {
        return new ArrayList(this.tables.entrySet());
    }

    public Table getTableByName(String name) {
        return tables.get(name);
    }
}
