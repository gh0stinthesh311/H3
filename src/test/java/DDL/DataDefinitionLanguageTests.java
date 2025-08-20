package DDL;


import Queries.TestQueries;
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
        parser.parse(TestQueries.DDL.CREATE_TABLE_01);
        parser.parse("drop table Employees1");
        assertNotNull(Memory.getInstance().getCurrentDatabase().getTableByName(Queries.TestQueries.DDL.CREATE_TABLE_01_TABLE_NAME).getName());
        assertEquals(Memory.getInstance().getCurrentDatabase().getTableByName(Queries.TestQueries.DDL.CREATE_TABLE_01_TABLE_NAME).getName(),
                Queries.TestQueries.DDL.CREATE_TABLE_01_TABLE_NAME);
        Assert.assertEquals(1, Memory.getInstance().getCurrentDatabase().getNumberOfTables());
    }

//    @Test
//    public void dropTableTest() {
//        Parser parser = new Parser();
//        parser.parse(Queries.TestQueries.DDL.CREATE_TABLE_01);
//        assertNotNull(Memory.getInstance().getCurrentDatabase().getTableByName(Queries.TestQueries.DDL.CREATE_TABLE_01_TABLE_NAME).getName());
//        parser.parse(Queries.TestQueries.DDL.DROP_TABLE_01);
//        System.out.println(Memory.getInstance());
//        assertEquals(Memory.getInstance().getCurrentDatabase().getTablesList().size(), 0);
//    }
//
//    @Test
//    public void createAndDropTableTest() {
//        Parser parser = new Parser();
//        parser.parse(Queries.TestQueries.DDL.CREATE_AND_DROP_TABLE_01);
//        Assert.assertEquals(0, Memory.getInstance().getCurrentDatabase().getNumberOfTables());
//    }

}