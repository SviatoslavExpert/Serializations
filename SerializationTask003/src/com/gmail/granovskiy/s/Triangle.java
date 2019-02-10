package com.gmail.granovskiy.s;

public class Triangle implements Shape {
    private double sideA;
    private double sideB;
    private double sideC;
    private double perimeter;
    private double area;

    public Triangle(double sideA, double sideB, double sideC) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
        this.perimeter = setPerimeter();
        this.area = setArea();
    }

    private boolean existTriangle() {
        if ((sideA + sideB > sideC)
                && (sideA + sideC > sideB)
                && (sideB + sideC > sideA)) {
            return true;
        } else {
            return false;
        }
    }

    private double setPerimeter() {
        if (existTriangle()) {
            perimeter = sideA + sideB + sideC;
            return perimeter;
        } else {
            throw new IllegalArgumentException("The triangle doesn't exist.");
        }
    }

    @Override
    public double setArea() {
        if (existTriangle()) {
            double p = perimeter / 2;
            area = Math.sqrt(p * (p - sideA) * (p - sideB) * (p - sideC));
        }
        return area;
    }

    @Override
    public String toString() {
        return "Triangle";
    }
}
