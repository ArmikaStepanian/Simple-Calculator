package ru.stepanian.calc;

import com.jtattoo.plaf.texture.TextureLookAndFeel;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

/**
 * Created by 1 on 11.12.2015.
 */
public class StartCalculator {

    public static final String INPUT_NUMBER = "add number";

    private JLabel labelNumber1;
    private JLabel labelNumber2;
    private JLabel labelResult;

    private JTextField field1;
    private JTextField field2;
    private JTextField fieldResult;

    private JButton buttonPlus;
    private JButton buttonMinus;
    private JButton buttonDivide;
    private JButton buttonMultiply;
    private JButton buttonClean;


    private JPanel p1;
    private JPanel p2;

    private MyFrameGUI frame;


    private void createLabels() {
        labelNumber1 = new JLabel("Number 1:");
        labelNumber2 = new JLabel("Number 2:");
        labelResult = new JLabel("Result:");
    }

    private void createTextFields() {
        field1 = new JTextField(INPUT_NUMBER);
        field2 = new JTextField(INPUT_NUMBER);
        fieldResult = new JTextField();
        fieldResult.setEditable(false);
        fieldResult.setFocusable(false);
    }

    private void createButtons() {
        buttonPlus = new JButton("+");
        buttonMinus = new JButton("-");
        buttonMultiply = new JButton("*");
        buttonDivide = new JButton("/");
        buttonClean = new JButton("C");
    }

    private void createPanels() {
        p1 = new JPanel(new GridLayout(6, 0));
        p1.setBorder(LineBorder.createBlackLineBorder());
        p1.add(labelNumber1);
        p1.add(field1);
        p1.add(labelNumber2);
        p1.add(field2);
        p1.add(labelResult);
        p1.add(fieldResult);

        p2 = new JPanel(new GridLayout(5, 0));
        p2.setBorder(LineBorder.createBlackLineBorder());
        p2.add(buttonPlus);
        p2.add(buttonMinus);
        p2.add(buttonMultiply);
        p2.add(buttonDivide);
        p2.add(buttonClean);
    }

    private void createFrame() {
        frame = new MyFrameGUI("Calculator", 300, 200);
        frame.setLayout(new GridLayout(0, 2));
        frame.getContentPane().add(p1);
        frame.getContentPane().add(p2);
        frame.setVisible(true);
    }

    private void addCalculatorListener() {   //Регистрация слушателя для кнопок
        CalculatorListener calculatorListener = new CalculatorListener(field1, field2, fieldResult); //связываем с нашим калькулятором (передача данных между классами)
        buttonPlus.addActionListener(calculatorListener);
        buttonMinus.addActionListener(calculatorListener);
        buttonMultiply.addActionListener(calculatorListener);
        buttonDivide.addActionListener(calculatorListener);
        buttonClean.addActionListener(calculatorListener);
    }

    private void addFocusListener() {
        field1.addFocusListener(new CalcFieldsFocusListener(field1));
        field2.addFocusListener(new CalcFieldsFocusListener(field2));
    }


    public static void main(String[] args) throws UnsupportedLookAndFeelException {

        UIManager.setLookAndFeel(new TextureLookAndFeel());
        JFrame.setDefaultLookAndFeelDecorated(true);

        StartCalculator start = new StartCalculator();

        start.createLabels();
        start.createTextFields();
        start.createButtons();
        start.createPanels();
        start.createFrame();
        start.addCalculatorListener();
        start.addFocusListener();

    }

}
















