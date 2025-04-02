package io.github.gh0stinthesh311;

import io.github.gh0stinthesh311.parser.Parser;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static io.github.gh0stinthesh311.constants.SupportedDataTypes.getSupportedDataTypes;
import static io.github.gh0stinthesh311.utils.StringUtils.normalize;


public class Main {
    public static void main(String[] args) {

//        String CREATE_TABLE_01 = "CrEaTe TABLE Employees (\n" +
//                "    EmployeeID InT PRIMARY KEY, \n" +
//                "    FirstName vARChAR(50) NOT NULL, \n" +
//                "    LastName VArCHaR(50), \n" +
//                "    Age INT(),\n" +
//                "    HireDate dAtE\n" +
//                ");\n";
//        ;
//        System.out.println(normalize(CREATE_TABLE_01));


        // chat gpt
        String sql = "CREATE TABLE Employees (EmployeeID INT PRIMARY KEY,FirstName vARChAR(50) NOT NULL,LastName VArCHaR(50),Age INT(),HireDate dAtE)";

        // Step 1: Regex to match words (letters only) and other tokens
        Pattern wordPattern = Pattern.compile("[a-zA-Z][a-zA-Z0-9_]*"); // Words start & end with letters
        Pattern otherPattern = Pattern.compile("[^a-zA-Z0-9_]+"); // Non-word characters

        // Step 2: Split into tokens while keeping words separate
        List<String> tokens = new ArrayList<>();

        Matcher wordMatcher = wordPattern.matcher(sql);
        int lastEnd = 0;

        while (wordMatcher.find()) {
            // Add non-word symbols before the current word
            if (lastEnd < wordMatcher.start()) {
                tokens.add(sql.substring(lastEnd, wordMatcher.start()));
            }
            tokens.add(wordMatcher.group()); // Add the matched word
            lastEnd = wordMatcher.end();
        }
        // Add remaining non-word characters
        if (lastEnd < sql.length()) {
            tokens.add(sql.substring(lastEnd));
        }

        // Step 3: Normalize only the words
        for (int i = 0; i < tokens.size(); i++) {
            String token = tokens.get(i);
            if (wordPattern.matcher(token).matches()) { // Only process words
                if (token.equalsIgnoreCase("VARCHAR") || token.equalsIgnoreCase("INT") || token.equalsIgnoreCase("DATE")) {
                    tokens.set(i, token.toUpperCase()); // Normalize SQL types
                }
            }
        }

        // Step 4: Merge back into a valid SQL statement
        StringBuilder normalizedSQL = new StringBuilder();
        for (String token : tokens) {
            normalizedSQL.append(token);
        }

        System.out.println(normalizedSQL.toString());
    }
}






