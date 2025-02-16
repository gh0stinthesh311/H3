package io.github.soydivision.utils;

import static io.github.soydivision.constants.SQLKeywords.getSQLKeyWords;
import static java.util.Collections.replaceAll;

public class StringUtils {

    private StringUtils() {
    }

    public static String normalize(String SQL) {
        // remove newlines
        // remove trailing spaces
        // normalize key wordss
        // remove spaces in column def data like ( UserId
        // remove spaces from end like DATE )
        // remove spaces after ","
        String[] trimmedSQL = SQL.trim()
                .replace("\n", "")
                .replace("\r", "")
                .replaceAll("\\(\\s+", "(")  // Remove spaces after "("
                .replaceAll("\\s+\\)", ")")  // Remove spaces before ")"
                .replaceAll(",\\s+", ",")   // Remove spaces after ","
                .replaceAll(" +", " ")      // Collapse multiple spaces
                .split(" ");


        String[] keyWords = getSQLKeyWords();
        for (int i = 0; i < trimmedSQL.length; i++) {
            for (int j = 0; j < keyWords.length; j++) {
                if (trimmedSQL[i].toUpperCase().equals(keyWords[j])) {
                    trimmedSQL[i] = keyWords[j];
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(trimmedSQL[0]);
        for (int i = 1; i < trimmedSQL.length; i++) {
            stringBuilder.append(" ");
            stringBuilder.append(trimmedSQL[i]);
        }
        System.out.println("normalized statement:" + stringBuilder.toString());
        return stringBuilder.toString();

    }


}
