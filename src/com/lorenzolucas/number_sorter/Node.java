/*
 * File: Node.java
 * Name: Lorenzo Lucas
 * Date: 2/21/2019
 * Purpose: Creates nodes and methods to insert into the trees and traverse them
 */
package com.lorenzolucas.number_sorter;

import java.util.ArrayList;

public class Node {
    private Node left;
    private Node right;
    private int data;
    private Fraction fraction;
    //these are static so that they can added to during recursive methods
    private static ArrayList<Integer> integerArrayList = new ArrayList<>();
    private static ArrayList<String> fractionArrayList = new ArrayList<>();
    //contructor for integer nodes
    public Node(int data){
        this.data = data;
    }
    //constructor for fraction nodes
    public Node(Fraction fraction){
        this.fraction = fraction;
    }
    //insert method for integers
    public void insert(int value){
        if (value <= data){
            if (left == null){
                left = new Node(value);
            } else {
                left.insert(value);
            }
        } else {
            if (right == null){
                right = new Node(value);
            } else {
                right.insert(value);
            }
        }
    }
    //insert method for fractions
    public void insertFraction(Fraction newFraction){
        try {
            if (newFraction.compareTo(fraction) <= 0){
                left.insertFraction(newFraction);
            }
        } catch (NullPointerException e){
            left = new Node(newFraction);
        }
        try {
            if (newFraction.compareTo(fraction) > 0){
                right.insertFraction(newFraction);
            }
        } catch (NullPointerException e){
            right = new Node(newFraction);
        }
    }
    //traversal of integers
    private void traverseInOrder(){
        if (left != null){
            left.traverseInOrder();
        }
            integerArrayList.add(data);
        if (right != null){
            right.traverseInOrder();
        }
    }
    //traversal of fractions
    private void fractionTraverseInOrder(){
        if (left != null){
            left.fractionTraverseInOrder();
        }
        fractionArrayList.add(fraction.toString());
        if (right != null){
            right.fractionTraverseInOrder();
        }
    }
    //gets the ArrayList of integers
    public ArrayList<Integer> getIntArrayList(){
        this.traverseInOrder();
        return integerArrayList;
    }
    //gets the ArrayList of the fraction's toString
    public ArrayList<String> getFractionArrayList(){
        this.fractionTraverseInOrder();
        return fractionArrayList;
    }
    //empties out the indexes of the ArrayLists
    public void clearArrayList(){
        integerArrayList.clear();
        fractionArrayList.clear();
    }
}
