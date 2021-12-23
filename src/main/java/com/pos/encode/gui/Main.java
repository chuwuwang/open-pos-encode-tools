package com.pos.encode.gui;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        jFrame.setTitle("POS Encode");
        // jFrame.setBounds(600, 300, 600, 400);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = jFrame.getContentPane();
        container.setLayout(new BorderLayout());

        DrawerView drawerView = new DrawerView();

        JLabel lableSimple2 = new JLabel("44");
        lableSimple2.setBackground(Color.RED);

        container.add(drawerView.mainPane, BorderLayout.LINE_START);
        container.add(lableSimple2, BorderLayout.CENTER);

        jFrame.setSize(1200, 800);

        Dimension frameSize = jFrame.getSize();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = screenSize.width;
        int height = screenSize.height;
        if (frameSize.height > screenSize.height) {
            frameSize.height = screenSize.height;
        }
        if (frameSize.width > screenSize.width) {
            frameSize.width = screenSize.width;
        }
        jFrame.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);

        jFrame.setLocationRelativeTo(null);

        jFrame.setResizable(false);
        jFrame.setVisible(true);
    }

}
