import io.github.soydivision.memory.Memory;
import io.github.soydivision.parser.Parser;
import io.github.soydivision.parser.ParsingSQL;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;

public class DDLtest {
    //    String TABLE_NAME = "TERMINATORS";
    String CREATE_TABLE_SQL = "     crEatE tAblE  users (id INT PRIMARY KEY, name VARCHAR(255),   age    int); ";

    @Test
    public void createTableTest() {

        Memory memory = Memory.getInstance();
        Parser parser = new Parser();
        parser.parse(CREATE_TABLE_SQL);
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