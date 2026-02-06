package DataManipulationLanguage;

public class Queries {
    public static String INSERT_BOOK = "INSERT INTO books (title, author_id) VALUES (?, ?)";
    public static String DELETE_BOOK = "DELETE FROM books WHERE id = ?";
    public static String CREATE_USER_TABLE = "CREATE TABLE users (ID INT PRIMARY KEY, NAME VARCHAR(255), AGE INT); ; ; ; ; ;     ;  ";
    public static String INSERT_USER = "INSERT INTO users (id, name, age) VALUES (13, 'Alice', 25);";
    public static String SELECT_ALL_USERS = "SELect * from users;";
    public static String INSERT_MANY_USERS = "INSERT INTO users (id, name) VALUES (1, 'Alice');\n" +
            "    INSERT INTO users (id, name) VALUES (2, 'Bob');\n";
    public static String INSERT_NON_EXISTENT_COLUMN = "INSERT INTO users (mid, name, age) VALUES (29, 'Rick', 180);";

}
