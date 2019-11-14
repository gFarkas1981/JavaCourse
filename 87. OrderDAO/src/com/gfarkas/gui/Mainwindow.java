/*
 * Created by JFormDesigner on Wed Nov 13 14:50:57 CET 2019
 */

package com.gfarkas.gui;

import java.awt.event.*;
import com.gfarkas.model.DBModel;
import com.gfarkas.model.IModel;

import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author unknown
 */
public class Mainwindow extends JFrame {

    private IModel model;

    public Mainwindow() {

        super();
        String username = "root";
        String password = "1234";
        String db_url = "jdbc:mysql://localhost:3306/megrendelesek";

        initComponents();
        setVisible(true);
        setTitle("Customers and Orders manager");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);


        Connection connection = null;

        try {

            connection = DriverManager.getConnection(db_url, username, password);
            model = new DBModel(connection);

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(getRootPane(), e.toString(), "Database error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);

        }

    }

    public static void main(String[] args) {

        new Mainwindow();

    }

    private void exitMenuItemActionPerformed(ActionEvent e) {

        System.exit(0);

    }

    private void CustomersMenuItemActionPerformed(ActionEvent e) {

        CustomersDialog customersDialog = new CustomersDialog(this, model);
        customersDialog.setVisible(true);


    }

    private void ordersMenuItemActionPerformed(ActionEvent e) {

        OrdersDialog ordersDialog = new OrdersDialog(this, model);
        ordersDialog.setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        menuBar = new JMenuBar();
        fileMenu = new JMenu();
        exitMenuItem = new JMenuItem();
        dataMenu = new JMenu();
        CustomersMenuItem = new JMenuItem();
        ordersMenuItem = new JMenuItem();

        //======== this ========
        Container contentPane = getContentPane();

        //======== menuBar ========
        {

            //======== fileMenu ========
            {
                fileMenu.setText("File");

                //---- exitMenuItem ----
                exitMenuItem.setText("Exit");
                exitMenuItem.addActionListener(e -> exitMenuItemActionPerformed(e));
                fileMenu.add(exitMenuItem);
            }
            menuBar.add(fileMenu);

            //======== dataMenu ========
            {
                dataMenu.setText("Data");

                //---- CustomersMenuItem ----
                CustomersMenuItem.setText("Customers");
                CustomersMenuItem.addActionListener(e -> CustomersMenuItemActionPerformed(e));
                dataMenu.add(CustomersMenuItem);

                //---- ordersMenuItem ----
                ordersMenuItem.setText("Orders");
                ordersMenuItem.addActionListener(e -> ordersMenuItemActionPerformed(e));
                dataMenu.add(ordersMenuItem);
            }
            menuBar.add(dataMenu);
        }
        setJMenuBar(menuBar);

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGap(0, 398, Short.MAX_VALUE)
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGap(0, 246, Short.MAX_VALUE)
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JMenuBar menuBar;
    private JMenu fileMenu;
    private JMenuItem exitMenuItem;
    private JMenu dataMenu;
    private JMenuItem CustomersMenuItem;
    private JMenuItem ordersMenuItem;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
