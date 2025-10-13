package io.github.gh0stinthesh311.handlers;

import io.github.gh0stinthesh311.constants.SQLKeywords;
import io.github.gh0stinthesh311.memory.Memory;

public class DataDefinitionLanguageMaster implements SqlExecutor {
    @Override
    public void execute(String SQL) {
        String[] sqlAsArray = SQL.split(" ");
        if (sqlAsArray[0].equalsIgnoreCase(SQLKeywords.create.getValue())
                && sqlAsArray[1].equalsIgnoreCase(SQLKeywords.table.getValue())) {
            Memory.getInstance().getCurrentDatabase().createTable(SQL, sqlAsArray);
        } else if (sqlAsArray[0].equalsIgnoreCase(SQLKeywords.drop.getValue())
                && sqlAsArray[1].equalsIgnoreCase(SQLKeywords.table.getValue())) {
            Memory.getInstance().getCurrentDatabase().dropTable(sqlAsArray[2]);
        } else if (sqlAsArray[0].equalsIgnoreCase(SQLKeywords.create.getValue())
                && sqlAsArray[1].equalsIgnoreCase(SQLKeywords.database.getValue())) {
            Memory.getInstance().addDatabase(sqlAsArray[2]);
        } else if (sqlAsArray[0].equalsIgnoreCase(SQLKeywords.drop.getValue())
                && sqlAsArray[1].equalsIgnoreCase(SQLKeywords.database.getValue())) {
            Memory.getInstance().dropDatabase(sqlAsArray[2]);
        }
    }
}
//    public void createTable() {
//    }
//
//    public void dropTable() {
//    }
//
//    public void createDatabase() {
//    }
//
//    public void dropDatabase() {
//    }

//    public void createColumns(String SQL, Table table) {
//        String[] columnDefinitions = extractColumnDefinitions(SQL).split(",");
//        for (String columnDefinition : columnDefinitions) {
//            LogUtil.info("Parsing column definition: " + columnDefinition);
//            String[] parsedColumnDefinition = parseAndReturnColumnDefinition(columnDefinition);
//            table.addColumn(parsedColumnDefinition[0], parsedColumnDefinition[1]);
//        }
//    }

