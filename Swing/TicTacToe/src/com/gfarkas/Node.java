package com.gfarkas;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Node extends JPanel {

    private int numberOfNode;
    private String symbol;
    private int value;
    private BufferedImage image;


    public Node(int numberOfNode, String symbol, int value) {
        this.numberOfNode = numberOfNode;
        this.symbol = symbol;
        this.value = value;

        setLayout(new BorderLayout());
        setBorder(BorderFactory.createLineBorder(Color.BLACK));

    }

    public int getNumberOfNode() {
        return numberOfNode;
    }

    public void setNumberOfNode(int numberOfNode) {
        this.numberOfNode = numberOfNode;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;



            try {

                if (symbol.equalsIgnoreCase("X")) {

                    image = ImageIO.read(new File("x.png"));

                } else if (symbol.equalsIgnoreCase("O")) {

                    image = ImageIO.read(new File("o.png"));

                }


            } catch (IOException e) {

                e.printStackTrace();

            }


    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);
    }

}
