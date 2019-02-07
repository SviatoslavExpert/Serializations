package com.gmail.granovskiy.s;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.List;

public class XmlSerializationMaker {
    public static String encode(Group group) throws IllegalAccessException {
        String s = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n";
        s += encodeGroup(group);
        return s;
    }

    private static String encodeGroup(Group group) throws IllegalAccessException {
        String s = "";
        List<Group> groups = group.getGroups();
        for (Group group1 : groups) {
            s += "<" + group1.getClass().getSimpleName() + ">\n";
            s += encodeShape(group1);
            s += "</" + group1.getClass().getSimpleName() + ">\n";
        }
        return s;
    }

    private static String encodeShape(Group group) throws IllegalAccessException {
        String s = "";
        List<Shape> shapes = group.getShapes();
        for (Shape shape : shapes) {
            Field[] fields = shape.getClass().getDeclaredFields();
            s += "\t<" + shape.getClass().getSimpleName() + ">\n";
            s += encodeField(fields, shape);
            s += "\t</" + shape.getClass().getSimpleName() + ">\n";
        }
        return s;
    }

    private static String encodeField(Field[] fields, Shape shape) throws IllegalAccessException {
        String s = "";
        for (Field field : fields) {
            field.setAccessible(true);
            if (field.getType().isArray()) {
                s += encodeArrayField(field, shape);
            } else {
                s += "\t\t<" + field.getName() + ">";
                s += field.get(shape).toString();
                s += "</" + field.getName() + ">\n";
            }
        }
        return s;
    }

    private static String encodeArrayField(Field field, Shape shape) throws IllegalAccessException {
        String s = "";
        for (int i = 0; i < Array.getLength(field.get(shape)); i++) {
            s += "\t\t<" + field.getName() + (i + 1) + ">";
            s += Array.get(field.get(shape), i).toString() + "</" + field.getName() + (i + 1) + ">\n";
        }
        return s;
    }
}
