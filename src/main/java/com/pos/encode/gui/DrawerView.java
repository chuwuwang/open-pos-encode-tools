package com.pos.encode.gui;

import javax.swing.*;
import java.awt.*;

public class DrawerView {

    public JScrollPane mainPane;

    public DrawerView() {
        initView();
    }

    private void initView() {
        mainPane = new JScrollPane();

        JPanel panel = new JPanel();
        BoxLayout boxLayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
        panel.setLayout(boxLayout);

        JButton buttonAes = new JButton("AES");

        JButton buttonDes = new JButton("DES/3DES");

        panel.setBackground(Color.BLUE);
        panel.add(buttonAes);
        panel.add(buttonDes);

        mainPane.setPreferredSize(new Dimension(400, 800));

        mainPane.add(panel);
    }

}
