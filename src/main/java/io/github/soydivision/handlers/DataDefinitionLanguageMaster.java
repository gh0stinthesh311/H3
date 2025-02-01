package io.github.soydivision.handlers;

import io.github.soydivision.domain.Table;
import io.github.soydivision.memory.Memory;

public class DataDefinitionLanguageMaster implements SqlExecutor {
    @Override
    public void execute(String[] sql) {
        if (sql[0].equalsIgnoreCase("CREATE") && sql[1].equalsIgnoreCase("TABLE")) {
            Table table = new Table(sql[2]);
            Memory.getInstance().getCurrentDatabase().addTable(table);
        } else if (sql[0].equalsIgnoreCase("DROP") && sql[1].equalsIgnoreCase("TABLE")) {
            Memory.getInstance().getCurrentDatabase().dropTable(sql[2]);
        } else if (sql[0].equalsIgnoreCase("CREATE") && sql[1].equalsIgnoreCase("DATABASE")) {
            Memory.getInstance().addDatabase(sql[2]);
        } else if (sql[0].equalsIgnoreCase("DROP") && sql[1].equalsIgnoreCase("DATABASE")) {
            Memory.getInstance().dropDatabase(sql[2]);
        }
    }
}
