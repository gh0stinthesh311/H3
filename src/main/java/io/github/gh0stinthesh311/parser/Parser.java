package io.github.gh0stinthesh311.parser;

import io.github.gh0stinthesh311.constants.SQLKeywords;
import io.github.gh0stinthesh311.constants.SupportedDataTypes;
import io.github.gh0stinthesh311.constants.SysMessages;
import io.github.gh0stinthesh311.handlers.*;
import io.github.gh0stinthesh311.utils.LogUtil;

import java.util.Arrays;

import static io.github.gh0stinthesh311.utils.StringUtils.normalize;


// Goal of parser is to normalize initial statement and delegate execution to respective masters
// Master does not care about syntax, it expects it to be correct and ready to be executed,
// also master is case-insensitive.

public class Parser implements ParsingSQL {
    private final DataDefinitionLanguageMaster dataDefinitionLanguageMaster;
    private final DataQueryLanguageMaster dataQueryLanguageMaster;
    private final DataManipulationLanguageMaster dataManipulationLanguageMaster;
    private final TransactionControlLanguageMaster transactionControlLanguageMaster;
    private final DataControlLanguageMaster dataControlLanguageMaster;

    public Parser() {
        this.dataDefinitionLanguageMaster = new DataDefinitionLanguageMaster();
        this.dataQueryLanguageMaster = new DataQueryLanguageMaster();
        this.dataManipulationLanguageMaster = new DataManipulationLanguageMaster();
        this.transactionControlLanguageMaster = new TransactionControlLanguageMaster();
        this.dataControlLanguageMaster = new DataControlLanguageMaster();
    }

    @Override
    public void parse(String SQL) {
//        String normalizedSQL = normalize(SQL);
        String[] statementChopped = SQL.split(";");
        if (statementChopped.length > 1) {
            LogUtil.info(SysMessages.MULTI_QUERY_STATEMENT.getMessage() + "Includes " + statementChopped.length + " statements.");
//            for (String s : statementChopped) {
//                LogUtil.info("Executing "  + s);
//                execute(s);
//            }
            for (int i = 0; i < statementChopped.length; i++) {
                LogUtil.info("Executing statement from multiple query:" + statementChopped[i]);
                execute(normalize(statementChopped[i]));
            }
        } else {
            LogUtil.info("Executing single statement:" + SQL);
            execute(normalize(SQL));
        }
    }

    public void execute(String SQL) {
//        String SQLStatement_normalized = normalize(SQL);
        String[] SQL_StatementAsArray = SQL.split(" ");
        if (SQL_StatementAsArray[0].toUpperCase().equalsIgnoreCase(SQLKeywords.select.getValue())) {
            this.dataQueryLanguageMaster.execute(SQL);
        } else if (SQL_StatementAsArray[0].toUpperCase().equalsIgnoreCase(SQLKeywords.create.getValue())
                || SQL_StatementAsArray[0].toUpperCase().equalsIgnoreCase(SQLKeywords.alter.getValue())
                || SQL_StatementAsArray[0].toUpperCase().equalsIgnoreCase(SQLKeywords.drop.getValue())
        ) {
            this.dataDefinitionLanguageMaster.execute(SQL);
        } else if (SQL_StatementAsArray[0].toUpperCase().equalsIgnoreCase(SQLKeywords.insert.getValue())
                || SQL_StatementAsArray[0].toUpperCase().equalsIgnoreCase(SQLKeywords.update.getValue())
                || SQL_StatementAsArray[0].toUpperCase().equalsIgnoreCase(SQLKeywords.delete.getValue())
        ) {
            this.dataManipulationLanguageMaster.execute(SQL);
        } else if (SQL_StatementAsArray[0].toUpperCase().equalsIgnoreCase(SQLKeywords.begin.getValue())
                || SQL_StatementAsArray[0].toUpperCase().equalsIgnoreCase(SQLKeywords.commit.getValue())
                || SQL_StatementAsArray[0].toUpperCase().equalsIgnoreCase(SQLKeywords.rollback.getValue())
        ) {
            this.transactionControlLanguageMaster.execute(SQL);
        } else if (SQL_StatementAsArray[0].toUpperCase().equalsIgnoreCase(SQLKeywords.grant.getValue())
                || SQL_StatementAsArray[0].toUpperCase().equalsIgnoreCase(SQLKeywords.revoke.getValue())
        ) {
            this.dataControlLanguageMaster.execute(SQL);
        }

    }
}
