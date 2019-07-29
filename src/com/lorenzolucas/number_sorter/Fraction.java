/*
 * File: Fraction.java
 * Name: Lorenzo Lucas
 * Date: 2/21/2019
 * Purpose: Creates fraction class and methods to compare them to each other
 */
package com.lorenzolucas.number_sorter;

public class Fraction implements Comparable<Fraction>{
    private int numerator;
    private int denominator;
    private double value;
    //constructor that also calculates the value of the fraction for easy comparing
    public Fraction(String fraction) throws NumberFormatException, ArrayIndexOutOfBoundsException{
        String fractionSplit[] = fraction.split("/");
        numerator = Integer.parseInt(fractionSplit[0]);
        denominator = Integer.parseInt(fractionSplit[1]);
        if (fractionSplit.length > 2){
            throw new NumberFormatException();
        }
        if (denominator == 0){
            throw new NumberFormatException();
        }
        value = (double) numerator /(double)denominator;

    }
    //converts the fraction back to a string
    public String toString() {
        return numerator + "/" + denominator + " ";
    }
    //method to compare fractions to each other
    @Override
    public int compareTo(Fraction other) {
        if (this.value > other.value){
            return 1;
        } else if (this.value < other.value){
            return -1;
        } else
        return 0;
    }
}
