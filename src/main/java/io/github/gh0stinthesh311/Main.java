package io.github.gh0stinthesh311;

import io.github.gh0stinthesh311.constants.SupportedDataTypes;
import io.github.gh0stinthesh311.domain.Column;
import io.github.gh0stinthesh311.parser.Parser;
import io.github.gh0stinthesh311.utils.LogUtil;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static io.github.gh0stinthesh311.constants.SupportedDataTypes.getSupportedDataTypes;
import static io.github.gh0stinthesh311.utils.StringUtils.normalize;


public class Main {
    public static void main(String[] args) {
        HashMap<String, Column> columns = new HashMap<>();
        columns.put("First Name", new Column("INT"));
        columns.forEach((key, value) -> System.out.println(key + " " + value));
    }
}





