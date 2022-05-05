import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ContinentDAO {
    int continentId = 1;
    static Database db;
    static List<Continent> continents = new ArrayList<>();

    public ContinentDAO(Database db){
        this.db=db;
    }

    public void add(int id, String name) {
        String sql = "INSERT INTO CONTINENT VALUES(" + id + ",'" + name + "')";
        Statement statement;
        int rows = 0;
        try {
            statement = db.getConnection().createStatement();
            rows = statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (rows > 0) {
            System.out.println("Added a row in table CONTINENT");
        }
    }

    public void show() throws SQLException {
        Statement statement = db.getConnection().createStatement();
        ResultSet result = statement.executeQuery("SELECT * FROM CONTINENT");
        while (result.next()) {
            String x = result.getString(2);
            System.out.println(x);
        }
    }

    public void addContinents() throws SQLException {
        Statement statement = db.getConnection().createStatement();
        ResultSet result = statement.executeQuery("SELECT * FROM CONTINENT");
        while (result.next()) {
            Continent continent = new Continent(Integer.parseInt(result.getString(1)),result.getString(2));
            continents.add(continent);
        }
    }

//    public void findById(int id) throws SQLException {
//        Statement statement = db.getConnection().createStatement();
//        ResultSet result = statement.executeQuery("SELECT * FROM CONTINENT WHERE ID=" + id);
//        while (result.next()) {
//            String x1 = result.getString(1);
//            String x2 = result.getString(2);
//            System.out.println("id=" + x1 + ", name=" + x2);
//        }
//    }

    public Continent findById(int id){
        for(Continent c : continents){
            if(c.getId() == id)
                return c;
        }
        System.out.println("Continent not found");
        return null;
    }

    public void findByName(final String name) throws SQLException {
        Statement statement = db.getConnection().createStatement();
        ResultSet result = statement.executeQuery("SELECT * FROM CONTINENT WHERE NAME='" + name + "'");
        while (result.next()) {
            String x1 = result.getString(1);
            String x2 = result.getString(2);
            System.out.println("id=" + x1 + ", name=" + x2);
        }
    }
}
