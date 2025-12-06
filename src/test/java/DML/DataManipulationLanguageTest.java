package DML;

import DDL.Queries;
import io.github.gh0stinthesh311.memory.Memory;
import io.github.gh0stinthesh311.parser.Parser;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DataManipulationLanguageTest {


    @Test
    public void InsertDataTest() {
        Parser parser = new Parser();
        parser.parse("CREATE TABLE users (id INT PRIMARY KEY, name VARCHAR(255), age INT);" +
                "INSERT INTO users (id, name, age) VALUES (1, 'Alice', 30) ;; INSERT INTO users (id, name, age) VALUES (1, 'Alice', 30); ;;;;");
        parser.parse("INSERT INTO users (id, name, age) VALUES (1, 'Alice', 30)");
        parser.parse("SELECT * FROM users");



//parser.parse("insert into cars (id, make, mileage) values  ");

    }

}
