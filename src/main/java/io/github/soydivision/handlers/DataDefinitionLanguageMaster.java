package io.github.soydivision.handlers;

import io.github.soydivision.constants.SQLKeywords;
import io.github.soydivision.constants.SupportedDataTypes;
import io.github.soydivision.constants.SysMessages;
import io.github.soydivision.domain.Table;
import io.github.soydivision.memory.Memory;
import io.github.soydivision.utils.LogUtil;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class DataDefinitionLanguageMaster implements SqlExecutor {
    @Override
    public void execute(String SQL) {
        String[] sqlArray = SQL.split(" ");
        if (sqlArray[0].equals(SQLKeywords.create.getValue()) && sqlArray[1].equalsIgnoreCase("TABLE")) {
            LogUtil.info("Creating table: " + sqlArray[2]);
            String tableName = sqlArray[2];
            Table table = new Table(tableName);
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
        String columnDefinitions = SQL.substring(SQL.indexOf("(") + 1, SQL.lastIndexOf(")")).trim();
        LogUtil.info("Extracted column definitions: " + columnDefinitions);
        return columnDefinitions;
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
//            table.addColumn(columnDefinitions[i]); to do
//            System.out.println("Parsing column definition:" + columnDefinitions[i]);
            LogUtil.info("Parsing column definition: " + columnDefinitions[i]);
            parseColumnDefinition(columnDefinitions[i]);
        }
    }

    public void parseColumnDefinition(String columnDefinition) {
        String[] columnDefinitionTokens = columnDefinition.split(" ");
        // removes "(", ")" and everything in between, so that VARCHAR(188) -> VARCHAR
        String dataTypeParameterRemoved = columnDefinitionTokens[1].replaceAll("\\([^)]*\\)", "");
//
//        if (dataTypeParameterRemoved.toUpperCase().equals(SupportedDataTypes.INT.name())) {
//            LogUtil.info(SupportedDataTypes.INT.name() + SysMessages.DATATYPE_FOUND.getMessage());
//        } else if (dataTypeParameterRemoved.toUpperCase().equals(SupportedDataTypes.VARCHAR.name())) {
//            LogUtil.info(SupportedDataTypes.VARCHAR.name() + SysMessages.DATATYPE_FOUND.getMessage());
//        } else if (dataTypeParameterRemoved.toUpperCase().equals(SupportedDataTypes.TEXT.name())) {
//            LogUtil.info(SupportedDataTypes.TEXT.name() + SysMessages.DATATYPE_FOUND.getMessage());
//        } else if (dataTypeParameterRemoved.toUpperCase().equals(SupportedDataTypes.BOOLEAN.name())) {
//            LogUtil.info(SupportedDataTypes.BOOLEAN.name() + SysMessages.DATATYPE_FOUND.getMessage());
//        } else if (dataTypeParameterRemoved.toUpperCase().equals(SupportedDataTypes.DATE.name())) {
//            LogUtil.info(SupportedDataTypes.DATE.name() + SysMessages.DATATYPE_FOUND.getMessage());
//        } else if (dataTypeParameterRemoved.toUpperCase().equals(SupportedDataTypes.TIME.name())) {
//            LogUtil.info(SupportedDataTypes.TIME.name() + SysMessages.DATATYPE_FOUND.getMessage());
//        }
//        System.out.println(Arrays.asList(columnDefinitionTokens));
        Set<String> supportedTypes = Arrays.stream(SupportedDataTypes.values())
                .map(Enum::name)
                .collect(Collectors.toSet());

        if (supportedTypes.contains(dataTypeParameterRemoved.toUpperCase())) {
            LogUtil.info(dataTypeParameterRemoved.toUpperCase() + SysMessages.DATATYPE_FOUND.getMessage());
        } else {
            LogUtil.warn(dataTypeParameterRemoved.toUpperCase() + " is not a supported data type.");
        }
    }
}
