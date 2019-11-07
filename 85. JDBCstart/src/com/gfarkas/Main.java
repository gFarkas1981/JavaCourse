package com.gfarkas;

import com.sun.xml.internal.ws.api.pipe.ClientPipeAssemblerContext;

import java.sql.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String userName = "root";
        String password = "1234";
        String db_url = "jdbc:mysql://localhost:3306/world";
        Scanner scanner = new Scanner(System.in);

        try {

            try (Connection connection = DriverManager.getConnection(db_url, userName, password)) {
                PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement("SELECT * FROM city where CountryCode = ?");
                System.out.println("Please enter a country code! ie.: 'HUN'");
                String code = scanner.nextLine();
                preparedStatement.setString(1, code);
                String sql = "SELECT * FROM city where CountryCode='HUN'";
                ResultSet resultSet = preparedStatement.executeQuery(sql);

                while (resultSet.next()) {

                    String name = resultSet.getString("Name");
                    String county = resultSet.getString("District");
                    String population = resultSet.getString("Population");
                    System.out.println(name + " " + county + " " + population);

                }

            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Adatbázis hiba: " + e);
        }




    }
}
