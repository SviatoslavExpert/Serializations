package com.gmail.granovskiy.s;

public class Serialization {
    public static void main(String[] args) throws IllegalAccessException {
        //  Creating objects shapeGroup1 and shapeGroup2
        Group shapeGroupOne = new Group();
        Group shapeGroupTwo = new Group();
        Group group = new Group();
        //  adding shapes objects to GroupOne object
        shapeGroupOne.addShape(new Square(3));
        shapeGroupOne.addShape(new Circle(10));
        shapeGroupOne.addShape(new Triangle(9, 4, 6));
        shapeGroupOne.addShape(new Square(7));
        group.addGroup(shapeGroupOne);
        //  adding shapes objects to shapeGroupTwo object
        shapeGroupTwo.addShape(new Square(9));
        shapeGroupTwo.addShape(new Triangle(11, 12, 5));
        shapeGroupTwo.addShape(new Circle(17));
        group.addGroup(shapeGroupTwo);
        //  Printing
        System.out.println(XmlSerializationMaker.encode(group));
        System.out.println();
        System.out.println(JsonSerializationMaker.encode(group));
    }
}
