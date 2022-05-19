package com.example.lab99;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CityDAO {
    static Database db;
    private int cityId = 1;

    public CityDAO(Database db){
        this.db=db;
    }

    public void addCity(String countryName, String capitalName, float latitude, float longitude, String cCode, String continent) {
        String sql;
        if (capitalName.equals("N/A"))
            sql = "INSERT INTO CITY VALUES(" + this.cityId + ",'" + countryName + "','" + capitalName + "'," + 0 + "," + latitude + "," + longitude + ")";
        else
            sql = "INSERT INTO CITY VALUES(" + this.cityId + ",'" + countryName + "','" + capitalName + "'," + 1 + "," + latitude + "," + longitude + ")";
        this.cityId++;
        Statement statement;
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

    public static double distance(double lat1, double lon1, double lat2, double lon2) {

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
                * Math.pow(Math.sin(dlon / 2), 2);

        double c = 2 * Math.asin(Math.sqrt(a));

        // Radius of earth in kilometers. Use 3956
        // for miles
        double r = 6371;

        // calculate the result
        return (c * r);
    }

    public static double cityDistance(String city1, String city2) throws SQLException {
        Statement statement = db.getConnection().createStatement();
        statement = db.getConnection().createStatement();
        float latitude1, longitude1, latitude2, longitude2;

        ResultSet result = statement.executeQuery("SELECT LATITUDE,LONGITUDE FROM CITY WHERE CITYNAME='" + city1 + "'");
        result.next();
        latitude1 = Float.parseFloat(result.getString(1));
        longitude1 = Float.parseFloat(result.getString(2));

        result = statement.executeQuery("SELECT LATITUDE,LONGITUDE FROM CITY WHERE CITYNAME='" + city2 + "'");
        result.next();
        latitude2 = Float.parseFloat(result.getString(1));
        longitude2 = Float.parseFloat(result.getString(2));
        return distance(latitude1, longitude1, latitude2, longitude2);
    }
}
