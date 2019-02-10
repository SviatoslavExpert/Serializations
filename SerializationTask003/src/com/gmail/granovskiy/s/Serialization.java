package com.gmail.granovskiy.s;

public class Serialization {
    public static void main(String[] args) throws IllegalAccessException {
        //  creating groups
        Group shapeGroup1 = new Group();
        Group shapeGroup2 = new Group();
        Group group = new Group();
        //  creating shapes of Group 1
        shapeGroup1.addShape(new Square(2));
        shapeGroup1.addShape(new Circle(5));
        shapeGroup1.addShape(new Triangle(4, 5, 6));
        shapeGroup1.addShape(new Square(5));
        group.addGroup(shapeGroup1);
        //  creating shapes of Group 2
        shapeGroup2.addShape(new Square(10));
        shapeGroup2.addShape(new Triangle(10, 8, 3));
        shapeGroup2.addShape(new Square(50));
        shapeGroup2.addShape(new Circle(50));
        shapeGroup2.addShape(new Circle(1));
        shapeGroup2.addShape(new Triangle(15, 8, 8));
        group.addGroup(shapeGroup2);
        //  calling methods to serialize
        System.out.println(XmlSerialization.encode(group));
        System.out.println(JsonSerialization.encode(group));
    }
}
