import io.github.gh0stinthesh311.memory.Memory;
import io.github.gh0stinthesh311.parser.Parser;
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
    public void test_01() {
        Parser parser = new Parser();
        parser.parse(TestQueryConstants.DDL.CREATE_TABLE_01);
        assertNotNull(Memory.getInstance().getCurrentDatabase().getTableByName(TestQueryConstants.DDL.CREATE_TABLE_01_TABLE_NAME).getName());
        assertEquals(Memory.getInstance().getCurrentDatabase().getTableByName(TestQueryConstants.DDL.CREATE_TABLE_01_TABLE_NAME).getName(),
                TestQueryConstants.DDL.CREATE_TABLE_01_TABLE_NAME);
    }

    @Test
    public void test_02() {
        Parser parser = new Parser();
        parser.parse(TestQueryConstants.DDL.CREATE_TABLE_01);
        assertNotNull(Memory.getInstance().getCurrentDatabase().getTableByName(TestQueryConstants.DDL.CREATE_TABLE_01_TABLE_NAME).getName());
        parser.parse(TestQueryConstants.DDL.DROP_TABLE_01);
        System.out.println(Memory.getInstance());
        assertEquals(Memory.getInstance().getCurrentDatabase().getTablesList().size(), 0);
    }

//    @Test
//    public void createAndDropTableTest() {
//        Memory memory = Memory.getInstance();
//        Parser parser = new Parser();
//        parser.parse(CREATE_TABLE_SQL + TABLE_NAME);
//        Assert.assertEquals(1, memory.getCurrentDatabase().getNumberOfTables());
//        parser.parse(DROP_TABLE_SQL + TABLE_NAME);
//        Assert.assertEquals(0, memory.getCurrentDatabase().getNumberOfTables());
//    }
//
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