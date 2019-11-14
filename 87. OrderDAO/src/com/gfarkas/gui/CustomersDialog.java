/*
 * Created by JFormDesigner on Wed Nov 13 13:10:44 CET 2019
 */

package com.gfarkas.gui;

import com.gfarkas.model.Customer;
import com.gfarkas.model.IModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.List;

/**
 * @author unknown
 */
public class CustomersDialog extends JDialog {

    private IModel model;
    private Frame parent;
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JScrollPane scrollPane;
    private JList customersList;
    private JButton editButton;
    private JButton newButton;
    private JButton okButton;
    private JButton deleteButton;

    public CustomersDialog(java.awt.Frame parent, IModel model) {
        super(parent, true);
        initComponents();
        setLocationRelativeTo(null);
        this.model = model;
        this.parent = parent;

        reloadCustomer();

    }

    private void okButtonActionPerformed(ActionEvent e) {

        setVisible(false);

    }

    private void newButtonActionPerformed(ActionEvent e) {

        CustomerDataDialog customerDataDialog = new CustomerDataDialog(parent, null);
        customerDataDialog.setVisible(true);
        Customer customer = customerDataDialog.getCustomer();

        if (customerDataDialog.isSave()) {

            try {

                model.addCustomer(customer);
                reloadCustomer();
                customerDataDialog.setVisible(false);

            } catch (SQLException ex) {

                JOptionPane.showMessageDialog(rootPane, e.toString(), "Database error", JOptionPane.ERROR_MESSAGE);

            }

        }

    }

    private void reloadCustomer() {

        try {

            List<Customer> customers = model.getAllCustomer();
            customersList.setListData(customers.toArray());
            customersList.setSelectedIndex(0);

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(rootPane, e.toString(), "Database error", JOptionPane.ERROR_MESSAGE);

        }


    }

    private void deleteButtonActionPerformed(ActionEvent e) {

        Customer selected = (Customer) customersList.getSelectedValue();

        if (selected != null) {

            try {

                String[] options = new String[2];
                options[0] = "Agree";
                options[1] = "Disagree";

                if (JOptionPane.showOptionDialog(parent,
                        "Do you really want to delete this customer???",
                        "Delete confirmation",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.INFORMATION_MESSAGE,
                        null, options,
                        0) == 0) {

                    model.deleteCustomer(selected);
                    reloadCustomer();

                }

            } catch (SQLException ex) {

                JOptionPane.showMessageDialog(rootPane, e.toString(), "Database error", JOptionPane.ERROR_MESSAGE);

            }

        } else {

            JOptionPane.showMessageDialog
                    (rootPane, "Please select a customer to delete!",
                            "There's no selected customer", JOptionPane.ERROR_MESSAGE);

        }

    }

    private void editButtonActionPerformed(ActionEvent e) {

        Customer selected = (Customer) customersList.getSelectedValue();

        if (selected != null) {

            CustomerDataDialog customerDataDialog = new CustomerDataDialog(parent, selected);
            customerDataDialog.setVisible(true);
            Customer customer = customerDataDialog.getCustomer();


            try {

                model.updateCustomer(customer);
                reloadCustomer();
                customerDataDialog.setVisible(false);

            } catch (SQLException ex) {

                JOptionPane.showMessageDialog(rootPane, e.toString(), "Database error", JOptionPane.ERROR_MESSAGE);

            }


        } else {

            JOptionPane.showMessageDialog
                    (rootPane, "Please select a customer to modify!",
                            "There's no selected customer", JOptionPane.ERROR_MESSAGE);

        }

    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        scrollPane = new JScrollPane();
        customersList = new JList();
        editButton = new JButton();
        newButton = new JButton();
        okButton = new JButton();
        deleteButton = new JButton();

        //======== this ========
        Container contentPane = getContentPane();

        //======== scrollPane ========
        {
            scrollPane.setViewportView(customersList);
        }

        //---- editButton ----
        editButton.setText("Edit");
        editButton.addActionListener(e -> editButtonActionPerformed(e));

        //---- newButton ----
        newButton.setText("New");
        newButton.addActionListener(e -> {
            newButtonActionPerformed(e);
            newButtonActionPerformed(e);
            newButtonActionPerformed(e);
        });

        //---- okButton ----
        okButton.setText("OK");
        okButton.addActionListener(e -> okButtonActionPerformed(e));

        //---- deleteButton ----
        deleteButton.setText("Delete");
        deleteButton.addActionListener(e -> deleteButtonActionPerformed(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 370, GroupLayout.PREFERRED_SIZE)
                                .addGap(97, 97, 97)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(okButton)
                                        .addComponent(newButton)
                                        .addComponent(editButton)
                                        .addComponent(deleteButton))
                                .addGap(371, 371, 371))
        );
        contentPaneLayout.linkSize(SwingConstants.HORIZONTAL, deleteButton, editButton, newButton);
        contentPaneLayout.setVerticalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addComponent(newButton)
                                                .addGap(18, 18, 18)
                                                .addComponent(editButton)
                                                .addGap(18, 18, 18)
                                                .addComponent(deleteButton)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(okButton))
                                        .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 426, GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 31, Short.MAX_VALUE))
        );
        contentPaneLayout.linkSize(SwingConstants.VERTICAL, deleteButton, editButton, newButton);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
