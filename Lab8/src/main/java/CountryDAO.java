import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CountryDAO {
    Database db;

    public CountryDAO(Database db){
        this.db=db;
    }


    public void add(int id, String name, String code, String continent) {
        String sql = "INSERT INTO CONTINENT VALUES(" + id + ",'" + name + ",'" + code + ",'" + continent + "')";
        Statement statement = null;
        int rows = 0;
        try {
            statement = db.getConnection().createStatement();
            rows = statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (rows > 0) {
            System.out.println("Added a row in table COUNTRY");
        }
    }

    public void show() throws SQLException {
        Statement statement = db.getConnection().createStatement();
        ResultSet result = statement.executeQuery("SELECT * FROM COUNTRY");
        while (result.next()) {
            String x = result.getString(2);
            System.out.println(x);
        }
    }
}
