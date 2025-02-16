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
        String[] SQLstatementAsArray = statementNormalized.split(" ");
        if (SQLstatementAsArray[0].toUpperCase().equals(SQLKeywords.select.getValue())) {
            this.dataQueryLanguageMaster.execute(statementNormalized);
        } else if (SQLstatementAsArray[0].toUpperCase().equals(SQLKeywords.insert.getValue())
                || SQLstatementAsArray[0].toUpperCase().equals(SQLKeywords.update.getValue())
                || SQLstatementAsArray[0].toUpperCase().equals(SQLKeywords.delete.getValue())
        ) {
            this.dataManipulationLanguageMaster.execute(statementNormalized);
            //progress here
        } else if (SQLstatementAsArray[0].toUpperCase().equals(SQLKeywords.create.getValue())
                || SQLstatementAsArray[0].toUpperCase().equals(SQLKeywords.alter.getValue())
                || SQLstatementAsArray[0].toUpperCase().equals(SQLKeywords.drop.getValue())
        ) {
            this.dataDefinitionLanguageMaster.execute(statementNormalized);
        } else if (SQLstatementAsArray[0].toUpperCase().equals(SQLKeywords.begin.getValue())
                || SQLstatementAsArray[0].toUpperCase().equals(SQLKeywords.commit.getValue())
                || SQLstatementAsArray[0].toUpperCase().equals(SQLKeywords.rollback.getValue())
        ) {
            this.transactionControlLanguageMaster.execute(statementNormalized);
        } else if (SQLstatementAsArray[0].toUpperCase().equals(SQLKeywords.grant.getValue())
                || SQLstatementAsArray[0].toUpperCase().equals(SQLKeywords.revoke.getValue())
        ) {
            this.dataControlLanguageMaster.execute(statementNormalized);
        }
    }
}
