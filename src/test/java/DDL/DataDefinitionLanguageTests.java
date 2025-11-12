package DDL;


import io.github.gh0stinthesh311.memory.Memory;
import io.github.gh0stinthesh311.parser.Parser;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class DataDefinitionLanguageTests {

    @Test
    public void createTableTest() {
        Parser parser = new Parser();
        parser.parse(Queries.DDL.CREATE_TABLE_01);
        assertEquals(Memory.getInstance().getCurrentDatabase().getTableByName(Queries.DDL.CREATE_TABLE_01_TABLE_NAME).getName(),
                Queries.DDL.CREATE_TABLE_01_TABLE_NAME);
        Assert.assertEquals(1, Memory.getInstance().getCurrentDatabase().getNumberOfTables());
    }

    @Test
    public void createDropTableTest() {
        Parser parser = new Parser();
        parser.parse(Queries.DDL.CREATE_TABLE_01);
        assertNotNull(Memory.getInstance().getCurrentDatabase().getTableByName(Queries.DDL.CREATE_TABLE_01_TABLE_NAME).getName());
        parser.parse(Queries.DDL.DROP_TABLE_01);
        assertEquals(0, Memory.getInstance().getCurrentDatabase().getTablesList().size());
    }

    @Test
    public void dropTableTest() {
        Parser parser = new Parser();
        parser.parse("CREATE TABLE amusers (id INT PRIMARY KEY, name VARCHAR(255), age INT);");
        parser.parse("CREATE TABLE users (id INT PRIMARY KEY, name VARCHAR(255), age INT);");
        parser.parse("drop table users");
        parser.parse("drop table amusers");
        assertEquals(0, Memory.getInstance().getCurrentDatabase().getTablesList().size());
    }

    @Test
    public void createDuplicateTableTest() {
        Parser parser = new Parser();
        parser.parse("CREATE TABLE samurais (id INT PRIMARY KEY, name VARCHAR(255), age INT);");
        parser.parse("CREATE TABLE samurais (id INT PRIMARY KEY, name VARCHAR(255), age INT);");
        assertEquals(1, Memory.getInstance().getCurrentDatabase().getTablesList().size());
    }
}
