package com.gmail.granovskiy.s;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

public class JsonSerializationMaker {
    public static String encode(Group group) throws IllegalAccessException {
        String s = "{\n";
        s += encodeGroup(group);
        s += "}";
        return s;
    }

    private static String encodeGroup(Group group) throws IllegalAccessException {
        String s = "";
        List<Group> groups = group.getGroups();
        for (Group group1 : groups) {
            s += "\t\"" + group1.getClass().getSimpleName().toLowerCase() + "\" : [\n";
            s += encodeShape(group1);
            s += "\t]\n";
        }
        return s;
    }

    private static String encodeShape(Group group) throws IllegalAccessException {
        String s = "";
        List<Shape> shapes = group.getShapes();
        for (int i = 0; i < shapes.size(); i++) {
            Field[] fields = shapes.get(i).getClass().getDeclaredFields();
            s += "\t\t" + "{\n";
            s += encodeField(fields, shapes.get(i));
            if (i < shapes.size() - 1) {
                s += "\t\t}" + "," + "\n";
            }
            if (i == shapes.size() - 1) {
                s += "\t\t}" + "\n";
            }
        }
        return s;
    }

    private static String encodeField(Field[] fields, Shape shape) throws IllegalAccessException {
        String s = "";
        for (int i = 0; i < fields.length; i++ ) {
            s += "\t\t\t\"" + fields[i].getName() + "\": ";
            if (i < fields.length - 1) {
                //s += encodeArrayField(field, shape);
                s += "\"" + fields[i].get(fields[i]) + "\"" + "," + "\n";
            }
            if (i == fields.length - 1){
                s += "\"" + fields[i].toString() + "\"" + "\n";
            }
        }
        return s;
    }

    /*
    private static String encodeField(Field[] fields, Shape shape) throws IllegalAccessException {
        String s = "";
        for (Field field : fields) {
            field.setAccessible(true);
            if (field.getType().isArray()) {
                //s += encodeArrayField(field, shape);
            } else {
                s += "\t\t\t\"" + field.getName() + "\": ";
                s += "\"" + field.get(shape).toString() + "\"" + "," + "heelo" + "\n";
            }
        }
        return s;
    }
    /*


    private static String encodeArrayField(Field field, Shape shape) throws IllegalAccessException {
        String s = "";
        s += "\t\t\t\"" + field.getName() + "\" : ";
        s += "\"" + displayArray(field.get(shape)) + "\"\n";
        return s;
    }

    private static String displayArray(Object theArray) {
        String s = "";
        int length = Array.getLength(theArray);
        s += "[";
        for (int j = 0; j < length; j++) {
            s += Array.get(theArray, j).toString();
            if (j != length - 1) {
                s += ", ";
            }
        }
        s += "]";
        return s;
    }
    */
}
