package com.gmail.granovskiy.s;

public class Square implements Shape {
    //  fields
    private double sideLength;
    private double area;

    //  constructor
    public Square(double sideLength) {
        this.sideLength = sideLength;
        this.area = getArea();
    }

    //  getters and setters
    public double getSideLength() {
        return sideLength;
    }

    public void setSideLength(int sideLength) {
        this.sideLength = sideLength;
    }

    //  method getArea
    @Override
    public double getArea() {
        area = sideLength * sideLength;
        return area;
    }

    //  toSting method
    @Override
    public String toString() {
        return "Square{" +
                ", sideLength=" + sideLength +
                ", area=" + area +
                '}';
    }
}
