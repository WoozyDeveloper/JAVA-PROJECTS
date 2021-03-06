import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.sql.*;
public class Main{



    public static void main(String args[]) throws SQLException {
        Database database = Database.getInstance();

        ContinentDAO continentDAO = new ContinentDAO(database);
        CityDAO cityDAO = new CityDAO(database);

        Connection connection = database.getConnection();

        System.out.println("---------All the continents---------");
        continentDAO.show();

        System.out.println("---------Find by id=2---------");
        continentDAO.addContinents();
        Continent myContinent = continentDAO.findById(2);
        System.out.println(myContinent.getName());
        System.out.println("---------Find by name='EUROPA'---------");
        Continent myContinent2 = continentDAO.findByName("EUROPA");
        System.out.println(myContinent2.getName());

//        int lineNumber = 0;
//        File file = new File("src/main/resources/concap.csv");
//        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
//            for(String line; (line = br.readLine()) != null; ) {
//                if(lineNumber == 0) {
//                    lineNumber++;
//                    continue;
//                }
//                String[] myString = line.split(",");
//                String countryName = myString[0];
//                String capitalName = myString[1];
//                Float latitude = Float.parseFloat(myString[2]);
//                Float longitude = Float.parseFloat(myString[3]);
//                String countryCode = myString[4];
//                String continentName = myString[5];
//
//                database.addCity(countryName,capitalName,latitude,longitude,countryCode,continentName);
//                //System.out.print(countryName + capitalName + "\n");
//            }
//            // line is not visible here.
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        System.out.println("Distance=" + cityDAO.cityDistance("Hargeisa","Ottawa"));

        new Test();
        connection.close();
    }
}  