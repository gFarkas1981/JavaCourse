/*
 * Created by JFormDesigner on Wed Nov 13 15:39:13 CET 2019
 */

package com.gfarkas.gui;

import java.awt.event.*;
import com.gfarkas.model.Customer;
import com.sun.glass.ui.InvokeLaterDispatcher;

import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author unknown
 */
public class CustomerDataDialog extends JDialog {

    private Customer customer;
    private boolean save;

    public CustomerDataDialog(java.awt.Dialog dialog, Customer customer) {
        super(dialog, true);
        initComponents();

        setLocationRelativeTo(dialog);

        this.customer = customer;
        save = false;

        if (customer == null) {

            setTitle("Add new customer");

        } else {

            setTitle("Edit Customer's data");
            nameJTextField.setText(customer.getName());
            emailJTextField.setText(customer.getEmail());

        }


    }

    private void cancelJButtonActionPerformed(ActionEvent e) {

        setVisible(false);

    }

    private void saveJButtonActionPerformed(ActionEvent e) {

        if (customer == null) {

            customer = new Customer();

        }

        customer.setName(nameJTextField.getText());
        customer.setEmail(emailJTextField.getText());
        save = true;
        setVisible(false);


    }

    public boolean isSave() {
        return save;
    }

    public Customer getCustomer() {
        return customer;
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        nameJLabel = new JLabel();
        emailJLabel = new JLabel();
        nameJTextField = new JTextField();
        emailJTextField = new JTextField();
        cancelJButton = new JButton();
        saveJButton = new JButton();

        //======== this ========
        Container contentPane = getContentPane();

        //---- nameJLabel ----
        nameJLabel.setText("Name:");

        //---- emailJLabel ----
        emailJLabel.setText("Email:");

        //---- cancelJButton ----
        cancelJButton.setText("Cancel");
        cancelJButton.addActionListener(e -> cancelJButtonActionPerformed(e));

        //---- saveJButton ----
        saveJButton.setText("Save");
        saveJButton.addActionListener(e -> {
			saveJButtonActionPerformed(e);
			saveJButtonActionPerformed(e);
		});

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(nameJLabel)
                        .addComponent(emailJLabel))
                    .addGap(8, 8, 8)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                        .addComponent(emailJTextField, GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(0, 129, Short.MAX_VALUE)
                            .addComponent(saveJButton)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cancelJButton))
                        .addComponent(nameJTextField, GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE))
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(nameJLabel)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(emailJLabel))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(nameJTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(emailJTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(cancelJButton)
                        .addComponent(saveJButton))
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JLabel nameJLabel;
    private JLabel emailJLabel;
    private JTextField nameJTextField;
    private JTextField emailJTextField;
    private JButton cancelJButton;
    private JButton saveJButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
