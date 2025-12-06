package io.github.gh0stinthesh311;


import static io.github.gh0stinthesh311.utils.StringUtils.normalize;

public class Main {
    public static void main(String[] args) {



        String normalizedSQL = normalize("SELECT * FROM users;");

        System.out.println(normalizedSQL);
    }
}





