package com.gfarkas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class UI {

    private static final GridLayout GRID_LAYOUT = new GridLayout(3, 3);
    private static final JPanel root = new JPanel(GRID_LAYOUT);
    private static JButton submitButton = new JButton("Submit");
    private static JButton yesButton = new JButton("Yes");
    private static JButton noButton = new JButton("No");
    private static JLabel jlScoreP1 = new JLabel();
    private static JLabel jlScoreP2 = new JLabel();
    private static JTextField inputTextfield = new JTextField("", SwingConstants.CENTER);
    private static JFrame frame = new JFrame("Tic Tac Toe");
    private static int level = 1;
    private static JLabel message = new JLabel(" ", SwingConstants.CENTER);
    private static Game game = new Game();
    private static JLabel jlWannaPlayAgain = new JLabel("Do you want to play again?");

    public UI() {
    }

    public void uiCreator() {

        frame.setLayout(new BorderLayout());
        frame.setMinimumSize(new Dimension(800, 800));
        frame.setResizable(false);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setUndecorated(true);

        JPanel leftPanel = new JPanel();
        leftPanel.setSize(100, 800);
        leftPanel.setPreferredSize(new Dimension(100, 800));
        leftPanel.setMinimumSize(new Dimension(100, 800));

        JPanel rightPanel = new JPanel();
        rightPanel.setSize(100, 800);
        rightPanel.setPreferredSize(new Dimension(100, 800));
        rightPanel.setMinimumSize(new Dimension(100, 800));

        JPanel topPanel = new JPanel();
        topPanel.setPreferredSize(new Dimension(600, 200));
        topPanel.setLayout(new GridLayout(3,3));

        JPanel jpTopLeft = new JPanel();
        jpTopLeft.setPreferredSize(new Dimension(100, 33));
        jpTopLeft.add(jlScoreP1);
        topPanel.add(jpTopLeft);

        topPanel.add(message);
        message.setPreferredSize(new Dimension(600, 33));
        message.setText(String.format("<html>Tic Tac Toe Game vs.  <br> Computer, level:Easy</html>"));
        message.setFont(new Font("Arial", Font.BOLD, 18));
        message.setVisible(true);

        JPanel jpTopRight = new JPanel();
        jpTopRight.setPreferredSize(new Dimension(100, 33));
        submitButton.setSize(new Dimension(80, 30));
        submitButton.setPreferredSize(new Dimension(80, 30));
        submitButton.setVisible(false);
        jpTopRight.add(submitButton);
        topPanel.add(jpTopRight);

        JPanel jpTopLeft2 = new JPanel();
        jpTopLeft2.setPreferredSize(new Dimension(100, 33));
        jpTopLeft2.add(jlScoreP2);
        topPanel.add(jpTopLeft2);

        inputTextfield.setPreferredSize(new Dimension(400, 33));
        keyListeners(inputTextfield);
        inputTextfield.setVisible(false);
        inputTextfield.setFont(new Font("Arial", Font.PLAIN, 18));
        inputTextfield.setSize(new Dimension(400, 33));
        topPanel.add(inputTextfield);

        JPanel jpTopRight2 = new JPanel();
        jpTopRight2.setPreferredSize(new Dimension(100, 33));
        topPanel.add(jpTopRight2);

        JPanel jpTopLeft3 = new JPanel();
        jpTopLeft3.setPreferredSize(new Dimension(100, 33));
        topPanel.add(jpTopLeft3);

        jlWannaPlayAgain.setVisible(false);
        jlWannaPlayAgain.setFont(new Font("Arial", Font.PLAIN, 18));
        jlWannaPlayAgain.setSize(new Dimension(300, 33));
        topPanel.add(jlWannaPlayAgain);

        JPanel jpTopRight3 = new JPanel();
        jpTopRight3.setPreferredSize(new Dimension(100, 33));
        topPanel.add(jpTopRight3);

        yesButton.setVisible(false);
        yesButton.setSize(new Dimension(20, 20));
        jpTopRight3.add(yesButton);

        // onSubmit
        submitButton.addActionListener(e -> game.onSubmitButtonPress());

        // create a menubar
        JMenuBar jMenuBar = new JMenuBar();

        // create a menu
        JMenu x = new JMenu("Menu");

        // create menuitems
        JMenuItem newGameMenuItem = new JMenuItem("New Game");
        JMenu levelsMenu = new JMenu("Level");
        JMenuItem exitMenuItem = new JMenuItem("Exit");
        JMenuItem easyMenuItem = new JMenuItem("Easy");
        easyMenuItem.setBackground(Color.green);
        JMenuItem mediumMenuItem = new JMenuItem("Medium");
        JMenuItem impossibleMenuItem = new JMenuItem("Impossible");
        JMenuItem playWithFriendMenuItem = new JMenuItem("Play against a friend");
        levelsMenu.add(easyMenuItem);
        levelsMenu.add(mediumMenuItem);
        levelsMenu.add(impossibleMenuItem);
        levelsMenu.add(playWithFriendMenuItem);

        // exit game
        exitMenuItem.addActionListener(e -> frame.dispose());

        // easy
        easyMenuItem.addActionListener(e -> {

            easyMenuItem.setBackground(Color.GREEN);
            mediumMenuItem.setBackground(null);
            impossibleMenuItem.setBackground(null);
            playWithFriendMenuItem.setBackground(null);
            level = 1;
            message.setText(String.format("<html>Tic Tac Toe Game vs.  <br> Computer, level:Easy</html>"));

        });

        // medium
        mediumMenuItem.addActionListener(e -> {

            easyMenuItem.setBackground(null);
            mediumMenuItem.setBackground(Color.GREEN);
            impossibleMenuItem.setBackground(null);
            playWithFriendMenuItem.setBackground(null);
            level = 2;
            message.setText(String.format("<html>Tic Tac Toe Game vs.  <br> Computer, level:Medium</html>"));

        });

        // impossible
        impossibleMenuItem.addActionListener(e -> {

            easyMenuItem.setBackground(null);
            mediumMenuItem.setBackground(null);
            impossibleMenuItem.setBackground(Color.GREEN);
            playWithFriendMenuItem.setBackground(null);
            level = 3;
            message.setText(String.format("<html>Tic Tac Toe Game vs.  <br> Computer, level:Impossible</html>"));

        });

        // play with friend
        playWithFriendMenuItem.addActionListener(e -> {

            easyMenuItem.setBackground(null);
            mediumMenuItem.setBackground(null);
            impossibleMenuItem.setBackground(null);
            playWithFriendMenuItem.setBackground(Color.GREEN);
            level = 4;
            message.setText(String.format("<html>Tic Tac Toe Game vs.  <br> A Friend</html>"));

        });


        // new game
        newGameMenuItem.addActionListener(e -> game.inititializer());

        // add menu items to menu
        x.add(newGameMenuItem);
        x.add(levelsMenu);
        x.add(exitMenuItem);

        // add menu to menu bar
        jMenuBar.add(x);

        // add menubar to frame
        frame.setJMenuBar(jMenuBar);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setSize(800, 100);
        bottomPanel.setPreferredSize(new Dimension(800, 100));
        bottomPanel.setMinimumSize(new Dimension(800, 100));


        frame.add(leftPanel, BorderLayout.WEST);
        frame.add(rightPanel, BorderLayout.EAST);
        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(bottomPanel, BorderLayout.SOUTH);

        root.setSize(400, 400);
        root.setVisible(true);
        frame.getContentPane().add(root, BorderLayout.CENTER);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    public void setMessage(String msg) {
        message.setText(msg);
        message.repaint();
        message.setBackground(Color.green);
    }

    public int getLevel() {
        return level;
    }

    public void submitButtonVisible(boolean visible) {

        if (visible) {

            submitButton.setVisible(true);

        } else {

            submitButton.setVisible(false);

        }

    }

    public String getInputTextfield() {
        return inputTextfield.getText();
    }

    public void setInputTextfield(String inputTextfield) {
        UI.inputTextfield.setText(inputTextfield);
    }

    public void inputSetVisible(boolean visible) {

        inputTextfield.setVisible(visible);

    }

    public void setRootVisible(boolean visible) {

        root.setVisible(visible);

    }

    public void setRootBackground(Color gridBackground) {

        root.setBackground(gridBackground);

    }

    public void addToRoot(Node node) {

        root.add(node);

    }

    public void clearNodesFromRoot() {

        for (int i = 0; i < 9; i++) {

            root.removeAll();
            root.revalidate();
            root.repaint();

        }

    }

    public void setScoreP1(String score) {

        jlScoreP1.setText(score);

    }

    public void setScoreP2(String score) {

        jlScoreP2.setText(score);

    }

    public void keyListeners(JTextField textField) {

        textField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {

                    if (textField == inputTextfield) {

                        game.onSubmitButtonPress();

                    }

                }

            }

        });

    }

}
