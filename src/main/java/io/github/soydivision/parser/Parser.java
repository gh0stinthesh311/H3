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
//        System.out.println("Source statement: " + SQLStatement);
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

    //    @Override
    public String normalize(String sql) {
        String[] trimmedSQL = sql.trim().replaceAll(" +", " ").split(" ");
        String[] keyWords = getSQLKeyWords();
        // This cycle replaces all SQL keywords found SQLKeywords.class with upper case characters.
        // Example: seLEct -> SELECT
        for (int i = 0; i < trimmedSQL.length; i++) {
            for (int j = 0; j < keyWords.length; j++) {
                if (trimmedSQL[i].toUpperCase().equals(keyWords[j])) {
//                    System.out.println("SQL Key word found in query: " + trimmedSQL[i]);
                    trimmedSQL[i] = keyWords[j];
                }
            }
        }
        // Following cycle builds String from Array of Strings (String[]) but with all keywords normalized
        // (case capitalized).
        // Notice first element is appended by default and subsequent elements appended with initial space.
        // We need to have space between them.
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(trimmedSQL[0]);
        for (int i = 1; i < trimmedSQL.length; i++) {
            stringBuilder.append(" ");
            stringBuilder.append(trimmedSQL[i]);
        }
        String trimmedSQLString = stringBuilder.toString();


        // Also every key word should be casted to upper case, all key words
        // should be taken from constants
//        Arrays.stream(sql.trim().replaceAll(" +", " ").split(" ")).
//        return normalizedSQLQuery;
        return trimmedSQLString;
    }
    // validate SQL
}
