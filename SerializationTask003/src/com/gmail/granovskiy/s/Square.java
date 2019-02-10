package com.gmail.granovskiy.s;

public class Square implements Shape {
    private double side;
    private double perimeter;
    private double area;

    public Square(double side) {
        this.side = side;
        setPerimeter();
        setArea();
    }

    private double setPerimeter() {
        perimeter = 4 * getSide();
        return perimeter;
    }

    @Override
    public double setArea() {
        area = Math.pow(getSide(), 2);
        return area;
    }

    private double getSide() {
        return side;
    }

    @Override
    public String toString() {
        return "Square";
    }
}
