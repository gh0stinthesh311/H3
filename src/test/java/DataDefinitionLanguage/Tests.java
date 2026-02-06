package DataDefinitionLanguage;


import io.github.gh0stinthesh311.memory.Memory;
import io.github.gh0stinthesh311.parser.Parser;
import org.junit.Assert;
import org.junit.Test;

import static DataDefinitionLanguage.Queries.DDL.CREATE_TABLE_01;
import static DataDefinitionLanguage.Queries.DDL.CREATE_TABLE_WITH_UNSUPPORTED_TYPE;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class Tests {

    @Test
    public void createTableTest() {
        Parser parser = new Parser();
        parser.parse(CREATE_TABLE_01);
        assertEquals(Memory.getInstance().getCurrentDatabase().getTableByName(Queries.DDL.CREATE_TABLE_01_TABLE_NAME).getName(),
                Queries.DDL.CREATE_TABLE_01_TABLE_NAME);
        Assert.assertEquals(1, Memory.getInstance().getCurrentDatabase().getNumberOfTables());
    }

    @Test
    public void createDropTableTest() {
        Parser parser = new Parser();
        parser.parse(CREATE_TABLE_01);
        assertNotNull(Memory.getInstance().getCurrentDatabase().getTableByName(Queries.DDL.CREATE_TABLE_01_TABLE_NAME).getName());
        parser.parse(Queries.DDL.DROP_TABLE_01);
        assertEquals(0, Memory.getInstance().getCurrentDatabase().getTablesList().size());
    }

    @Test
    public void createDropTableOneBatchTest() {
        Parser parser = new Parser();
        parser.parse(Queries.DDL.CREATE_AND_DROP_TABLE_01);
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
    public void dropNonExistentTableTest() {
        Parser parser = new Parser();
        parser.parse("CREATE TABLE users (id INT PRIMARY KEY, name VARCHAR(255), age INT);");
        parser.parse("");
        parser.parse("drop table amusers");
        assertEquals(1, Memory.getInstance().getCurrentDatabase().getTablesList().size());
    }

    @Test
    public void createDuplicateTableTest() {
        Parser parser = new Parser();
        parser.parse(CREATE_TABLE_01);
        parser.parse(CREATE_TABLE_01);
        assertEquals(1, Memory.getInstance().getCurrentDatabase().getTablesList().size());
    }

    @Test
    public void createUnsupportedDataTypeTest() {
        Parser parser = new Parser();
        parser.parse(CREATE_TABLE_WITH_UNSUPPORTED_TYPE);
        parser.parse(CREATE_TABLE_01);
        assertEquals(1, Memory.getInstance().getCurrentDatabase().getTablesList().size());
    }
}
