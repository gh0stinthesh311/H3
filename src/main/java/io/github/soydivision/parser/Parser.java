package io.github.soydivision.parser;

import io.github.soydivision.constants.SQLKeywords;
import io.github.soydivision.handlers.*;

import static io.github.soydivision.utils.StringUtils.normalize;

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
        String statementNormalized = normalize(SQLStatement);
        String[] SQL_StatementAsArray = statementNormalized.split(" ");
        if (SQL_StatementAsArray[0].toUpperCase().equals(SQLKeywords.select.getValue())) {
            this.dataQueryLanguageMaster.execute(statementNormalized);
        } else if (SQL_StatementAsArray[0].toUpperCase().equals(SQLKeywords.insert.getValue())
                || SQL_StatementAsArray[0].toUpperCase().equals(SQLKeywords.update.getValue())
                || SQL_StatementAsArray[0].toUpperCase().equals(SQLKeywords.delete.getValue())
        ) {
            this.dataManipulationLanguageMaster.execute(statementNormalized);
            //progress here
        } else if (SQL_StatementAsArray[0].toUpperCase().equals(SQLKeywords.create.getValue())
                || SQL_StatementAsArray[0].toUpperCase().equals(SQLKeywords.alter.getValue())
                || SQL_StatementAsArray[0].toUpperCase().equals(SQLKeywords.drop.getValue())
        ) {
            this.dataDefinitionLanguageMaster.execute(statementNormalized);
        } else if (SQL_StatementAsArray[0].toUpperCase().equals(SQLKeywords.begin.getValue())
                || SQL_StatementAsArray[0].toUpperCase().equals(SQLKeywords.commit.getValue())
                || SQL_StatementAsArray[0].toUpperCase().equals(SQLKeywords.rollback.getValue())
        ) {
            this.transactionControlLanguageMaster.execute(statementNormalized);
        } else if (SQL_StatementAsArray[0].toUpperCase().equals(SQLKeywords.grant.getValue())
                || SQL_StatementAsArray[0].toUpperCase().equals(SQLKeywords.revoke.getValue())
        ) {
            this.dataControlLanguageMaster.execute(statementNormalized);
        }
    }
}
