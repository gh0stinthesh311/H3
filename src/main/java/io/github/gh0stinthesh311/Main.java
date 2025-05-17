package io.github.gh0stinthesh311;

import io.github.gh0stinthesh311.parser.Parser;
import io.github.gh0stinthesh311.utils.LogUtil;

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
        String sql_insert = "INSERT INTO users (id, name, age) VALUES (1, 'Alice', 30);";

        String columnDefinitions = extractColumnDefinitions(sql_insert);
        System.out.println("********");
        System.out.println(columnDefinitions);
    }


    public static String extractColumnDefinitions(String SQL) {
        String columnDefinitions = SQL.substring(SQL.indexOf("(") + 1, SQL.lastIndexOf(")")).trim();
        LogUtil.info("Extracted column definitions: " + columnDefinitions);
        return columnDefinitions;
    }
}





