package DataQueryLanguage;

public class Queries {
    public static String SELECT_TABLE_STATEMENT_WITH_MULTILINE_COMMENTS =
            "/* \n" +
                    "   This is a multi-line comment.\n" +
                    "   It explains the purpose of the following query.\n" +
                    "   The query retrieves all active users from the database.\n" +
                    "*/\n" +
                    "SELECT id, username, email\n" +
                    "FROM users\n" +
                    "WHERE status = 'active';\n";

    public static String GET_ALL_BOOKS = "SELECT * FROM books";
    public static String GET_BOOK_BY_ID = "SELECT * FROM books WHERE id = ?";
    public static String SELECT_ALL_USERS = "SELECT * FROM users;";
}
