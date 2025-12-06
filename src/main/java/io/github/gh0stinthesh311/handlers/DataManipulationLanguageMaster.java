package io.github.gh0stinthesh311.handlers;

import io.github.gh0stinthesh311.constants.Keywords;
import io.github.gh0stinthesh311.memory.Memory;

public class DataManipulationLanguageMaster implements SqlExecutor {
    @Override
    public void execute(String SQL) {
        String[] sqlArray = SQL.split(" ");
        if (sqlArray[0].equalsIgnoreCase(Keywords.insert.getValue()) && sqlArray[1].equalsIgnoreCase(Keywords.into.getValue())) {
            Memory.getInstance().getCurrentDatabase().getTableByName(sqlArray[2]).addRow(SQL);
        } else if (sqlArray[0].equalsIgnoreCase(Keywords.update.getValue())) {
            System.out.println("To be Implemented");
        } else if (sqlArray[0].equalsIgnoreCase(Keywords.delete.getValue()) && sqlArray[1].equalsIgnoreCase(Keywords.from.getValue())) {
            System.out.println("To be Implemented");
        }
    }
}
