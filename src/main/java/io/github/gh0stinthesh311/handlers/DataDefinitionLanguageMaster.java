package io.github.gh0stinthesh311.handlers;

import io.github.gh0stinthesh311.constants.Keywords;
import io.github.gh0stinthesh311.memory.Memory;

public class DataDefinitionLanguageMaster implements SqlExecutor {

    @Override
    public void execute(String SQL) {
        String[] sqlAsArray = SQL.split(" ");
        if (sqlAsArray[0].equalsIgnoreCase(Keywords.create.getValue())
                && sqlAsArray[1].equalsIgnoreCase(Keywords.table.getValue())) {
            Memory.getInstance().getCurrentDatabase().createTable(SQL);
        } else if (sqlAsArray[0].equalsIgnoreCase(Keywords.drop.getValue())
                && sqlAsArray[1].equalsIgnoreCase(Keywords.table.getValue())) {
            Memory.getInstance().getCurrentDatabase().dropTable(sqlAsArray[2]);
        } else if (sqlAsArray[0].equalsIgnoreCase(Keywords.create.getValue())
                && sqlAsArray[1].equalsIgnoreCase(Keywords.database.getValue())) {
            Memory.getInstance().addDatabase(sqlAsArray[2]);
        } else if (sqlAsArray[0].equalsIgnoreCase(Keywords.drop.getValue())
                && sqlAsArray[1].equalsIgnoreCase(Keywords.database.getValue())) {
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

