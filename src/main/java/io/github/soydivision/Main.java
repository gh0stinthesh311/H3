package io.github.soydivision;

import io.github.soydivision.constants.SupportedDataTypes;
import io.github.soydivision.memory.Memory;
import io.github.soydivision.parser.Parser;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        System.out.printf(Arrays.toString(SupportedDataTypes.getSupportedDataTypes()));

    }
}
