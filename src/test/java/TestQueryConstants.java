public class TestQueryConstants {
    public static class DDL {
        public static final String CREATE_TABLE =
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

        public static final String SELECT_TABLE_STATEMENT_WITH_MULTILINE_COMMENTS =
                "/* \n" +
                        "   This is a multi-line comment.\n" +
                        "   It explains the purpose of the following query.\n" +
                        "   The query retrieves all active users from the database.\n" +
                        "*/\n" +
                        "SELECT id, username, email\n" +
                        "FROM users\n" +
                        "WHERE status = 'active';\n";

        public static final String CREATE_TABLE_STATEMENT_WITH_SINGLE_LINE_COMMENTS =
                "CREATE TABLE Employees (\n" +
                        "    EmployeeID INT PRIMARY KEY,  -- Column Definition\n" +
                        "    FirstName VARCHAR(50) NOT NULL,  -- Column Definition\n" +
                        "    LastName VARCHAR(50),  -- Column Definition\n" +
                        "    Age INT,\n" +
                        "    HireDate DATE\n" +
                        ");";

    }

    public static class DQL {
        public static final String GET_ALL_BOOKS = "SELECT * FROM books";
        public static final String GET_BOOK_BY_ID = "SELECT * FROM books WHERE id = ?";
    }

    public static class DML {
        public static final String INSERT_BOOK = "INSERT INTO books (title, author_id) VALUES (?, ?)";
        public static final String DELETE_BOOK = "DELETE FROM books WHERE id = ?";
    }

}
