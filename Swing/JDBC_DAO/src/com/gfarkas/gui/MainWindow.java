package com.gfarkas.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow {


    private JButton buttonMessage;
    private JPanel panelMain;

    public MainWindow() {
        buttonMessage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JOptionPane.showMessageDialog(null, "Hello World");

            }
        });
    }

    public static void main(String[] args) {

        JFrame frame = new JFrame("JDBC DAO Demo");
        frame.setContentPane(new MainWindow().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);


    }

}
