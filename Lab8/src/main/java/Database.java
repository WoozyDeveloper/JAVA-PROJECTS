import java.sql.*;

public class Database {
    private static Database obj;
    private Connection connection;
    private static Statement statement;
    private int cityId = 1;

    // private constructor to force use of
    // getInstance() to create Singleton object
    private Database() {
        String dbURL = "jdbc:oracle:thin:@localhost:1521:xe";
        String username = "system";
        String password = "123456";

        try {
            this.connection = DriverManager.getConnection(dbURL, username, password);
            System.out.println("CONNECTED TO ORACLE");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Statement getStatement(){
        return statement;
    }

    public Connection getConnection() {
        return this.connection;
    }






    public static Database getInstance() {
        if (obj==null)
            obj = new Database();
        return obj;
    }
}
