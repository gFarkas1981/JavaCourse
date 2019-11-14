package com.gfarkas.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewContact extends JFrame{
    private JPanel newContactRootJPanel;
    private JPanel southJPanelForButtons;
    private JPanel westLabelJPanelForJLabels;
    private JPanel eastJPanelForJTextField;
    private JLabel givenNamesJLabel;
    private JLabel surnameJLabel;
    private JLabel mobileNrJLabel;
    private JLabel emailJLabel;
    private JTextField givenNameJTextField;
    private JTextField surnameJTextField;
    private JTextField mobileNrJTextField;
    private JTextField emailJTextField;
    private JButton addContactJButton;
    private JButton noOperationJButton;

    public NewContact() {
        super("Contact Panel");

        addContactJButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

}
