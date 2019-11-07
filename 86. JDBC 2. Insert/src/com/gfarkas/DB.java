package com.gfarkas;

import java.sql.*;

public class DB {

    private String userName = "root";
    private String password = "1234";
    private String db_url = "jdbc:mysql://localhost:3306/megrendelesek";

    public DB() {

        connect();

    }


    public Connection connect() {

        Connection connection = null;

        try {

            connection = DriverManager.getConnection(db_url, userName, password);

        } catch (SQLException e) {

            e.printStackTrace();
            System.out.println("DataBase error: " + e);

        }

        return connection;

    }

    public Customer[] listCustomers() {

        ResultSet resultSet = null;
        String sql = "SELECT * FROM szemely";

        try (PreparedStatement preparedStatement = connect().prepareStatement(sql)) {

            resultSet = preparedStatement.executeQuery();
            int size = 0;
            resultSet.last();    // moves cursor to the last row
            size = resultSet.getRow();
            resultSet.absolute(0);


            Customer[] customers = new Customer[size];

            while (resultSet.next()) {

                int index = resultSet.getRow() - 1;
                Customer customer = new Customer
                        (resultSet.getString("nev"), resultSet.getString("email"));

                customers[index] = customer;

            }

            return customers;

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return null;

    }

    public ResultSet select(String what, String from) {

        ResultSet resultSet = null;
        String sql = "SELECT " + what + " FROM " + from;

        try (PreparedStatement preparedStatement = connect().prepareStatement(sql)) {

            resultSet = preparedStatement.executeQuery();
            return resultSet;

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return null;

    }

    public String newCustomer(String name, String email) {

        String sql = "INSERT INTO szemely (nev, email) VALUES (?, ?)";

        try (PreparedStatement preparedStatement = connect().prepareStatement(sql)) {

            preparedStatement.setString(1, name);
            preparedStatement.setString(2, email);
            preparedStatement.executeUpdate();
            return "Succesfully inserted";

        } catch (SQLException e) {

            e.printStackTrace();
            return "SQL exception: " + e;

        }

    }

    public Customer[] listOrders() {

        ResultSet resultSet = null;
        String sql = "SELECT * FROM szemely";

        try (PreparedStatement preparedStatement = connect().prepareStatement(sql)) {

            resultSet = preparedStatement.executeQuery();
            int size = 0;
            resultSet.last();    // moves cursor to the last row
            size = resultSet.getRow();
            resultSet.absolute(0);


            Customer[] customers = new Customer[size];

            while (resultSet.next()) {

                int index = resultSet.getRow() - 1;
                Customer customer = new Customer
                        (resultSet.getString("nev"), resultSet.getString("email"));

                customers[index] = customer;

            }

            return customers;

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return null;

    }


}
