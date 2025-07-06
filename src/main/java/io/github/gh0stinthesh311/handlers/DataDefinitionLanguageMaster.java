package io.github.gh0stinthesh311.handlers;

import io.github.gh0stinthesh311.constants.SQLKeywords;
import io.github.gh0stinthesh311.domain.Table;
import io.github.gh0stinthesh311.memory.Memory;
import io.github.gh0stinthesh311.utils.LogUtil;

public class DataDefinitionLanguageMaster implements SqlExecutor {
    @Override
    public void execute(String SQL) {
        String[] sqlArray = SQL.split(" ");
        if (sqlArray[0].equalsIgnoreCase(SQLKeywords.create.getValue()) && sqlArray[1].equalsIgnoreCase("TABLE")) {
            LogUtil.info("Creating table " + sqlArray[2]);
            String tableName = sqlArray[2];
            Table table = new Table(tableName);
            Memory.getInstance().getCurrentDatabase().addTable(table);
            table.createColumns(SQL, table);
        } else if (sqlArray[0].equalsIgnoreCase(SQLKeywords.drop.getValue()) && sqlArray[1].equalsIgnoreCase(SQLKeywords.table.getValue())) {
            Memory.getInstance().getCurrentDatabase().dropTable(sqlArray[2]);
        } else if (sqlArray[0].equalsIgnoreCase(SQLKeywords.create.getValue()) && sqlArray[1].equalsIgnoreCase(SQLKeywords.database.getValue())) {
            Memory.getInstance().addDatabase(sqlArray[2]);
        } else if (sqlArray[0].equalsIgnoreCase(SQLKeywords.drop.getValue()) && sqlArray[1].equalsIgnoreCase(SQLKeywords.database.getValue())) {
            Memory.getInstance().dropDatabase(sqlArray[2]);
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


}
