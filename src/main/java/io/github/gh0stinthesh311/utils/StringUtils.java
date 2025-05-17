package io.github.gh0stinthesh311.utils;

import java.util.Arrays;

import static io.github.gh0stinthesh311.constants.SQLKeywords.getSQLKeyWords;
import static io.github.gh0stinthesh311.constants.SupportedDataTypes.getSupportedDataTypes;

public class StringUtils {

    private StringUtils() {
    }

    public static String normalize(String SQL) {
        LogUtil.info("Initial statement:" + SQL);
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
        //need method to join string[] to one string


        // SQL key words normalize
//        String[] keyWords = getSQLKeyWords();
//        for (int i = 0; i < trimmedSQL.length; i++) {
//            System.out.println("Checking:" + trimmedSQL[i]);
//            for (int j = 0; j < keyWords.length; j++) {
//                if (trimmedSQL[i].equalsIgnoreCase(keyWords[j])) {
//                    trimmedSQL[i] = keyWords[j];
//                    System.out.println("replacing " + trimmedSQL[i] + " with " + keyWords[j]);
//                }
//            }
//        }

        // data type keywords normalize
//        String[] dataTypes = getSupportedDataTypes();
//        System.out.println(Arrays.toString(dataTypes));
//        for (int k = 0; k < trimmedSQL.length; k++) {
//            for (int l = 0; l < dataTypes.length; l++) {
//                if (trimmedSQL[k].equalsIgnoreCase(dataTypes[l])) {
//                    trimmedSQL[k] = dataTypes[l];
//                    System.out.println("replacing " + trimmedSQL[k] + " with " + dataTypes[l]); // remove this
//                }
//            }
//        }

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(trimmedSQL[0]); // this is because first one has no space to begin with.
        for (int i = 1; i < trimmedSQL.length; i++) {
            stringBuilder.append(" ");
            stringBuilder.append(trimmedSQL[i]);
        }
        LogUtil.info("Normalized statement:" + stringBuilder);
        return stringBuilder.toString();
    }



    public void getColumnDefinitions(){} // for creating columns
    public void getColumnList(){} // for inserting
    public void getInsertPayload(){} // list of values to insert

}
