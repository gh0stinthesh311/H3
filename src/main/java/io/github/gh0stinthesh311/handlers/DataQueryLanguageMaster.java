package io.github.gh0stinthesh311.handlers;

import io.github.gh0stinthesh311.constants.Keywords;
import io.github.gh0stinthesh311.memory.Memory;

import java.util.List;

public class DataQueryLanguageMaster implements SqlExecutor {
    @Override
    public void execute(String SQL) {
        String[] sqlArray = SQL.split(" ");
        if (sqlArray[0].equalsIgnoreCase(Keywords.select.getValue())
                && sqlArray[1].equalsIgnoreCase(Keywords.asterisk.getValue())) {
            List<?> rows = Memory.getInstance().getCurrentDatabase().getTableByName(sqlArray[3]).getRows();
            System.out.println(rows);
            //To do pretty print
        } else if (true) {
            System.out.println("Next option here");
        }
    }
}
