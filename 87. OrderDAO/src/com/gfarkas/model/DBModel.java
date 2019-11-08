package com.gfarkas.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBModel implements IModel {

    private Connection connection;
    private PreparedStatement getAllCustomerPstmt;
    private PreparedStatement getAllOrderPstmt;
    private PreparedStatement updateOrderPstmt;
    private PreparedStatement updateCustomerPstmt;
    private PreparedStatement deleteCustomerPstmt;
    private PreparedStatement deleteOrderPstmt;
    private PreparedStatement addCustomerPstmt;
    private PreparedStatement addOrderPstmt;
    private PreparedStatement getCustomerIdPstmt;
    private PreparedStatement getOrderIdPstmt;
    private PreparedStatement getCustomerByIdPstmt;
    private PreparedStatement getOrderByIdPstmt;

    public DBModel(Connection connection) throws SQLException {

        this.connection = connection;
        getAllCustomerPstmt =
                connection.prepareStatement("SELECT * FROM szemely");
        getAllOrderPstmt =
                connection.prepareStatement("SELECT * FROM rendeles");
        updateCustomerPstmt =
                connection.prepareStatement
                        ("UPDATE szemely SET nev = ?, email = ? WHERE id = ?");
        updateOrderPstmt =
                connection.prepareStatement
                        ("UPDATE rendeles SET osszeg = ?, darabszam = ?, teljesitve = ? WHERE id = ?");
        deleteCustomerPstmt =
                connection.prepareStatement("DELETE FROM szemely WHERE id = ?");
        deleteOrderPstmt =
                connection.prepareStatement("DELETE FROM rendeles WHERE id = ?");
        addCustomerPstmt =
                connection.prepareStatement
                        ("INSERT INTO szemely (nev, email) VALUES (?, ?)");
        addOrderPstmt = connection.prepareStatement
                        ("INSERT INTO rendeles (rendeloid, osszeg, darabszam, teljesitve) VALUES (?, ?, ?, ?)");
        getCustomerIdPstmt = connection.prepareStatement
                ("SELECT id FROM szemely WHERE nev = ? AND email = ?");
        getOrderIdPstmt = connection.prepareStatement
                ("SELECT id FROM rendeles WHERE rendeloid = ? AND osszeg = ? AND darabszam = ? AND teljesitve = ?");
        getCustomerByIdPstmt = connection.prepareStatement
                ("SELECT * FROM szemely WHERE id = ?");
        getOrderByIdPstmt = connection.prepareStatement("SELECT * FROM rendeles WHERE id = ?");
    }

    @Override
    public List<Order> getAllOrder() throws SQLException {

        ResultSet resultSet = getAllOrderPstmt.executeQuery();
        List<Order> orders = new ArrayList<>();

        while (resultSet.next()) {

            int id = resultSet.getInt("id");
            int orderId = resultSet.getInt("rendeloid");
            int amount = resultSet.getInt("osszeg");
            int pieces = resultSet.getInt("darabszam");
            boolean complete = resultSet.getBoolean("teljesitve");


            Order order = new Order(id, orderId, amount, pieces, complete);
            orders.add(order);

        }

        resultSet.close();

        return orders;

    }

    @Override
    public int updateOrder(Order order) throws SQLException {

        updateOrderPstmt.setInt(1, order.getAmount());
        updateOrderPstmt.setInt(2, order.getPieces());
        updateOrderPstmt.setBoolean(3, order.isComplete());
        updateOrderPstmt.setInt(4, order.getId());

        return updateOrderPstmt.executeUpdate();

    }

    @Override
    public int deleteOrder(Order order) throws SQLException {

        deleteOrderPstmt.setInt(1, getIdOfOrder(order));

        return deleteOrderPstmt.executeUpdate();

    }

    @Override
    public int addOrder(Order order) throws SQLException {

        addOrderPstmt.setInt(1, order.getOrderId());
        addOrderPstmt.setInt(2, order.getAmount());
        addOrderPstmt.setInt(3, order.getPieces());
        addOrderPstmt.setBoolean(4, order.isComplete());

        return addOrderPstmt.executeUpdate();

    }

    @Override
    public int getIdOfOrder(Order order) throws SQLException {

        getOrderIdPstmt.setInt(1, order.getOrderId());
        getOrderIdPstmt.setInt(2, order.getAmount());
        getOrderIdPstmt.setInt(3, order.getPieces());
        getOrderIdPstmt.setBoolean(4, order.isComplete());
        System.out.println(order.getOrderId());
        System.out.println(order.getAmount());
        System.out.println(order.getPieces());
        System.out.println(order.isComplete());
        ResultSet resultSet = getOrderIdPstmt.executeQuery();

        resultSet.first();
        int id = resultSet.getInt("id");
        resultSet.close();

        return id;

    }

    @Override
    public Order getOrderById(int id) throws SQLException {

        getOrderByIdPstmt.setInt(1, id);
        ResultSet resultSet = getOrderByIdPstmt.executeQuery();

        resultSet.first();
        Order order = new Order
                (resultSet.getInt("id"), resultSet.getInt("rendeloid"),
                        resultSet.getInt("osszeg"), resultSet.getInt("darabszam"),
                        resultSet.getBoolean("teljesitve"));

        resultSet.close();

        return order;

    }

    @Override
    public List<Customer> getAllCustomer() throws SQLException {

        ResultSet resultSet = getAllCustomerPstmt.executeQuery();
        List<Customer> customers = new ArrayList<>();

        while (resultSet.next()) {

            int id = resultSet.getInt("id");
            String name = resultSet.getString("nev");
            String email = resultSet.getString("email");

            Customer customer = new Customer(id, name, email);
            customers.add(customer);

        }

        resultSet.close();

        return customers;

    }

    @Override
    public int updateCustomer(Customer customer) throws SQLException {

        updateCustomerPstmt.setString(1, customer.getName());
        updateCustomerPstmt.setString(2, customer.getEmail());
        updateCustomerPstmt.setInt(3, customer.getId());

        return updateCustomerPstmt.executeUpdate();

    }

    @Override
    public int deleteCustomer(Customer customer) throws SQLException {

        deleteCustomerPstmt.setInt(1, getCustomerId(customer));

        return deleteCustomerPstmt.executeUpdate();

    }

    @Override
    public int addCustomer(Customer customer) throws SQLException {

        addCustomerPstmt.setString(1, customer.getName());
        addCustomerPstmt.setString(2, customer.getEmail());

        return addCustomerPstmt.executeUpdate();

    }

    @Override
    public int getCustomerId(Customer customer) throws SQLException {

        getCustomerIdPstmt.setString(1, customer.getName());
        getCustomerIdPstmt.setString(2, customer.getEmail());
        ResultSet resultSet = getCustomerIdPstmt.executeQuery();

        resultSet.first();
        int id = resultSet.getInt("id");
        resultSet.close();

        return id;

    }

    @Override
    public Customer getCustomerById(int id) throws SQLException {

        getCustomerByIdPstmt.setInt(1, id);

        ResultSet resultSet = getCustomerByIdPstmt.executeQuery();

        resultSet.first();
        Customer customer = new Customer(resultSet.getInt
                ("id"), resultSet.getString("nev"), resultSet.getString("email"));

        resultSet.close();

        return customer;

    }

    @Override
    public void close() throws SQLException {

        connection.close();

    }
}