import io.github.soydivision.memory.Memory;
import io.github.soydivision.parser.Parser;
import org.junit.Assert;
import org.junit.Test;

public class DDLtest {
    String TABLE_NAME = "TERMINATORS";
    String CREATE_TABLE_SQL = "create table ";
    String DROP_TABLE_SQL = "DROP table ";
    String CREATE_DATABASE_SQL = "create dAtabASE ";
    String DB_NAME = "   Honda";
    String DROP_DB_SQL = "DROP dAtabASE ";

    @Test
    public void createAndDropTableTest() {
        Memory memory = Memory.getInstance();
        Parser parser = new Parser();
        parser.parse(CREATE_TABLE_SQL + TABLE_NAME);
        Assert.assertEquals(1, memory.getCurrentDatabase().getNumberOfTables());
        parser.parse(DROP_TABLE_SQL + TABLE_NAME);
        Assert.assertEquals(0, memory.getCurrentDatabase().getNumberOfTables());
    }

    @Test
    public void createAndDropDBTest() {
        Memory memory = Memory.getInstance();
        Parser parser = new Parser();
        parser.parse(CREATE_DATABASE_SQL + DB_NAME);
        Assert.assertEquals(2, memory.getNumberOfDatabases());
        parser.parse(DROP_DB_SQL + DB_NAME);
        Assert.assertEquals(1, memory.getNumberOfDatabases());
    }
}