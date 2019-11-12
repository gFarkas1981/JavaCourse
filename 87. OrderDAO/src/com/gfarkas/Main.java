package com.gfarkas;

import com.gfarkas.model.DBModel;
import com.gfarkas.model.IModel;
import com.gfarkas.model.Customer;
import com.gfarkas.model.Order;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        String userName = "root";
        String password = "1234";
        String db_url = "jdbc:mysql://localhost:3306/megrendelesek";
        List<Customer> customersBeforeDelete = null;
        List<Customer> customersAfterDelete = null;
        List<Order> ordersBeforeDelete = null;
        List<Order> ordersAfterDelete = null;

        try {

            Connection connection = DriverManager.getConnection(db_url, userName, password);
            IModel model = new DBModel(connection);

            Customer customer = new Customer("Bela", "bela@gmail.com");
            model.addCustomer(customer);
//            int id = model.getCustomerId(customer);
            int id = customer.getId();
            Customer nemBela = new Customer(id,"Dezso", "dezsi@gmail.com");
            model.updateCustomer(nemBela);
            customersBeforeDelete = model.getAllCustomer();

            Order order = new Order(model.getCustomerId(nemBela), 2784, 29, true);
            model.addOrder(order);
            id = model.getIdOfOrder(order);
            order = new Order(id,2688, 28, true);
            model.updateOrder(order);
            ordersBeforeDelete = model.getAllOrder();
            model.deleteOrder(model.getOrderById(id));
            ordersAfterDelete = model.getAllOrder();

            model.deleteCustomer(nemBela);
            customersAfterDelete = model.getAllCustomer();

            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println();
        System.out.println();
        System.out.println("Customers before delete:");
        System.out.println("---------------------------------------------");
        for (Customer customer1 : customersBeforeDelete) {

            System.out.println(customer1);

        }

        System.out.println();
        System.out.println();
        System.out.println("Customers after delete:");
        System.out.println("---------------------------------------------");
        for (Customer customer1 : customersAfterDelete) {

            System.out.println(customer1);

        }

        System.out.println();
        System.out.println();
        System.out.println("Orders before delete:");
        System.out.println("---------------------------------------------");
        for (Order order1 : ordersBeforeDelete) {

            System.out.println(order1);

        }

        System.out.println();
        System.out.println();
        System.out.println("Orders after delete:");
        System.out.println("---------------------------------------------");
        for (Order order1 : ordersAfterDelete) {

            System.out.println(order1);

        }




    }
}
