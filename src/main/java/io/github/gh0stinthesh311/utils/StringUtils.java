package io.github.gh0stinthesh311.utils;

import static io.github.gh0stinthesh311.constants.SQLKeywords.getSQLKeyWords;

public class StringUtils {

    private StringUtils() {
    }

    public static String normalize(String SQL) {
        String[] trimmedSQL = SQL.trim() // Remove trailing spaces
                .replaceAll("(/\\*(.|[\\r\\n])*?\\*/)|(--(.*|[\\r\\n]))\n", "") // Remove all sql comments
                .replace("\n", "") // Remove newlines
                .replace("\r", "") // Remove Carriage Return
                .replaceAll("\\(\\s+", "(")  // Remove spaces after "("
                .replaceAll("\\s+\\)", ")")  // Remove spaces before ")"
                .replaceAll(",\\s+", ",")   // Remove spaces after ","
                .replaceAll(" +", " ")      // Collapse multiple spaces
                .replaceAll(";$", "") // remove ";" at the end
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
        LogUtil.info("Normalized statement " + stringBuilder);
        return stringBuilder.toString();


        // to do make same for data types normalization
    }

//    public static String trim(String s) {
//        return s.trim();
//    }
//
//    public static String removeNewlines(String s) {
//        return s.replace("\n", "");
//    }
//
//    public static String removeCarriageReturn(String s) {
//        return s.replace("\r", "");
//    }
//
//    public static String removeAllSqlComments(String s) {
//        return s.replaceAll("(/\\*(.|[\\r\\n])*?\\*/)|(--(.*|[\\r\\n]))\n", "");
//    }
//
//    public static String removeParenthesesSpaces(String s) {
//        return s.replaceAll("\\(\\s+", "(")  // Remove spaces after "("
//                .replaceAll("\\s+\\)", ")");  // Remove spaces before ")"
//    }
//
//    public static String removeSpacesAfterComma(String s) {
//        return s.replaceAll(",\\s+", ",");  // Remove spaces after ","
//    }
//
//    public static String collapseMultiplespaces(String s) {
//        return s.replaceAll(" +", " ");
//    }

}
