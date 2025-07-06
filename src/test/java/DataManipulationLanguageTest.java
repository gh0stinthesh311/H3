import io.github.gh0stinthesh311.parser.Parser;
import org.junit.Test;

public class DataManipulationLanguageTest {


    @Test
    public void insertIntoTableTest() {

        Parser parser = new Parser();
//        parser.parse("CREATE TABLE users (ID MINT PRIMARY KEY, NAME VARCHAR(255), AGE INT);");
        parser.parse(TestQueries.DML.CREATE_USER_TABLE);
        parser.parse(TestQueries.DML.INSERT_USER);

    }


}
