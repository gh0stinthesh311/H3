import Queries.TestQueries;
import io.github.gh0stinthesh311.parser.Parser;
import org.junit.Test;

public class DataManipulationLanguageTest {


    @Test
    public void insertIntoTableTest() {
        Parser p = new Parser();
        p.parse(TestQueries.DML.CREATE_USER_TABLE);
        p.parse("select * from userbase");
//        p.parse(Queries.TestQueries.DML.INSERT_MANY_USERS);
//        p.parse(Queries.TestQueries.DML.SELECT_ALL_USERS);
    }


}
