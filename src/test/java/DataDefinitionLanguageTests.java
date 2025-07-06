import io.github.gh0stinthesh311.memory.Memory;
import io.github.gh0stinthesh311.parser.Parser;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class DataDefinitionLanguageTests {
//    String TABLE_NAME = "Employees";

//    @Test
//    public void createTableTest() {
//        LogUtil.info("Creating table test, using statement:" + CREATE_TABLE_SQL);
//        Parser parser = new Parser();
//        parser.parse(CREATE_TABLE_SQL);
//        assertNotNull(Memory.getInstance().getCurrentDatabase().getTableByName(TABLE_NAME).getName());
//        assertEquals(Memory.getInstance().getCurrentDatabase().getTableByName(TABLE_NAME).getName(), TABLE_NAME);
//    }

    @Test
    public void createTableTest() {
        Parser parser = new Parser();
        parser.parse(TestQueries.DDL.CREATE_TABLE_01);
        assertNotNull(Memory.getInstance().getCurrentDatabase().getTableByName(TestQueries.DDL.CREATE_TABLE_01_TABLE_NAME).getName());
        assertEquals(Memory.getInstance().getCurrentDatabase().getTableByName(TestQueries.DDL.CREATE_TABLE_01_TABLE_NAME).getName(),
                TestQueries.DDL.CREATE_TABLE_01_TABLE_NAME);
        Assert.assertEquals(1, Memory.getInstance().getCurrentDatabase().getNumberOfTables());

    }

    @Test
    public void dropTableTest() {
        Parser parser = new Parser();
        parser.parse(TestQueries.DDL.CREATE_TABLE_01);
        assertNotNull(Memory.getInstance().getCurrentDatabase().getTableByName(TestQueries.DDL.CREATE_TABLE_01_TABLE_NAME).getName());
        parser.parse(TestQueries.DDL.DROP_TABLE_01);
        System.out.println(Memory.getInstance());
        assertEquals(Memory.getInstance().getCurrentDatabase().getTablesList().size(), 0);
    }

    @Test
    public void createAndDropTableTest() {
        Parser parser = new Parser();
        parser.parse(TestQueries.DDL.CREATE_AND_DROP_TABLE_01);
        Assert.assertEquals(0, Memory.getInstance().getCurrentDatabase().getNumberOfTables());
    }

//    @Test
//    public void createAndDropDBTest() {
//        Memory memory = Memory.getInstance();
//        Parser parser = new Parser();
//        parser.parse(CREATE_DATABASE_SQL + DB_NAME);
//        Assert.assertEquals(2, memory.getNumberOfDatabases());
//        parser.parse(DROP_DB_SQL + DB_NAME);
//        Assert.assertEquals(1, memory.getNumberOfDatabases());
//    }
}