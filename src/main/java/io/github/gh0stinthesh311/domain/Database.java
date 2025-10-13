package io.github.gh0stinthesh311.domain;

import io.github.gh0stinthesh311.memory.Memory;
import io.github.gh0stinthesh311.utils.LogUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.github.gh0stinthesh311.utils.Formatter.wrapWithQuotes;

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

    public String getDBName() {
        return name;
    }

    public void setDBName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Database " + this.getDBName() + " includes tables " + tables;
    }

    public void addTable(Table table) {
        if (this.tables.keySet().contains(table.getName())) {
            LogUtil.info("Table " + table.getName() + " already exists in " + this.getDBName());
        } else
            LogUtil.info("Adding table " + wrapWithQuotes(table.getName()) + " to database " + wrapWithQuotes(this.getDBName()));
        this.tables.put(table.getName(), table);
        LogUtil.info(wrapWithQuotes(this.getDBName()) + " database contains following table(s) " +
                wrapWithQuotes(String.join(",", this.tables.keySet())));
    }

    public void dropTable(String name) {
        if (tables.containsKey(name)) {
            LogUtil.info("Dropping table " + wrapWithQuotes(name) + " from database " + wrapWithQuotes(this.getDBName()));
            this.tables.remove(name);
        } else
            LogUtil.error("No " + wrapWithQuotes(name) + " table found in " + wrapWithQuotes(this.getDBName()));
    }


    // to do also add method that can accept table and remove based on object passed , not only by name


    public void createTable(String SQL, String[] sqlAsArray) {
        Table table = new Table(sqlAsArray[2]);
        LogUtil.info("Creating table " + wrapWithQuotes(table.getName()));
        Memory.getInstance().getCurrentDatabase().addTable(table);
        table.createColumns(SQL, table);
    }

    public int getNumberOfTables() {
        return this.tables.size();
    }

    public List getTablesList() {
        return new ArrayList(this.tables.entrySet());
    }

    public Table getTableByName(String name) {
        LogUtil.info("Table " + wrapWithQuotes(name) + " selected");
        if (this.tables.containsKey(name)) {
            return tables.get(name);
        } else return null;
    }
}
