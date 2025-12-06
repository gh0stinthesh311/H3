package io.github.gh0stinthesh311.parser;

import io.github.gh0stinthesh311.constants.Keywords;
import io.github.gh0stinthesh311.constants.SysMessages;
import io.github.gh0stinthesh311.handlers.*;
import io.github.gh0stinthesh311.utils.Formatter;
import io.github.gh0stinthesh311.utils.LogUtil;

import java.sql.Wrapper;

import static io.github.gh0stinthesh311.utils.StringUtils.normalize;
import static io.github.gh0stinthesh311.utils.StringUtils.validateBracketBalance;

// Goal of parser is to normalize initial statement and delegate execution to respective masters
// Master does not care about syntax, it expects it to be correct and ready to be executed,
// also master is case-insensitive.

public class Parser implements ParsingSQL {
    private final DataDefinitionLanguageMaster dataDefinitionLanguageMaster;// create, drop table
    private final DataManipulationLanguageMaster dataManipulationLanguageMaster; // insert update delete data
    private final DataQueryLanguageMaster dataQueryLanguageMaster; // select from
    private final TransactionControlLanguageMaster transactionControlLanguageMaster; //
    private final DataControlLanguageMaster dataControlLanguageMaster;

    public Parser() {
        this.dataDefinitionLanguageMaster = new DataDefinitionLanguageMaster();
        this.dataQueryLanguageMaster = new DataQueryLanguageMaster();
        this.dataManipulationLanguageMaster = new DataManipulationLanguageMaster();
        this.transactionControlLanguageMaster = new TransactionControlLanguageMaster();
        this.dataControlLanguageMaster = new DataControlLanguageMaster();
    }

//    @Override
//    public void parse(String SQL) {
//        String normalizedSQL = normalize(SQL);
//        // validate brackets
// // get rid of if because it does not matter
//        String[] statementChopped = normalizedSQL.split(";");
//        if (statementChopped.length > 1) {
//            LogUtil.info(SysMessages.MULTI_QUERY_STATEMENT.getMessage() + "Includes " + statementChopped.length + " statements.");
//            for (int i = 0; i < statementChopped.length; i++) {
//                int j = i + 1; // human-readable counter for an output
//                LogUtil.info("Executing statement number " + j + " from multiple query:" + Formatter.wrapWithQuotes(statementChopped[i]));
//                delegateExecution(normalize(statementChopped[i]));
//            }
//        } else {
////            LogUtil.info("Executing single statement " + Formatter.wrapWithQuotes(normalizedSQL));
//            delegateExecution(normalizedSQL);
//        }
//    }

    @Override
    public void parse(String SQL) {
        String[] statementChopped = SQL.split(";");
        for (int i = 0; i < statementChopped.length; i++) {
            if (validateBracketBalance(statementChopped[i])) {
                String normalizedSQLStatement = normalize(statementChopped[i]);
                LogUtil.info("Executing statement " + Formatter.wrapWithQuotes(normalizedSQLStatement));
                delegateExecution(normalizedSQLStatement);
            } else {
                LogUtil.info("Bracket validation failed for " + Formatter.wrapWithQuotes(statementChopped[i]));
            }
        }
    }


    public void delegateExecution(String SQL) {
        String[] SQL_StatementAsArray = SQL.split(" ");
        if (SQL_StatementAsArray[0].toUpperCase().equalsIgnoreCase(Keywords.select.getValue())) { // in progress
            this.dataQueryLanguageMaster.execute(SQL);
        } else if (SQL_StatementAsArray[0].toUpperCase().equalsIgnoreCase(Keywords.create.getValue()) // works
                || SQL_StatementAsArray[0].toUpperCase().equalsIgnoreCase(Keywords.alter.getValue())
                || SQL_StatementAsArray[0].toUpperCase().equalsIgnoreCase(Keywords.drop.getValue()) // works
        ) {
            this.dataDefinitionLanguageMaster.execute(SQL);
        } else if (SQL_StatementAsArray[0].toUpperCase().equalsIgnoreCase(Keywords.insert.getValue()) // works
                || SQL_StatementAsArray[0].toUpperCase().equalsIgnoreCase(Keywords.update.getValue())
                || SQL_StatementAsArray[0].toUpperCase().equalsIgnoreCase(Keywords.delete.getValue())
        ) {
            this.dataManipulationLanguageMaster.execute(SQL);
        } else if (SQL_StatementAsArray[0].toUpperCase().equalsIgnoreCase(Keywords.begin.getValue())
                || SQL_StatementAsArray[0].toUpperCase().equalsIgnoreCase(Keywords.commit.getValue())
                || SQL_StatementAsArray[0].toUpperCase().equalsIgnoreCase(Keywords.rollback.getValue())
        ) {
            this.transactionControlLanguageMaster.execute(SQL);
        } else if (SQL_StatementAsArray[0].toUpperCase().equalsIgnoreCase(Keywords.grant.getValue())
                || SQL_StatementAsArray[0].toUpperCase().equalsIgnoreCase(Keywords.revoke.getValue())
        ) {
            this.dataControlLanguageMaster.execute(SQL);
        } else {
            LogUtil.info("Not a sql statement " + Formatter.wrapWithQuotes(SQL));
        }
    }
}
