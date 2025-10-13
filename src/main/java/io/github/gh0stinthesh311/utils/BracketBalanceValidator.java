package io.github.gh0stinthesh311.utils;

import java.util.*;

public class BracketBalanceValidator {

    public static void main(String[] args) {
        System.out.println(validateBracketBalance("()"));


    }

    //bracket balancing problem
    public static boolean validateBracketBalance(String expression) {
        if (expression.length() % 2 == 1) return false;
        else {
            ArrayDeque<Character> s = new ArrayDeque<Character>();
            for (char bracket : expression.toCharArray())
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
                    default:
                        if (s.isEmpty() || bracket != s.peek()) {
                            return false;
                        }
                }
            return s.isEmpty();
        }
    }
}
