import java.sql.*;
public class Main{
    public static void main(String args[]) throws SQLException {
        Database database = Database.getInstance();
        Connection connection = database.getConnection();

        System.out.println("---------All the continents---------");
        database.showContinents();

        System.out.println("---------Find by id=2---------");
        database.findContinent(2);
        System.out.println("---------Find by name='EUROPA'---------");
        database.findContinent("EUROPA");
        connection.close();
    }
}  