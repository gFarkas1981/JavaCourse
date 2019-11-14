/*
 * Created by JFormDesigner on Thu Nov 14 11:21:11 CET 2019
 */

package com.gfarkas.gui;

import com.gfarkas.model.Customer;
import com.gfarkas.model.IModel;
import com.gfarkas.model.Order;

import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author unknown
 */
public class OrderDataDialog extends JDialog {

    private Order order;
    private boolean save;

    public boolean isSave() {
        return save;
    }

    public OrderDataDialog(java.awt.Frame parent, IModel model, Order order) {

        super(parent, true);
        initComponents();

        this.order = order;
        save = false;

        setLocationRelativeTo(parent);

        if (order == null) {

            setTitle("Add new order");

        } else {

            int customerID = order.getCustomerId();
            Customer customer = new Customer();
            customer.setId(customerID);

            setTitle("Edit data of order");
            orderDataDialogNameJTextField.setText(customer.getName());
            orderDataDialogEmailJtextField.setText(customer.getEmail());
            orderDataDialogAmountTextField.setText(String.valueOf(order.getAmount()));
            orderDataDialogPiecesTextField.setText(String.valueOf(order.getPieces()));

            if (order.isComplete()) {

                orderDataDialogIsCompleteCheckBox.setSelected(true);

            } else{

                orderDataDialogIsCompleteCheckBox.setSelected(false);

            }


        }

    }

    public Order getOrder() {
        return order;
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        orderDataSaveJButton = new JButton();
        orderDataCancelJButton = new JButton();
        orderDataDialogNameJTextField = new JTextField();
        orderDataDialogEmailJtextField = new JTextField();
        orderDataDialogPiecesTextField = new JTextField();
        orderDataDialogAmountTextField = new JTextField();
        orderDataDialogIsCompleteCheckBox = new JCheckBox();
        label5 = new JLabel();

        //======== this ========
        Container contentPane = getContentPane();

        //---- label1 ----
        label1.setText("Name:");

        //---- label2 ----
        label2.setText("Email:");

        //---- label3 ----
        label3.setText("Pieces");

        //---- label4 ----
        label4.setText("Amount:");

        //---- orderDataSaveJButton ----
        orderDataSaveJButton.setText("Save");

        //---- orderDataCancelJButton ----
        orderDataCancelJButton.setText("Cancel");

        //---- orderDataDialogIsCompleteCheckBox ----
        orderDataDialogIsCompleteCheckBox.setText("Complete");

        //---- label5 ----
        label5.setText("USD");

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addGroup(GroupLayout.Alignment.LEADING, contentPaneLayout.createSequentialGroup()
                            .addGap(16, 16, 16)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGroup(contentPaneLayout.createParallelGroup()
                                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label4)
                                        .addComponent(label3)
                                        .addComponent(label2))
                                    .addGap(23, 23, 23)
                                    .addGroup(contentPaneLayout.createParallelGroup()
                                        .addComponent(orderDataDialogNameJTextField, GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
                                        .addComponent(orderDataDialogEmailJtextField, GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(orderDataDialogPiecesTextField, GroupLayout.Alignment.LEADING)
                                                .addComponent(orderDataDialogAmountTextField, GroupLayout.Alignment.LEADING))
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(label5)
                                            .addGap(0, 202, Short.MAX_VALUE))))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(orderDataDialogIsCompleteCheckBox, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 290, Short.MAX_VALUE))))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addContainerGap(214, Short.MAX_VALUE)
                            .addComponent(orderDataSaveJButton)
                            .addGap(18, 18, 18)
                            .addComponent(orderDataCancelJButton)))
                    .addGap(18, 18, 18))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(17, 17, 17)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label1)
                        .addComponent(orderDataDialogNameJTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label2)
                        .addComponent(orderDataDialogEmailJtextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label3)
                        .addComponent(orderDataDialogPiecesTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label4)
                        .addComponent(orderDataDialogAmountTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label5))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                    .addComponent(orderDataDialogIsCompleteCheckBox)
                    .addGap(22, 22, 22)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(orderDataCancelJButton)
                        .addComponent(orderDataSaveJButton))
                    .addGap(17, 17, 17))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JButton orderDataSaveJButton;
    private JButton orderDataCancelJButton;
    private JTextField orderDataDialogNameJTextField;
    private JTextField orderDataDialogEmailJtextField;
    private JTextField orderDataDialogPiecesTextField;
    private JTextField orderDataDialogAmountTextField;
    private JCheckBox orderDataDialogIsCompleteCheckBox;
    private JLabel label5;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}


