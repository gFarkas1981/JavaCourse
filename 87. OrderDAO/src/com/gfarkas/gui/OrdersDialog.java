/*
 * Created by JFormDesigner on Thu Nov 14 10:00:59 CET 2019
 */

package com.gfarkas.gui;

import java.awt.event.*;

import com.gfarkas.model.Customer;
import com.gfarkas.model.IModel;
import com.gfarkas.model.Order;
import com.sun.org.apache.xpath.internal.operations.Or;

import java.awt.*;
import java.sql.SQLException;
import java.util.List;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.table.*;

/**
 * @author unknown
 */
public class OrdersDialog extends JDialog {

    private IModel model;
    private Frame parent;

    public OrdersDialog(java.awt.Frame parent, IModel model) {
        super(parent, true);
        initComponents();
        setLocationRelativeTo(null);
        this.model = model;
        this.parent = parent;

        String[] columnNames = { "Name", "Email", "Pieces", "Amount", "Is:"};
        DefaultTableModel dtm = (DefaultTableModel) ordersJTable.getModel();

        for (String columnName : columnNames) {

            dtm.addColumn(columnName);

        }

        reloadOrders();

    }

    private void reloadOrders() {

        DefaultTableModel dtm = (DefaultTableModel) ordersJTable.getModel();
        // empty table
        while(dtm.getRowCount() > 0) {

            dtm.removeRow(0);

        }


        try {

            List<Order> orders = model.getAllOrder();

            for (Order order : orders) {

                String name = (model.getCustomerById(order.getCustomerId())).getName();
                String email = (model.getCustomerById(order.getCustomerId())).getEmail();
                int pieces = order.getPieces();
                int amount = order.getAmount();
                String isComplete = order.isComplete() ? "complete" : "not complete";
                // Append a row
                dtm.addRow(new Object[]{name, email, pieces, amount, isComplete});

            }

            DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
            rightRenderer.setHorizontalAlignment( JLabel.RIGHT );
            DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
            leftRenderer.setHorizontalAlignment( JLabel.LEFT );
            ordersJTable.setDefaultRenderer(Object.class, rightRenderer);
            ordersJTable.getColumn("Name").setCellRenderer(leftRenderer);

            ordersJTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            resizeColumnWidth(ordersJTable);
            ordersJTable.setRowSelectionInterval(0,0);

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(rootPane, e.toString(), "Database error", JOptionPane.ERROR_MESSAGE);

        }

    }

    public void resizeColumnWidth(JTable table) {
        final TableColumnModel columnModel = table.getColumnModel();
        for (int column = 0; column < table.getColumnCount(); column++) {
            int width = 15; // Min width
            for (int row = 0; row < table.getRowCount(); row++) {
                TableCellRenderer renderer = table.getCellRenderer(row, column);
                Component comp = table.prepareRenderer(renderer, row, column);
                width = Math.max(comp.getPreferredSize().width +1 , width);
            }
            if(width > 300)
                width=300;
            columnModel.getColumn(column).setPreferredWidth(width);
        }
    }

    private void newOrderJButtonActionPerformed(ActionEvent e) {

        OrderDataDialog orderDataDialog = new OrderDataDialog(parent, model, null);
        orderDataDialog.setVisible(true);
        Order order = orderDataDialog.getOrder();

        if (orderDataDialog.isSave()) {

            try {

                model.addOrder(order);
                reloadOrders();
                orderDataDialog.setVisible(false);

            } catch (SQLException ex) {

                JOptionPane.showMessageDialog(rootPane, e.toString(), "Database error", JOptionPane.ERROR_MESSAGE);

            }

        }

    }

    private void editOrderJButtonActionPerformed(ActionEvent e) {


        int idOfselectedCustomer = 0;
        try {

            idOfselectedCustomer = model.getCustomerIdByNameAndEmail(
                    ordersJTable.getValueAt(ordersJTable.getSelectedRow(), 0).toString(),
                    ordersJTable.getValueAt(ordersJTable.getSelectedRow(), 1).toString());
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(rootPane, e.toString(), "Database error", JOptionPane.ERROR_MESSAGE);

        }

        boolean isComplete = ordersJTable.getValueAt(ordersJTable.getSelectedRow(), 4).toString()
                .equalsIgnoreCase("complete");

        Order selectedOrder = new Order(idOfselectedCustomer,
                Integer.valueOf(ordersJTable.getValueAt(ordersJTable.getSelectedRow(), 3).toString()),
                Integer.valueOf(ordersJTable.getValueAt(ordersJTable.getSelectedRow(), 2).toString()),
                isComplete);


        OrderDataDialog orderDataDialog = new OrderDataDialog(parent, model, selectedOrder);
        orderDataDialog.setVisible(true);
        Order order = orderDataDialog.getOrder();

        if (orderDataDialog.isSave()) {

            try {

                model.updateOrder(order);
                reloadOrders();
                orderDataDialog.setVisible(false);

            } catch (SQLException ex) {

                JOptionPane.showMessageDialog(rootPane, e.toString(), "Database error", JOptionPane.ERROR_MESSAGE);

            }

        }

    }

    private void deleteOrderJButtonActionPerformed(ActionEvent e) {

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


                int idOfselectedCustomer = model.getCustomerIdByNameAndEmail(
                        ordersJTable.getValueAt(ordersJTable.getSelectedRow(), 0).toString(),
                        ordersJTable.getValueAt(ordersJTable.getSelectedRow(), 1).toString());

                boolean isComplete = ordersJTable.getValueAt(ordersJTable.getSelectedRow(), 4).toString()
                        .equalsIgnoreCase("complete");

                Order selectedOrder = new Order(idOfselectedCustomer,
                        Integer.valueOf(ordersJTable.getValueAt(ordersJTable.getSelectedRow(), 3).toString()),
                        Integer.valueOf(ordersJTable.getValueAt(ordersJTable.getSelectedRow(), 2).toString()),
                        isComplete);

                model.deleteOrder(selectedOrder);
                reloadOrders();

            }

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(rootPane, e.toString(), "Database error", JOptionPane.ERROR_MESSAGE);

        }

    }


    private void okOrderJButtonActionPerformed(ActionEvent e) {

        setVisible(false);

    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        ordersJScrollPane = new JScrollPane();
        ordersJTable = new JTable();
        newOrderJButton = new JButton();
        editOrderJButton = new JButton();
        deleteOrderJButton = new JButton();
        okOrderJButton = new JButton();

        //======== this ========
        Container contentPane = getContentPane();

        //======== ordersJScrollPane ========
        {
            ordersJScrollPane.setViewportView(ordersJTable);
        }

        //---- newOrderJButton ----
        newOrderJButton.setText("New");
        newOrderJButton.addActionListener(e -> newOrderJButtonActionPerformed(e));

        //---- editOrderJButton ----
        editOrderJButton.setText("Edit");
        editOrderJButton.addActionListener(e -> editOrderJButtonActionPerformed(e));

        //---- deleteOrderJButton ----
        deleteOrderJButton.setText("Delete");
        deleteOrderJButton.addActionListener(e -> deleteOrderJButtonActionPerformed(e));

        //---- okOrderJButton ----
        okOrderJButton.setText("OK");
        okOrderJButton.addActionListener(e -> okOrderJButtonActionPerformed(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(ordersJScrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(newOrderJButton)
                            .addContainerGap(19, Short.MAX_VALUE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(deleteOrderJButton)
                                .addComponent(editOrderJButton)
                                .addComponent(okOrderJButton))
                            .addContainerGap(19, Short.MAX_VALUE))))
        );
        contentPaneLayout.linkSize(SwingConstants.HORIZONTAL, new Component[] {deleteOrderJButton, editOrderJButton, newOrderJButton, okOrderJButton});
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(newOrderJButton)
                            .addGap(18, 18, 18)
                            .addComponent(editOrderJButton)
                            .addGap(18, 18, 18)
                            .addComponent(deleteOrderJButton)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(okOrderJButton))
                        .addComponent(ordersJScrollPane, GroupLayout.PREFERRED_SIZE, 483, GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(19, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JScrollPane ordersJScrollPane;
    private JTable ordersJTable;
    private JButton newOrderJButton;
    private JButton editOrderJButton;
    private JButton deleteOrderJButton;
    private JButton okOrderJButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
