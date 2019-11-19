package com.gfarkas;/*
 * Created by JFormDesigner on Mon Nov 18 14:38:11 CET 2019
 */

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author unknown
 */
public class Client extends JFrame {

    private Socket socket;
    private BufferedReader bufferedReader;
    private PrintWriter printWriter;

    public Client() {
        initComponents();
    }

    private void connectButtonActionPerformed(ActionEvent e) {

        try {

            socket = new Socket(serverJextField.getText(), 8888);
            bufferedReader = new BufferedReader(new InputStreamReader((socket.getInputStream())));
            printWriter = new PrintWriter(socket.getOutputStream());
            printWriter.println(nameJTextField.getText());
            printWriter.flush();

        } catch (IOException ex) {

            JOptionPane.showMessageDialog(rootPane, ex.toString(), "Network error", JOptionPane.ERROR_MESSAGE);

        }

    }

    public static void main(String[] args) {

        Client client = new Client();
        client.setVisible(true);

    }

    private void button1ActionPerformed(ActionEvent e) {

        printWriter.println("TrafficLight1");
        printWriter.flush();

    }

    private void button2ActionPerformed(ActionEvent e) {

        printWriter.println("TrafficLight2");
        printWriter.flush();
    }

    private void button3ActionPerformed(ActionEvent e) {

        printWriter.println("TrafficLight3");
        printWriter.flush();

    }

    private void button4ActionPerformed(ActionEvent e) {

        printWriter.println("TrafficLight4");
        printWriter.flush();

    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        serverJextField = new JTextField();
        serverJLabel = new JLabel();
        nameLabel = new JLabel();
        nameJTextField = new JTextField();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        button4 = new JButton();
        connectButton = new JButton();

        //======== this ========
        Container contentPane = getContentPane();

        //---- serverJextField ----
        serverJextField.setText("localhost");

        //---- serverJLabel ----
        serverJLabel.setText("Server:");

        //---- nameLabel ----
        nameLabel.setText("Name");

        //---- nameJTextField ----
        nameJTextField.setText("G\u00e1bor");

        //---- button1 ----
        button1.setText("TrafficLight1");
        button1.addActionListener(e -> button1ActionPerformed(e));

        //---- button2 ----
        button2.setText("TrafficLight2");
        button2.addActionListener(e -> button2ActionPerformed(e));

        //---- button3 ----
        button3.setText("TrafficLight3");
        button3.addActionListener(e -> button3ActionPerformed(e));

        //---- button4 ----
        button4.setText("TrafficLight4");
        button4.addActionListener(e -> button4ActionPerformed(e));

        //---- connectButton ----
        connectButton.setText("Connect");
        connectButton.addActionListener(e -> connectButtonActionPerformed(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(serverJLabel))
                                .addComponent(nameLabel))
                            .addGap(18, 18, 18)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(serverJextField, GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                                .addComponent(nameJTextField, GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE))
                            .addGap(40, 40, 40)
                            .addComponent(connectButton))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(23, 23, 23)
                            .addComponent(button1)
                            .addGap(18, 18, 18)
                            .addComponent(button2)
                            .addGap(18, 18, 18)
                            .addComponent(button3)
                            .addGap(18, 18, 18)
                            .addComponent(button4)))
                    .addContainerGap(42, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(14, 14, 14)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(serverJLabel)
                        .addComponent(serverJextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(connectButton))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(nameLabel)
                        .addComponent(nameJTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 107, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(button1)
                        .addComponent(button2)
                        .addComponent(button3)
                        .addComponent(button4))
                    .addGap(67, 67, 67))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JTextField serverJextField;
    private JLabel serverJLabel;
    private JLabel nameLabel;
    private JTextField nameJTextField;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton connectButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
