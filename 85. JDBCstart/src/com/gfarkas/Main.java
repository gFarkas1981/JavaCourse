package com.gfarkas;

import com.sun.xml.internal.ws.api.pipe.ClientPipeAssemblerContext;

import java.sql.*;

public class Main {

    public static void main(String[] args) {

        String userName = "root";
        String password = "1234";
        String db_url = "jdbc:mysql://localhost:3306/world";

        try {

            Connection connection = DriverManager.getConnection(db_url, userName, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM city");

            while (resultSet.next()) {

                String nev = resultSet.getString("Name");
                String megye = resultSet.getString("District");
                String nepesseg = resultSet.getString("Population");
                System.out.println(nev + " " + megye + " " + nepesseg);

            }

            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Adatbázis hiba: " + e);
        }




    }
}
