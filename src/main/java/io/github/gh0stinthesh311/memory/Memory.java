package io.github.gh0stinthesh311.memory;

import io.github.gh0stinthesh311.domain.Database;
import io.github.gh0stinthesh311.utils.LogUtil;

import java.util.HashMap;
import java.util.Map;

import static io.github.gh0stinthesh311.utils.Formatter.wrapWithQuotes;

public class Memory {
    private Map<String, Database> databases = new HashMap<>();
    private static Memory instance = null;
    private Database currentDatabase;

    private Memory() {
        Database defaultDatabase = new Database();
        this.databases.put(defaultDatabase.getDBName(), defaultDatabase);
        this.currentDatabase = defaultDatabase;
    }

    public static synchronized Memory getInstance() {
        if (instance == null)
            instance = new Memory();
        return instance;
    }

    @Override
    public String toString() {
        return "Database(s) in memory " + databases.size() + ", " + databases; // to do list names and print
    }

    public void addDatabase(String databaseName) {
        this.databases.put(databaseName, new Database(databaseName));
//        System.out.println("Database added to memory: " + databaseName);
        // to do add log here
    }

    public void dropDatabase(String databaseName) {
//        this.databases.remove(databaseName);
//        System.out.println("Database removed from memory: " + databaseName);
//        LogUtil.info("Database removed from memory:" + wrapWithQuotes(databaseName));
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
