import io.github.gh0stinthesh311.parser.Parser;
import org.junit.Test;

public class DataManipulationLanguageTest {


    @Test
    public void insertIntoTableTest() {
        Parser parser = new Parser();
        parser.parse(Constants.DML.CREATE_USER_TABLE);
//        parser.parse(Constants.DML.INSERT_USER);

    }


}
