package com.gmail.granovskiy.s;

public class Triangle implements Shape {
    //  fields
    private double sideOneLength;
    private double sideTwoLength;
    private double sideThreeLength;
    private double area;

    //  constructor
    public Triangle(double sideOneLength, double sideTwoLength, double sideThreeLenth) {
        this.sideOneLength = sideOneLength;
        this.sideTwoLength = sideTwoLength;
        this.sideThreeLength = sideThreeLenth;
        this.area = getArea();
    }

    //  getters and setters
    public double getSideOneLength() {
        return sideOneLength;
    }

    public void setSideOneLength(int sideOneLength) {
        this.sideOneLength = sideOneLength;
    }

    public double getSideTwoLength() {
        return sideTwoLength;
    }

    public void setSideTwoLength(int sideTwoLength) {
        this.sideTwoLength = sideTwoLength;
    }

    public double getSideThreeLenth() {
        return sideThreeLength;
    }

    public void setSideThreeLenth(int sideThreeLength) {
        this.sideThreeLength = sideThreeLength;
    }

    //  method getArea
    @Override
    public double getArea() {
        if (sideOneLength + sideTwoLength > sideThreeLength
                && sideOneLength + sideThreeLength > sideTwoLength
                && sideTwoLength + sideThreeLength > sideOneLength) {
            double perimeter = (sideOneLength + sideTwoLength + sideThreeLength) / 2.0;
            area = Math.sqrt(perimeter * (perimeter - sideOneLength) * (perimeter - sideTwoLength) * (perimeter - sideThreeLength));
        } else {
            System.out.println("The triangle doesn't exist.");
        }
        return area;
    }

    //  toString method
    @Override
    public String toString() {
        return "Triangle{" +
                ", sideOneLength=" + sideOneLength +
                ", sideTwoLength=" + sideTwoLength +
                ", sideThreeLength=" + sideThreeLength +
                ", area=" + area +
                '}';
    }
}
