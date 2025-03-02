package io.github.gh0stinthesh311;

import io.github.gh0stinthesh311.parser.Parser;

public class Main {
    public static void main(String[] args) {


        final String CREATE_TABLE_STATEMENT_WITH_SINGLE_LINE_COMMENTS =
                "CREATE TABLE Employees (\n" +
                        "    EmployeeID INT PRIMARY KEY,  -- Column Definition\n" +
                        "    FirstName VARCHAR(50) NOT NULL,  -- Column Definition\n" +
                        "    LastName VARCHAR(50),  -- Column Definition\n" +
                        "    Age INT,\n" +
                        "    HireDate DATE\n" +
                        ");";
        Parser parser = new Parser();
        parser.parse(CREATE_TABLE_STATEMENT_WITH_SINGLE_LINE_COMMENTS);


    }
}
