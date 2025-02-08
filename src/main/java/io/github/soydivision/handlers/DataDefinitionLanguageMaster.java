package io.github.soydivision.handlers;

import io.github.soydivision.constants.SQLKeywords;
import io.github.soydivision.constants.SupportedDataTypes;
import io.github.soydivision.domain.Column;
import io.github.soydivision.domain.Table;
import io.github.soydivision.memory.Memory;

import java.lang.reflect.Array;
import java.util.Arrays;

public class DataDefinitionLanguageMaster implements SqlExecutor {
    @Override
    public void execute(String SQL) {
        String[] sqlArray = SQL.split(" ");
        if (sqlArray[0].equals(SQLKeywords.create.getValue()) && sqlArray[1].equalsIgnoreCase("TABLE")) {
            Table table = new Table(sqlArray[2]);
            Memory.getInstance().getCurrentDatabase().addTable(table);
            createColumns(SQL, table);

        } else if (sqlArray[0].equalsIgnoreCase("DROP") && sqlArray[1].equalsIgnoreCase("TABLE")) {
            Memory.getInstance().getCurrentDatabase().dropTable(sqlArray[2]);
        } else if (sqlArray[0].equalsIgnoreCase("CREATE") && sqlArray[1].equalsIgnoreCase("DATABASE")) {
            Memory.getInstance().addDatabase(sqlArray[2]);
        } else if (sqlArray[0].equalsIgnoreCase("DROP") && sqlArray[1].equalsIgnoreCase("DATABASE")) {
            Memory.getInstance().dropDatabase(sqlArray[2]);
        }
    }

    public String extractColumnDefinitions(String SQL) {
        return SQL.substring(SQL.indexOf("(") + 1, SQL.lastIndexOf(")"));
    }

    public void createTable() {
    }

    public void dropTable() {
    }

    public void createDatabase() {
    }

    public void dropDatabase() {
    }

    public void createColumns(String SQL, Table table) {
        String[] columnDefinitions = extractColumnDefinitions(SQL).split(",");
         for (int i = 0; i < columnDefinitions.length; i++) {
//            table.addColumn(columnDefinitions[i]);
//            parseColumnDefinition(columnDefinitions[i]);

            parseColumnDefinition(columnDefinitions[i]);
        }
    }

    public void parseColumnDefinition(String columnDefinition) {
        String[] columnDefinitionTokens = columnDefinition.split(" ");
//        if (columnDefinitionTokens[1].toUpperCase().equals(SupportedDataTypes.INT.name())) {
//            System.out.println("INT data type found");
//        }
        System.out.println(Arrays.asList(columnDefinitionTokens));

    }
}
