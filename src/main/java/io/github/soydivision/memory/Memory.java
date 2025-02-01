package io.github.soydivision.memory;

import io.github.soydivision.domain.Database;

import java.util.HashMap;
import java.util.Map;

public class Memory {
    private Map<String, Database> databases = new HashMap<>();
    private static Memory instance = null;
    private Database currentDatabase;

    private Memory() {
        Database defaultDatabase = new Database();
        this.databases.put(defaultDatabase.getName(), defaultDatabase);
        this.currentDatabase = defaultDatabase;
    }

    public static synchronized Memory getInstance() {
        if (instance == null)
            instance = new Memory();
        return instance;
    }

    @Override
    public String toString() {
        return "Database(s) in memory:" + databases.size() + ", " + databases;
    }

    public void addDatabase(String databaseName) {
        this.databases.put(databaseName, new Database(databaseName));
        System.out.println("Database added to memory: " + databaseName);
    }

    public void dropDatabase(String databaseName) {
        this.databases.remove(databaseName);
        System.out.println("Database removed from memory: " + databaseName);
    }

    public Database getCurrentDatabase() {
        return currentDatabase;
    }

    public void setCurrentDatabase(Database currentDatabase) {
        this.currentDatabase = currentDatabase;
    }

    public Map<String, Database> getDatabases() {
        return databases;
    }

    public int getNumberOfDatabases() {
        return databases.size();
    }


}
