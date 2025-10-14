package io.github.gh0stinthesh311.utils;

import java.util.*;

public class BracketBalanceValidator {
    // bracket balancing problem
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

