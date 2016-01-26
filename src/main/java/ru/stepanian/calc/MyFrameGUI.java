package ru.stepanian.calc;

import javax.swing.*;

/**
 * Created by 1 on 11.12.2015.
 */
public class MyFrameGUI extends JFrame {

    public MyFrameGUI(String title, int width, int height) {
        super(title);
        this.setSize(width, height);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


}
