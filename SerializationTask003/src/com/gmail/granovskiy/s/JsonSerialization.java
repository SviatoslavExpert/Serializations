package com.gmail.granovskiy.s;

import java.lang.reflect.Field;
import java.util.List;

public class JsonSerialization {
    public static String encode(Group group) throws IllegalAccessException {
        String jsonString = "{\n";
        jsonString += encodeGroup(group);
        jsonString += "}";
        return jsonString;
    }

    private static String encodeGroup(Group group) throws IllegalAccessException {
        String jsonString = "";
        List<Group> groups = group.getGroups();
        for (int i = 0; i < groups.size(); i++) {
            jsonString += "\t\"" + groups.get(i) + "\" : [\n";
            jsonString += encodeShape(groups.get(i));
            if (i < groups.size() - 1) {
                jsonString += "\t],\n";
            }
            if (i == groups.size() - 1) {
                jsonString += "\t]\n";
            }
        }
        return jsonString;
    }

    private static String encodeShape(Group group) throws IllegalAccessException {
        String jsonString = "";
        List<Shape> shapes = group.getShapes();
        for (int i = 0; i < shapes.size(); i++) {
            Field[] fields = shapes.get(i).getClass().getDeclaredFields();
            jsonString += "\t\t" + "{\n";
            jsonString += encodeField(fields, shapes.get(i));
            if (i < shapes.size() - 1) {
                jsonString += "\t\t},\n";
            }
            if (i == shapes.size() - 1) {
                jsonString += "\t\t}\n";
            }
        }
        return jsonString;
    }

    private static String encodeField(Field[] fields, Shape shape) throws IllegalAccessException {
        String jsonString = "";
        for (int i = 0; i < fields.length; i++) {
            fields[i].setAccessible(true);
            jsonString += "\t\t\t\"" + fields[i].getName() + "\" : ";
            if (i < fields.length - 1) {
                jsonString += "\"" + fields[i].get(shape).toString() + "\"" + "," + "\n";
            }
            if (i == fields.length - 1) {
                jsonString += "\"" + fields[i].get(shape).toString() + "\"" + "\n";
            }
        }
        return jsonString;
    }
}
