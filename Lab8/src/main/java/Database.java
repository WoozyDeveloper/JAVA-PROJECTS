import java.sql.*;

public class Database {
    private static Database obj;
    private Connection connection;
    private Statement statement;
    // private constructor to force use of
    // getInstance() to create Singleton object
    private Database() {
        String dbURL = "jdbc:oracle:thin:@localhost:1521:xe";
        String username = "system";
        String password = "123456";

        try {
            this.connection = DriverManager.getConnection(dbURL,username,password);
            System.out.println("CONNECTED TO ORACLE");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public Connection getConnection(){
        return this.connection;
    }

    public void addContinent(int id, String name){
        String sql = "INSERT INTO CONTINENT VALUES(" + id + ",'" + name + "')";
        int rows = 0;
        try {
            statement = connection.createStatement();
            rows = statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(rows > 0){
            System.out.println("Added a row in table CONTINENT");
        }
    }

    public void addCountry(int id, String name, String code, String continent){
        String sql = "INSERT INTO CONTINENT VALUES(" + id + ",'" + name + ",'" + code + ",'" + continent + "')";
        Statement statement = null;
        int rows = 0;
        try {
            statement = connection.createStatement();
            rows = statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(rows > 0){
            System.out.println("Added a row in table COUNTRY");
        }
    }

    public void findContinent(int id) throws SQLException {
        statement = connection.createStatement();
        ResultSet result = statement.executeQuery("SELECT * FROM CONTINENT WHERE ID=" + id);
        while (result.next()) {
            String x1 = result.getString(1);
            String x2 = result.getString(2);
            System.out.println("id=" + x1 + ", name=" + x2);
        }
    }
    public void findContinent(final String name) throws SQLException {
        statement = connection.createStatement();
        ResultSet result = statement.executeQuery("SELECT * FROM CONTINENT WHERE NAME='" + name + "'");
        while (result.next()) {
            String x1 = result.getString(1);
            String x2 = result.getString(2);
            System.out.println("id=" + x1 + ", name=" + x2);
        }
    }

    public void showContinents() throws SQLException {
        statement = connection.createStatement();
        ResultSet result = statement.executeQuery("SELECT * FROM CONTINENT");
        while (result.next()) {
            String x = result.getString(2);
            System.out.println(x);
        }
    }

    public void showContries() throws SQLException {
        ResultSet result = statement.executeQuery("SELECT * FROM COUNTRY");
        while (result.next()) {
            String x = result.getString(2);
            System.out.println(x);
        }
    }

    public static Database getInstance()
    {
        if (obj==null)
            obj = new Database();
        return obj;
    }
}
