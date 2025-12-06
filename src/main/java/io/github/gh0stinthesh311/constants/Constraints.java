package io.github.gh0stinthesh311.constants;

public enum Constraints {

    primary_key("PRIMARY KEY");

    private String value;

    Constraints(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
// to do candidates to be included
//NOT NULL - Ensures that a column cannot have a NULL value
//UNIQUE - Ensures that all values in a column are different
//PRIMARY KEY - A combination of a NOT NULL and UNIQUE. Uniquely identifies each row in a table
//FOREIGN KEY - Prevents actions that would destroy links between tables
//CHECK - Ensures that the values in a column satisfies a specific condition
//DEFAULT - Sets a default value for a column if no value is specified
//CREATE INDEX - Used to create and retrieve data from the database very quickly
