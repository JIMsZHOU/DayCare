package model;

import java.util.List;

public class Classroom extends Room{
    private List<Group> groups;

    public Classroom(String name, String type, int capacity) {
        super(name, type, capacity);
    }
    public Classroom(String name, String type, int capacity, List<Group> groups) {
        super(name, type, capacity);
        this.groups = groups;
    }
}
