package io.github.gh0stinthesh311.utils;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {

    private StringUtils() {
    }

    public static String normalize(String SQL) {
        LogUtil.info("Initial statement " + Formatter.wrapWithQuotes(SQL));
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
        // to do need method to join string[] to one string
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(trimmedSQL[0]); // this is because first one has no space to begin with.
        for (int i = 1; i < trimmedSQL.length; i++) {
            stringBuilder.append(" ");
            stringBuilder.append(trimmedSQL[i]);
        }
        LogUtil.info("Normalized statement " + Formatter.wrapWithQuotes(stringBuilder.toString()));
        return stringBuilder.toString();
    }

    public static ArrayList<String> extractContentBetweenParentheses(String text) {
        List<String> result = new ArrayList<>();
        Matcher matcher = Pattern.compile("[(](.*?)[)]")
                .matcher(text);
        while (matcher.find()) {
            result.add(matcher.group(1));
        }
        return new ArrayList<>(result);
    }

    public static boolean validateNonEmptyContentBetweenParentheses(String text) {
        int openIndex = text.indexOf('(');
        int closeIndex = text.lastIndexOf(')');
        if (openIndex != -1 && closeIndex != -1) {
            if (openIndex + 1 > closeIndex) {
                LogUtil.info("parenthesis order error");
                return false;
            }
            String inside = text.substring(openIndex + 1, closeIndex).trim();
            return !inside.isEmpty();
        } else {
            LogUtil.info("No parenthesis found in statement");
            return false;
        }
    }

    public static boolean validateBracketBalance(String expression) {
        ArrayDeque<Character> s = new ArrayDeque<>();
        for (char bracket : expression.toCharArray()) {
            switch (bracket) {
                case '{':
                    s.push('}');
                    break;
                case '(':
                    s.push(')');
                    break;
                case '[':
                    s.push(']');
                    break;
                case '}':
                case ')':
                case ']':
                    if (s.isEmpty() || bracket != s.pop()) return false;
                    break;
                default:
            }
        }
        return s.isEmpty();
    }


}
