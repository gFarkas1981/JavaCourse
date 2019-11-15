/*
 * Created by JFormDesigner on Fri Nov 15 17:20:19 CET 2019
 */

package com.gfarkas.gui;

import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author unknown
 */
public class OrdersDataDialog {
    public OrdersDataDialog(Window owner) {
        super(owner);
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        customerList = new JDialog();
        comboBox1 = new JComboBox();
        customerLabel = new JLabel();
        saveButton = new JButton();
        cancelButton = new JButton();
        amountLabel = new JLabel();
        amountTextField = new JTextField();
        piecesTextField = new JTextField();
        piecesLabel = new JLabel();
        checkBox1 = new JCheckBox();

        //======== customerList ========
        {
            Container customerListContentPane = customerList.getContentPane();

            //---- customerLabel ----
            customerLabel.setText("Customers: ");

            //---- saveButton ----
            saveButton.setText("Save");

            //---- cancelButton ----
            cancelButton.setText("Cancel");

            //---- amountLabel ----
            amountLabel.setText("Amount:");

            //---- piecesLabel ----
            piecesLabel.setText("Pieces:");

            //---- checkBox1 ----
            checkBox1.setText("Complete     ");
            checkBox1.setHorizontalAlignment(SwingConstants.LEFT);
            checkBox1.setHorizontalTextPosition(SwingConstants.LEADING);

            GroupLayout customerListContentPaneLayout = new GroupLayout(customerListContentPane);
            customerListContentPane.setLayout(customerListContentPaneLayout);
            customerListContentPaneLayout.setHorizontalGroup(
                customerListContentPaneLayout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, customerListContentPaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(customerListContentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(checkBox1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(amountLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(customerLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(piecesLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(customerListContentPaneLayout.createParallelGroup()
                            .addGroup(customerListContentPaneLayout.createSequentialGroup()
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(customerListContentPaneLayout.createParallelGroup()
                                    .addComponent(comboBox1, GroupLayout.PREFERRED_SIZE, 602, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(amountTextField, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(piecesTextField, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)))
                            .addGroup(customerListContentPaneLayout.createSequentialGroup()
                                .addGap(334, 334, 334)
                                .addComponent(saveButton)
                                .addGap(41, 41, 41)
                                .addComponent(cancelButton)))
                        .addGap(233, 233, 233))
            );
            customerListContentPaneLayout.setVerticalGroup(
                customerListContentPaneLayout.createParallelGroup()
                    .addGroup(customerListContentPaneLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(customerListContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(customerLabel)
                            .addComponent(comboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(customerListContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(amountLabel)
                            .addComponent(amountTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(customerListContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(piecesLabel)
                            .addComponent(piecesTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(customerListContentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(checkBox1)
                            .addGroup(customerListContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(saveButton)
                                .addComponent(cancelButton)))
                        .addContainerGap(25, Short.MAX_VALUE))
            );
            customerList.pack();
            customerList.setLocationRelativeTo(customerList.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JDialog customerList;
    private JComboBox comboBox1;
    private JLabel customerLabel;
    private JButton saveButton;
    private JButton cancelButton;
    private JLabel amountLabel;
    private JTextField amountTextField;
    private JTextField piecesTextField;
    private JLabel piecesLabel;
    private JCheckBox checkBox1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
