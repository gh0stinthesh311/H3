package DataManipulationLanguage;

import io.github.gh0stinthesh311.memory.Memory;
import io.github.gh0stinthesh311.parser.Parser;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DataManipulationLanguageTest {


    @Test
    public void SingleInsertionDataTest() {
        Parser parser = new Parser();
        parser.parse("CREATE TABLE users (id INT PRIMARY KEY, name VARCHAR(255), age INT);");
        parser.parse("INSERT INTO users (id, name, age) VALUES (1, 'Alice', 30)");
        parser.parse("SELECT * FROM users");
        // To do fix this bug, this is serious bug because it shows size 3 instead of 1 row.
        assertEquals(1, Memory.getInstance().getCurrentDatabase().getTableByName("users").getRows().size());
    }

    @Test
    public void InsertDuplicateDataTest() {
        Parser parser = new Parser();
        parser.parse("CREATE TABLE users (id INT PRIMARY KEY, name VARCHAR(255), age INT);" +
                "INSERT INTO users (id, name, age) VALUES (1, 'Alice', 30) ;; INSERT INTO users (id, name, age) VALUES (1, 'Alice', 30); ;;;;");
        parser.parse("INSERT INTO users (id, name, age) VALUES (1, 'Alice', 30)");
        parser.parse("SELECT * FROM users");


//parser.parse("insert into cars (id, make, mileage) values  ");

    }


}
