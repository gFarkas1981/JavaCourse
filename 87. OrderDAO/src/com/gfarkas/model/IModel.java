package com.gfarkas.model;

import java.sql.SQLException;
import java.util.List;

public interface IModel {

    List<Order> getAllOrder() throws SQLException;
    int updateOrder(Order order) throws SQLException;
    int deleteOrder(Order order) throws SQLException;
    int addOrder(Order order) throws SQLException;
    int getIdOfOrder(Order order) throws SQLException;
    Order getOrderById(int id) throws SQLException;

    List<Customer> getAllCustomer() throws SQLException;
    int updateCustomer(Customer customer) throws SQLException;
    int deleteCustomer(Customer customer) throws SQLException;
    int addCustomer(Customer customer) throws SQLException;
    int getCustomerId(Customer customer) throws SQLException;
    Customer getCustomerById(int id) throws  SQLException;
    int getCustomerIdByNameAndEmail(String name, String email) throws SQLException;

    void close() throws SQLException;


}
