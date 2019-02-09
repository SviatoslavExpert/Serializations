package com.gmail.granovskiy.s;

import java.util.ArrayList;
import java.util.List;

public class Group {
    private List<Shape> shape = new ArrayList<>();
    private List<Group> group = new ArrayList<>();

    public void addShape(Shape shape) {
        this.shape.add(shape);
    }

    public void addGroup(Group group) {
        this.group.add(group);
    }

    public List<Shape> getShapes() {
        return shape;
    }

    public List<Group> getGroups() {
        return group;
    }

    @Override
    public String toString() {
        return "Group";
    }
}
