package io.github.gh0stinthesh311.parser;

import io.github.gh0stinthesh311.constants.SQLKeywords;
import io.github.gh0stinthesh311.handlers.*;
import io.github.gh0stinthesh311.utils.LogUtil;

import static io.github.gh0stinthesh311.utils.StringUtils.normalize;


// Goal of parser is to normalize initial statement and delegate execution to respective masters
// Master does not care about syntax, it expects it to be correct and ready to be executed

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
    public void parse(String SQLStatement) {
        String SQLStatement_normalized = normalize(SQLStatement);
        String[] SQL_StatementAsArray = SQLStatement_normalized.split(" ");
        LogUtil.info("SQL statement after normalizing: " + SQLStatement_normalized);
        if (SQL_StatementAsArray[0].toUpperCase().equalsIgnoreCase(SQLKeywords.select.getValue())) {
            this.dataQueryLanguageMaster.execute(SQLStatement_normalized);
        } else if (SQL_StatementAsArray[0].toUpperCase().equalsIgnoreCase(SQLKeywords.create.getValue())
                || SQL_StatementAsArray[0].toUpperCase().equalsIgnoreCase(SQLKeywords.alter.getValue())
                || SQL_StatementAsArray[0].toUpperCase().equalsIgnoreCase(SQLKeywords.drop.getValue())
        ) {
            this.dataDefinitionLanguageMaster.execute(SQLStatement_normalized);
        } else if (SQL_StatementAsArray[0].toUpperCase().equalsIgnoreCase(SQLKeywords.insert.getValue())
                || SQL_StatementAsArray[0].toUpperCase().equalsIgnoreCase(SQLKeywords.update.getValue())
                || SQL_StatementAsArray[0].toUpperCase().equalsIgnoreCase(SQLKeywords.delete.getValue())
        ) {
            this.dataManipulationLanguageMaster.execute(SQLStatement_normalized);
        } else if (SQL_StatementAsArray[0].toUpperCase().equalsIgnoreCase(SQLKeywords.begin.getValue())
                || SQL_StatementAsArray[0].toUpperCase().equalsIgnoreCase(SQLKeywords.commit.getValue())
                || SQL_StatementAsArray[0].toUpperCase().equalsIgnoreCase(SQLKeywords.rollback.getValue())
        ) {
            this.transactionControlLanguageMaster.execute(SQLStatement_normalized);
        } else if (SQL_StatementAsArray[0].toUpperCase().equalsIgnoreCase(SQLKeywords.grant.getValue())
                || SQL_StatementAsArray[0].toUpperCase().equalsIgnoreCase(SQLKeywords.revoke.getValue())
        ) {
            this.dataControlLanguageMaster.execute(SQLStatement_normalized);
        }


    }
}
