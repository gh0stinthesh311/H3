package io.github.gh0stinthesh311.handlers;

import io.github.gh0stinthesh311.constants.SQLKeywords;
import io.github.gh0stinthesh311.domain.Table;
import io.github.gh0stinthesh311.memory.Memory;
import io.github.gh0stinthesh311.utils.LogUtil;

public class DataManipulationLanguageMaster implements SqlExecutor {
    @Override
    public void execute(String SQL) {
        String[] sqlArray = SQL.split(" ");
        if (sqlArray[0].equalsIgnoreCase(SQLKeywords.insert.getValue()) && sqlArray[1].equalsIgnoreCase(SQLKeywords.into.getValue())) {
            Memory.getInstance().getCurrentDatabase().getTableByName(sqlArray[2]).addRow(SQL);
            // Parse row from sql, get column definitions from sql
            // make hashmap key is column name and value is value added. Iterate through hashmap to see if table
            // has columns that are being populated
            // but first and foremost the bracket problem needs to be solved
            // function like getValueBetweenBracketsNumber(1)

        } else if (sqlArray[0].equalsIgnoreCase(SQLKeywords.drop.getValue()) && sqlArray[1].equalsIgnoreCase(SQLKeywords.table.getValue())) {
            // Memory.getInstance().getCurrentDatabase().dropTable(sqlArray[2]);
        }
    }
}
