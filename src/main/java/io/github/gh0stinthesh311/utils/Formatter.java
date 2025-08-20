package io.github.gh0stinthesh311.utils;

public class Formatter {
    public static String wrap(String value, String wrapper) {
        return wrapper + value + wrapper;
    }

    public static String wrapWithQuotes(String value) {
        return wrap(value, "'");
    }
}
