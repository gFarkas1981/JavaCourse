/*
 * Created by JFormDesigner on Thu Nov 14 10:00:59 CET 2019
 */

package com.gfarkas.gui;

import com.gfarkas.model.Customer;
import com.gfarkas.model.IModel;
import com.gfarkas.model.Order;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.List;

import static com.gfarkas.gui.Mainwindow.dataBaseError;

/**
 * @author unknown
 */
public class OrdersDialog extends JDialog {

    private IModel model;
    private Frame parent;
    private JScrollPane ordersJScrollPane;
    private JTable ordersJTable;
    private JButton newOrderJButton;
    private JButton deleteOrderJButton;
    private JButton okOrderJButton;
    private JComboBox customersComboBox;
    private JButton allOrderButton;


    public OrdersDialog(java.awt.Frame parent, IModel model) {
        super(parent, true);
        initComponents();
        setLocationRelativeTo(parent);
        setTitle("Order Manager");
        this.model = model;
        this.parent = parent;

        String[] columnNames = {"Name", "Email", "Pieces", "Amount", "Is:"};
        DefaultTableModel dtm = (DefaultTableModel) ordersJTable.getModel();

        for (String columnName : columnNames) {

            dtm.addColumn(columnName);

        }

        fillUpComboBox();
        reloadOrders(null);
        customersComboBox.setSelectedIndex(-1);


    }

    private void showSelected() {

        DefaultTableModel dtm = (DefaultTableModel) ordersJTable.getModel();
        // empty table
        dtm.getDataVector().clear();
        dtm.fireTableDataChanged();

        Customer customer = ((Customer) customersComboBox.getSelectedItem());

        try {

            List<Order> orders = model.getAllOrder(customer);
            reloadOrders(orders);

        } catch (SQLException e) {

            dataBaseError(rootPane, e);

        }

    }

    private void fillUpComboBox() {



        try {

            List<Customer> customers = model.getAllCustomer();
            customersComboBox.setModel(new DefaultComboBoxModel(customers.toArray()));


        } catch (SQLException e) {

            dataBaseError(rootPane, e);

        }


    }

    private void reloadOrders(List<Order> orders) {

        DefaultTableModel dtm = (DefaultTableModel) ordersJTable.getModel();
        // empty table
        dtm.getDataVector().clear();
        customersComboBox.setSelectedIndex(-1);

        try {

            if (orders == null) {

                orders = model.getAllOrder();

            }

            for (Order order : orders) {

//                Map<Integer, Customer> idsWithCustomers = model.getCustomerMap();
//                String name = idsWithCustomers.get(order.getCustomerId()).getName();
//                String email = (model.getCustomer(order.getCustomerId())).getEmail();
                String name = order.getCustomer().getName();
                String email = order.getCustomer().getEmail();
                int pieces = order.getPieces();
                int amount = order.getAmount();
                String isComplete = order.isComplete() ? "complete" : "not complete";
                // Append a row
                dtm.addRow(new Object[]{name, email, pieces, amount, isComplete});

            }

            DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
            rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
            DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
            leftRenderer.setHorizontalAlignment(JLabel.LEFT);
            ordersJTable.setDefaultRenderer(Object.class, rightRenderer);
            ordersJTable.getColumn("Name").setCellRenderer(leftRenderer);

            ordersJTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            resizeColumnWidth(ordersJTable);

            if (!orders.isEmpty()) {

                ordersJTable.setRowSelectionInterval(0, 0);

            }

        } catch (SQLException e) {

            dataBaseError(rootPane, e);

        }

    }

    public void resizeColumnWidth(JTable table) {
        final TableColumnModel columnModel = table.getColumnModel();
        for (int column = 0; column < table.getColumnCount(); column++) {
            int width = 15; // Min width
            for (int row = 0; row < table.getRowCount(); row++) {
                TableCellRenderer renderer = table.getCellRenderer(row, column);
                Component comp = table.prepareRenderer(renderer, row, column);
                width = Math.max(comp.getPreferredSize().width + 1, width);
            }
            if (width > 300)
                width = 300;
            columnModel.getColumn(column).setPreferredWidth(width);
        }
    }

    private void newOrderJButtonActionPerformed(ActionEvent e) {



        try {

            List<Customer> customers = model.getAllCustomer();
            OrdersDataDialog ordersDataDialog = new OrdersDataDialog(this, customers);
            ordersDataDialog.setVisible(true);

            if (ordersDataDialog.isSave()) {

                Order order = ordersDataDialog.getOrder();
                model.addOrder(order);
                reloadOrders(null);

            }

        } catch (SQLException ex) {

            dataBaseError(rootPane, ex);

        }

    }


    private void deleteOrderJButtonActionPerformed(ActionEvent e) {

        if (ordersJTable.getSelectedRow() != -1) {

            try {

                String[] options = new String[2];
                options[0] = "Agree";
                options[1] = "Disagree";

                if (JOptionPane.showOptionDialog(parent,
                        "Do you really want to delete this order???",
                        "Delete confirmation",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.INFORMATION_MESSAGE,
                        null, options,
                        0) == 0) {


                    int idOfselectedCustomer = model.getCustomerId(
                            ordersJTable.getValueAt(ordersJTable.getSelectedRow(), 0).toString(),
                            ordersJTable.getValueAt(ordersJTable.getSelectedRow(), 1).toString());

                    boolean isComplete = ordersJTable.getValueAt(ordersJTable.getSelectedRow(), 4).toString()
                            .equalsIgnoreCase("complete");

                    Order selectedOrder = new Order(idOfselectedCustomer,
                            Integer.valueOf(ordersJTable.getValueAt(ordersJTable.getSelectedRow(), 3).toString()),
                            Integer.valueOf(ordersJTable.getValueAt(ordersJTable.getSelectedRow(), 2).toString()),
                            isComplete);

                    model.deleteOrder(selectedOrder);
                    ordersJTable.removeRowSelectionInterval(ordersJTable.getSelectedRow(), ordersJTable.getSelectedRow());
                    reloadOrders(model.getAllOrder(model.getCustomer(idOfselectedCustomer)));

                }

            } catch (SQLException ex) {

                dataBaseError(rootPane, ex);

            }

        } else {

            JOptionPane.showMessageDialog(rootPane, "Please select a row to delete!", "There's no row selected", JOptionPane.ERROR_MESSAGE);

        }

    }

    private void okOrderJButtonActionPerformed(ActionEvent e) {

        setVisible(false);

    }

    private void allOrderButtonActionPerformed(ActionEvent e) {

        reloadOrders(null);

    }

    private void customersComboBoxActionPerformed(ActionEvent e) {

        showSelected();

    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        ordersJScrollPane = new JScrollPane();
        ordersJTable = new JTable();
        newOrderJButton = new JButton();
        deleteOrderJButton = new JButton();
        okOrderJButton = new JButton();
        customersComboBox = new JComboBox();
        allOrderButton = new JButton();

        //======== this ========
        Container contentPane = getContentPane();

        //======== ordersJScrollPane ========
        {
            ordersJScrollPane.setViewportView(ordersJTable);
        }

        //---- newOrderJButton ----
        newOrderJButton.setText("New");
        newOrderJButton.addActionListener(e -> newOrderJButtonActionPerformed(e));

        //---- deleteOrderJButton ----
        deleteOrderJButton.setText("Delete");
        deleteOrderJButton.addActionListener(e -> deleteOrderJButtonActionPerformed(e));

        //---- okOrderJButton ----
        okOrderJButton.setText("OK");
        okOrderJButton.addActionListener(e -> okOrderJButtonActionPerformed(e));

        //---- customersComboBox ----
        customersComboBox.addActionListener(e -> customersComboBoxActionPerformed(e));

        //---- allOrderButton ----
        allOrderButton.setText("List all order");
        allOrderButton.addActionListener(e -> allOrderButtonActionPerformed(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addComponent(ordersJScrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED))
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addComponent(customersComboBox, GroupLayout.PREFERRED_SIZE, 268, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(allOrderButton)
                                                .addGap(68, 68, 68)))
                                .addGroup(contentPaneLayout.createParallelGroup()
                                        .addComponent(newOrderJButton)
                                        .addComponent(deleteOrderJButton)
                                        .addComponent(okOrderJButton))
                                .addContainerGap(16, Short.MAX_VALUE))
        );
        contentPaneLayout.linkSize(SwingConstants.HORIZONTAL, deleteOrderJButton, newOrderJButton, okOrderJButton);
        contentPaneLayout.setVerticalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(customersComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(newOrderJButton)
                                        .addComponent(allOrderButton))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(contentPaneLayout.createParallelGroup()
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addComponent(deleteOrderJButton)
                                                .addGap(327, 327, 327)
                                                .addComponent(okOrderJButton))
                                        .addComponent(ordersJScrollPane, GroupLayout.PREFERRED_SIZE, 453, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(13, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
