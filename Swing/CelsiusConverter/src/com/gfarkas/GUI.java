package com.gfarkas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame{
    private JPanel mainPanel;
    private JTextField celsiusTextField;
    private JLabel celsiusLabel;
    private JButton convertButton;
    private JLabel farenheitLabel;

    public GUI(String title) {

        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();

        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int tempFahrenheit = (int)((Double.parseDouble(celsiusTextField.getText())) * 1.8 + 32);

                farenheitLabel.setText(tempFahrenheit + " Fahrenheit");

            }
        });
    }

    public static void main(String[] args) {

        JFrame frame = new GUI("My Celsius Converter");
        frame.setVisible(true);

    }

}
