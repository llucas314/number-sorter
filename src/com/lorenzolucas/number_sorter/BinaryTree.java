/*
 * File: BinaryTree.java
 * Name: Lorenzo Lucas
 * Date: 2/21/2019
 * Purpose: Creates the binary trees depending on which radio button is selected
 */
package com.lorenzolucas.number_sorter;

import java.util.ArrayList;

public class BinaryTree {
    private boolean isInteger;
    private boolean ascendingOrder;

    public BinaryTree(boolean isInteger, boolean ascendingOrder){
        this.isInteger = isInteger;
        this.ascendingOrder = ascendingOrder;
    }
    //method takes input from GUI class and uses methods from BinaryTree to build trees
    public String constructTree(String inputFromTextField) throws NumberFormatException, ArrayIndexOutOfBoundsException{
        String finalString;
        if (isInteger){
            if (ascendingOrder){
                finalString = printAscending(getIntegerNode(inputFromTextField));
            } else {
                finalString = printDescending(getIntegerNode(inputFromTextField));
            }
        } else {
            if (ascendingOrder){
                finalString = printAscending(getFractionNode(inputFromTextField));
            } else {
                finalString = printDescending(getFractionNode(inputFromTextField));
            }
        }
        return finalString;
    }
    //method to insert integers to binary trees
    private Node getIntegerNode(String inputFromConstruct) throws NumberFormatException{
        //split string by spaces
        String intString[] = inputFromConstruct.split("\\s+");
        int numbers[] = new int[intString.length];
        // change string to int
        for (int i = 0; i < intString.length; i++){
            numbers[i] = Integer.parseInt(intString[i]);
        }
        //add integer to binary tree
        Node rootNode = new Node(numbers[0]);
        for (int i = 1; i < numbers.length; i++){
            rootNode.insert(numbers[i]);
        }
        return rootNode;
    }
    //method to insert fractions to binary trees
    private Node getFractionNode(String inputFromConstruct) throws NumberFormatException, ArrayIndexOutOfBoundsException{
        //split string by space
        String fractionString[] = inputFromConstruct.split("\\s+");
        Fraction fractions[] = new Fraction[fractionString.length];
        // change string to fraction
        for (int i = 0; i < fractionString.length; i++){
            fractions[i] = new Fraction(fractionString[i]);
        }
        //add fraction to binary tree
        Node rootNode = new Node(fractions[0]);
        for (int i = 1; i < fractions.length; i++){
            rootNode.insertFraction(fractions[i]);
        }
        return rootNode;
    }
    //returns string in ascending order for either integer or fraction
    private String printAscending(Node binaryTree) {
        StringBuilder ascendResult = new StringBuilder();
        if (isInteger) {
            ArrayList<Integer> integerArrayList = binaryTree.getIntArrayList();
            for (int i = 0; i < integerArrayList.size(); i++) {
                ascendResult.append(String.valueOf(integerArrayList.get(i) + " "));
            }
        } else {
            ArrayList<String> fractionArrayList = binaryTree.getFractionArrayList();
            for (int i = 0; i < fractionArrayList.size(); i++) {
                ascendResult.append(fractionArrayList.get(i));
            }
        }
        //resets the array after each sort since the array is static
        binaryTree.clearArrayList();
        return ascendResult.toString();

    }
    //returns string in descending order for either integer or fraction
    private String printDescending(Node binaryTree){
        StringBuilder descendResult = new StringBuilder();
        if (isInteger) {
            ArrayList<Integer> integerArrayList = binaryTree.getIntArrayList();
            for (int i = integerArrayList.size() - 1; i >= 0; i--) {
                descendResult.append(String.valueOf(integerArrayList.get(i) + " "));
            }
        } else {
            ArrayList<String> fractionArrayList = binaryTree.getFractionArrayList();
            for (int i = fractionArrayList.size() - 1; i >= 0; i--){
                descendResult.append(fractionArrayList.get(i));
            }
        }
        //resets the array after each sort since the array is static
        binaryTree.clearArrayList();
        return descendResult.toString();
    }
}
