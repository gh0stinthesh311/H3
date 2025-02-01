package io.github.soydivision;

import io.github.soydivision.memory.Memory;
import io.github.soydivision.parser.Parser;

public class Main {
    public static void main(String[] args) {
        Parser parser = new Parser();
        String query = "create table sox";
        parser.parse(query);
        System.out.println(Memory.getInstance());


    }
}
