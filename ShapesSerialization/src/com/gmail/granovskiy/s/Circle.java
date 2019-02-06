package com.gmail.granovskiy.s;

public class Circle implements Shape {
    //  fields
    private double radius;
    private double area;

    //  constructor
    public Circle(double radius) {
        this.radius = radius;
        this.area = getArea();
    }

    //  getters and setters
    public double getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    //  method to calculate circle area
    @Override
    public double getArea() {
        area = Math.PI * Math.pow(radius, 2);
        return area;
    }

    //   toString method
    @Override
    public String toString() {
        return "Circle{" +
                ", radius=" + radius +
                ", area=" + area +
                '}';
    }
}
