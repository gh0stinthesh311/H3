package io.github.soydivision.parser;

import io.github.soydivision.constants.SQLKeywords;
import io.github.soydivision.handlers.*;

import java.util.Arrays;

import static io.github.soydivision.constants.SQLKeywords.getSQLKeyWords;

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

    // make static methods , or parser singleton
    @Override
    public void parse(String SQLStatement) {
        // Add normalizer here.
        System.out.println("Source statement: " + SQLStatement);
        String[] statementNormalized = normalize(SQLStatement);
        if (statementNormalized[0].toUpperCase().equals(SQLKeywords.select.getValue())) {
            this.dataQueryLanguageMaster.execute(statementNormalized);
        } else if (statementNormalized[0].toUpperCase().equals(SQLKeywords.insert.getValue())
                || statementNormalized[0].toUpperCase().equals(SQLKeywords.update.getValue())
                || statementNormalized[0].toUpperCase().equals(SQLKeywords.delete.getValue())
        ) {
            this.dataManipulationLanguageMaster.execute(statementNormalized);
        } else if (statementNormalized[0].toUpperCase().equals(SQLKeywords.create.getValue())
                || statementNormalized[0].toUpperCase().equals(SQLKeywords.alter.getValue())
                || statementNormalized[0].toUpperCase().equals(SQLKeywords.drop.getValue())
        ) {
            this.dataDefinitionLanguageMaster.execute(statementNormalized);
        } else if (statementNormalized[0].toUpperCase().equals(SQLKeywords.begin.getValue())
                || statementNormalized[0].toUpperCase().equals(SQLKeywords.commit.getValue())
                || statementNormalized[0].toUpperCase().equals(SQLKeywords.rollback.getValue())
        ) {
            this.transactionControlLanguageMaster.execute(statementNormalized);
        } else if (statementNormalized[0].toUpperCase().equals(SQLKeywords.grant.getValue())
                || statementNormalized[0].toUpperCase().equals(SQLKeywords.revoke.getValue())
        ) {
            this.dataControlLanguageMaster.execute(statementNormalized);
        }
    }

    @Override
    public String[] normalize(String sql) {
        String[] sourceQuery = sql.trim().replaceAll(" +", " ").split(" ");
        String[] keyWords = getSQLKeyWords();
        for (int i = 0; i < sourceQuery.length; i++) {
            for (int j = 0; j < keyWords.length; j++) {
                if (sourceQuery[i].toUpperCase().equals(keyWords[j])) {
                    System.out.println("SQL Key word found in query: " + sourceQuery[i]);
                    sourceQuery[i] = keyWords[j];
                }
            }
        }
        System.out.println("After normalizing: " + Arrays.toString(sourceQuery));
        // Also every key word should be casted to upper case, all key words
        // should be taken from constants
//        Arrays.stream(sql.trim().replaceAll(" +", " ").split(" ")).
//        return normalizedSQLQuery;
        return sourceQuery;
    }
    // validate SQL
}
