package com.gmail.granovskiy.s;

public class Circle implements Shape {
    private double radius;
    private double area;

    public Circle(double radius) {
        this.radius = radius;
        setArea();
    }

    @Override
    public double setArea() {
        area = Math.PI * Math.pow(this.radius, 2);
        return area;
    }

    @Override
    public String toString() {
        return "Circle";
    }
}
