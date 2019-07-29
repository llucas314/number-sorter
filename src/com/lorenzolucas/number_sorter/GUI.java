/*
 * File: GUI.java
 * Name: Lorenzo Lucas
 * Date: 2/21/2019
 * Purpose: Creates the GUI for the program and includes the main method
 */
package com.lorenzolucas.number_sorter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame {

    //Creates GUI constructor
    private GUI(){
        super("Binary Search Tree Sort");
        setSize(400,275);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel mainPanel = new JPanel();
        JPanel inputPanel = new JPanel();
        JPanel buttonPanel = new JPanel();
        JPanel resultPanel = new JPanel();
        JPanel radioPanel =  new JPanel();
        JPanel sortPanel = new JPanel();
        JPanel numericPanel = new JPanel();
        // input panel
        JLabel inputLabel = new JLabel("Original List", JLabel.CENTER);
        inputPanel.add(inputLabel);
        JTextField inputTextField = new JTextField(20);
        inputTextField.setEditable(true);
        inputPanel.add(inputTextField);
        // result panel
        JLabel resultLabel = new JLabel("Sorted List   ", JLabel.CENTER);
        resultPanel.add(resultLabel);
        JTextField resultTextField = new JTextField(20);
        resultTextField.setEditable(false);
        resultPanel.add(resultTextField);
        //text panel
        JPanel textPanel = new JPanel();
        textPanel.setLayout(new GridLayout(2,0));
        textPanel.add(inputPanel);
        textPanel.add(resultPanel);
        // button panel
        JButton button = new JButton("Perform Sort");
        buttonPanel.setLayout(new GridBagLayout());
        buttonPanel.add(button, new GridBagConstraints());
        //radio buttons panel
        JRadioButton ascendingButton = new JRadioButton("Ascending", true);
        JRadioButton descendingButton = new JRadioButton("Descending");
        ButtonGroup sortGroup = new ButtonGroup();
        sortGroup.add(ascendingButton);
        sortGroup.add(descendingButton);
        sortPanel.setLayout(new GridLayout(2,1));
        sortPanel.setBorder(BorderFactory.createTitledBorder("Sort Order"));
        sortPanel.add(ascendingButton);
        sortPanel.add(descendingButton);
        JRadioButton integerButton = new JRadioButton("Integer", true);
        JRadioButton fractionButton = new JRadioButton("Fraction");
        ButtonGroup numericGroup = new ButtonGroup();
        numericGroup.add(integerButton);
        numericGroup.add(fractionButton);
        numericPanel.setLayout(new GridLayout(2,1));
        numericPanel.setBorder(BorderFactory.createTitledBorder("Numeric Type"));
        numericPanel.add(integerButton);
        numericPanel.add(fractionButton);
        radioPanel.setLayout(new GridLayout(1,2));
        radioPanel.add(sortPanel);
        radioPanel.add(numericPanel);
        //main panel
        mainPanel.setLayout(new GridLayout(3,1));
        mainPanel.add(textPanel);
        mainPanel.add(buttonPanel);
        mainPanel.add(radioPanel);
        add(mainPanel);

        //button action
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userInput = inputTextField.getText();
                BinaryTree binaryTree;
                String resultText = null;
                // creates tree based on radio button selection
                if (integerButton.isSelected()){
                    if (ascendingButton.isSelected()){
                        binaryTree = new BinaryTree(true,true);
                    } else {
                        binaryTree = new BinaryTree(true,false);
                    }
                } else {
                    if (ascendingButton.isSelected()){
                        binaryTree = new BinaryTree(false,true);
                    } else {
                        binaryTree = new BinaryTree(false,false);
                    }
                }
                try {
                    resultText = binaryTree.constructTree(userInput);
                } catch (NumberFormatException ne){
                    JOptionPane.showMessageDialog(null,"Non-numeric Input");
                } catch (ArrayIndexOutOfBoundsException ae) {
                    JOptionPane.showMessageDialog(null,"Invalid Fractions");
                }
                resultTextField.setText(resultText);
            }
        });


    }
    //main method
    public static void main(String[] args) {
        GUI gui = new GUI();
        gui.setVisible(true);

    }
}