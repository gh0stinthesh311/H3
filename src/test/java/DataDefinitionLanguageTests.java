import io.github.soydivision.memory.Memory;
import io.github.soydivision.parser.Parser;
import org.junit.Test;

import static org.junit.Assert.*;

public class DataDefinitionLanguageTests {
    String TABLE_NAME = "Employees";
    String CREATE_TABLE_SQL = "CREATE TABLE Employees (\n" +
            "    EmployeeID INT PRIMARY KEY, \n" +
            "    FirstName VARCHAR(50) NOT NULL, \n" +
            "    LastName VARCHAR(50), \n" +
            "    Age INT(),\n" +
            "    HireDate DATE\n" +
            ");\n";
    String CREATE_TABLE_SQL_UNSUPPORTED_TYPE = "CREATE TABLE Employees (\n" +
            "    EmployeeID INT PRIMARY KEY,\n" +
            "    FirstName VARCHAR(50) NOT NULL,\n" +
            "    LastName VARCHAR(50),\n" +
            "    Age INT,\n" +
            "    Salary MONEY,\n" +
            "    HireDate DATE\n" +
            ");\n";


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
        // to do parser should log activity
//        LogUtil.info("Creating table test, using statement:" + CREATE_TABLE_SQL_UNSUPPORTED_TYPE);
        Parser parser = new Parser();
        parser.parse(TestQueryConstants.DDL.CREATE_TABLE_STATEMENT_WITH_SINGLE_LINE_COMMENTS);
        assertNotNull(Memory.getInstance().getCurrentDatabase().getTableByName(TABLE_NAME).getName());
        assertEquals(Memory.getInstance().getCurrentDatabase().getTableByName(TABLE_NAME).getName(), TABLE_NAME);
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