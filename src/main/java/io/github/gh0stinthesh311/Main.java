package io.github.gh0stinthesh311;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String source = "CREaTE TABLE Employees (EmployeeID InT PRIMARY KEY,FirstName VARCHAR(50) NOT NULL,LastName VArCHaR(50),Age INT(),HireDate dAtE);      Next;";
        String[] outRes = source.split(";");
        Arrays.stream(outRes).forEach(System.out::println);
        System.out.println(outRes.length);
        //        System.out.println(Arrays.toString(outRes));
//        System.out.println(outRes.length);

//        String text = "CREATE TABLE users (id INT PRIMARY KEY, name VARCHAR(255), age INT);";
//        extractParenthesesContent(text);
    }


//    public static void extractParenthesesContent(String source) {
//        for (int i = 0; i < source.length(); i++) {
//            char opening = '(';
//            char x = source.charAt(i);
//            if (x == opening) {
//                System.out.println("Opening at:" + i);
//            }
//
//        }
//    }
}





