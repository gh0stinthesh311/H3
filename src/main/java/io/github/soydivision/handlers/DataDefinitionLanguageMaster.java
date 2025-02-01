package io.github.soydivision.handlers;

import io.github.soydivision.constants.SQLKeywords;
import io.github.soydivision.domain.Table;
import io.github.soydivision.memory.Memory;

import java.util.Arrays;

public class DataDefinitionLanguageMaster implements SqlExecutor {
    @Override
    public void execute(String sql) {
        String[] sqlArray = sql.split(" ");
        if (sqlArray[0].equals(SQLKeywords.create.getValue()) && sqlArray[1].equalsIgnoreCase("TABLE")) {
            Table table = new Table(sqlArray[2]);
            Memory.getInstance().getCurrentDatabase().addTable(table);
            System.out.println(Memory.getInstance());
        } else if (sqlArray[0].equalsIgnoreCase("DROP") && sqlArray[1].equalsIgnoreCase("TABLE")) {
            Memory.getInstance().getCurrentDatabase().dropTable(sqlArray[2]);
        } else if (sqlArray[0].equalsIgnoreCase("CREATE") && sqlArray[1].equalsIgnoreCase("DATABASE")) {
            Memory.getInstance().addDatabase(sqlArray[2]);
        } else if (sqlArray[0].equalsIgnoreCase("DROP") && sqlArray[1].equalsIgnoreCase("DATABASE")) {
            Memory.getInstance().dropDatabase(sqlArray[2]);
        }
    }

    public String extractColumnDefinitions(String SQL) {
        return SQL.substring(SQL.indexOf("(") + 1, SQL.indexOf(")"));

    }

    public void createTable() {


    }


}
