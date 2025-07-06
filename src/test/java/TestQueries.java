public class TestQueries {
    public static class DDL {
        public static String CREATE_TABLE_01_TABLE_NAME = "Employees";

        public static String CREATE_TABLE_01 = "CREaTE TABLE " + CREATE_TABLE_01_TABLE_NAME + "   (\n" +
                "    EmployeeID InT PRIMARY KEY, \n" +
                "    FirstName VARCHAR(50) NOT NULL, \n" +
                "    LastName VArCHaR(50), \n" +
                "    Age INT(),\n" +
                "    HireDate dAtE\n" +
                ");\n";
        public static String DROP_TABLE_01 = "DrOp TABLE " + CREATE_TABLE_01_TABLE_NAME + " ;";

        public static String CREATE_AND_DROP_TABLE_01 = "CREaTE TABLE " + CREATE_TABLE_01_TABLE_NAME + "   (\n" +
                "    EmployeeID InT PRIMARY KEY, \n" +
                "    FirstName VARCHAR(50) NOT NULL, \n" +
                "    LastName VArCHaR(50), \n" +
                "    Age INT(),\n" +
                "    HireDate dAtE\n" +
                "); DrOp TABLE " + CREATE_TABLE_01_TABLE_NAME;

        public static String CREATE_TABLE_CONDITIONAL =
                "CREATE TABLE IF NOT EXISTS books (" +
                        "id SERIAL PRIMARY KEY, " +
                        "title VARCHAR(255) NOT NULL, " +
                        "author_id INT NOT NULL, " +
                        "FOREIGN KEY (author_id) REFERENCES authors(id))";

        public static String CREATE_TABLE_WITH_UNSUPPORTED_TYPE = "CREATE TABLE Employees (\n" +
                "    EmployeeID INT PRIMARY KEY,\n" +
                "    FirstName VARCHAR(50) NOT NULL,\n" +
                "    LastName VARCHAR(50),\n" +
                "    Age INT,\n" +
                "    Salary MONEY,\n" +
                "    HireDate DATE\n" +
                ");\n";

        public static String SELECT_TABLE_STATEMENT_WITH_MULTILINE_COMMENTS =
                "/* \n" +
                        "   This is a multi-line comment.\n" +
                        "   It explains the purpose of the following query.\n" +
                        "   The query retrieves all active users from the database.\n" +
                        "*/\n" +
                        "SELECT id, username, email\n" +
                        "FROM users\n" +
                        "WHERE status = 'active';\n";

        public static String CREATE_TABLE_STATEMENT_WITH_SINGLE_LINE_COMMENTS =
                "CREATE TABLE Employees (\n" +
                        "    EmployeeID INT PRIMARY KEY,  -- Column Definition\n" +
                        "    FirstName VARCHAR(50) NOT NULL,  -- Column Definition\n" +
                        "    LastName VARCHAR(50),  -- Column Definition\n" +
                        "    Age INT,\n" +
                        "    HireDate DATE\n" +
                        ");";

    }

    public static class DQL {
        public static String GET_ALL_BOOKS = "SELECT * FROM books";
        public static String GET_BOOK_BY_ID = "SELECT * FROM books WHERE id = ?";
    }

    public static class DML {
        public static String INSERT_BOOK = "INSERT INTO books (title, author_id) VALUES (?, ?)";
        public static String DELETE_BOOK = "DELETE FROM books WHERE id = ?";
        public static String CREATE_USER_TABLE = "CREATE TABLE users (ID INT PRIMARY KEY, NAME VARCHAR(255), AGE INT);";
        public static String INSERT_USER = "INSERT INTO users (id, name, age) VALUES (xx, 'Alice', 25);";
        public static String INSERT_MANY_USERS = "INSERT INTO users (id, name) VALUES (1, 'Alice');\n" +
                "    INSERT INTO users (id, name) VALUES (2, 'Bob');\n" +
                "    SELECT * FROM users;";
    }
}
