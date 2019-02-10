package com.gmail.granovskiy.s;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.List;

public class XmlSerialization {
    public static String encode(Group group) throws IllegalAccessException {
        String xmlString = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n";
        xmlString += encodeGroup(group);
        return xmlString;
    }

    private static String encodeGroup(Group group) throws IllegalAccessException {
        String xmlString = "";
        List<Group> groups = group.getGroups();

        for (Group group1 : groups) {
            xmlString += "<" + group1.getClass().getSimpleName() + ">\n";
            xmlString += encodeShape(group1);
            xmlString += "</" + group1.getClass().getSimpleName() + ">\n";
        }
        return xmlString;
    }

    private static String encodeShape(Group group) throws IllegalAccessException {
        String xmlString = "";
        List<Shape> shapes = group.getShapes();

        for (Shape shape : shapes) {
            Field[] fields = shape.getClass().getDeclaredFields();
            xmlString += "\t<" + shape.getClass().getSimpleName() + ">\n";
            xmlString += encodeField(fields, shape);
            xmlString += "\t</" + shape.getClass().getSimpleName() + ">\n";
        }
        return xmlString;
    }

    private static String encodeField(Field[] fields, Shape shape) throws IllegalAccessException {
        String xmlString = "";

        for (Field field : fields) {
            field.setAccessible(true);

            if (field.getType().isArray()) {
                xmlString += encodeArrayField(field, shape);
            } else {
                xmlString += "\t\t<" + field.getName() + ">";
                xmlString+=field.get(shape).toString();
                xmlString+="</" + field.getName() + ">\n";
            }
        }
        return xmlString;
    }

    private static String encodeArrayField(Field field, Shape shape) throws IllegalAccessException {
        String xmlString = "";

        for (int i = 0; i < Array.getLength(field.get(shape)); i++) {
            xmlString += "\t\t<" + field.getName() + (i + 1) + ">";
            xmlString += Array.get(field.get(shape), i).toString() + "</" + field.getName() + (i + 1) + ">\n";
        }
        return xmlString;
    }
}
