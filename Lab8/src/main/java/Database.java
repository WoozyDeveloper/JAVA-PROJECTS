import java.sql.*;

public class Database {
    private static Database obj;
    private Connection connection;
    private Statement statement;
    private int cityId = 1;
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

    public void addCity(String countryName,String capitalName,float latitude, float longitude, String cCode, String continent){
        String sql;
        if(capitalName.equals("N/A"))
            sql = "INSERT INTO CITY VALUES(" + this.cityId + ",'" + countryName + "','" + capitalName + "'," + 0 + "," + latitude + "," + longitude + ")";
        else
            sql = "INSERT INTO CITY VALUES(" + this.cityId + ",'" + countryName + "','" + capitalName + "'," + 1 + "," + latitude + "," + longitude + ")";
        this.cityId++;
        Statement statement;
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

    public static double distance(double lat1, double lon1, double lat2, double lon2)
    {

        // The math module contains a function
        // named toRadians which converts from
        // degrees to radians.
        lon1 = Math.toRadians(lon1);
        lon2 = Math.toRadians(lon2);
        lat1 = Math.toRadians(lat1);
        lat2 = Math.toRadians(lat2);

        // Haversine formula
        double dlon = lon2 - lon1;
        double dlat = lat2 - lat1;
        double a = Math.pow(Math.sin(dlat / 2), 2)
                + Math.cos(lat1) * Math.cos(lat2)
                * Math.pow(Math.sin(dlon / 2),2);

        double c = 2 * Math.asin(Math.sqrt(a));

        // Radius of earth in kilometers. Use 3956
        // for miles
        double r = 6371;

        // calculate the result
        return(c * r);
    }

    public double cityDistance(String city1, String city2) throws SQLException {
        statement = connection.createStatement();
        float latitude1,longitude1,latitude2,longitude2;
        
        ResultSet result = statement.executeQuery("SELECT LATITUDE,LONGITUDE FROM CITY WHERE CITYNAME='" + city1 + "'" );
        result.next();
        latitude1 = Float.parseFloat(result.getString(1));
        longitude1 = Float.parseFloat(result.getString(2));

        result = statement.executeQuery("SELECT LATITUDE,LONGITUDE FROM CITY WHERE CITYNAME='" + city2 + "'" );
        result.next();
        latitude2 = Float.parseFloat(result.getString(1));
        longitude2 = Float.parseFloat(result.getString(2));
        return distance(latitude1,longitude1,latitude2,longitude2);
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

    public static Database getInstance() {
        if (obj==null)
            obj = new Database();
        return obj;
    }
}
