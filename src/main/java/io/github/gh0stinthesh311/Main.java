package io.github.gh0stinthesh311;


import io.github.gh0stinthesh311.parser.Parser;

import static io.github.gh0stinthesh311.utils.StringUtils.normalize;

public class Main {
    public static void main(String[] args) {

        Parser parser = new Parser();
        // parser.parse("CREATE TABLE users (());");
        parser.parse("CREATE TABLE users (id INT PRIMARY KEY, name VARCHAR(255), age INT);");
    }
}

