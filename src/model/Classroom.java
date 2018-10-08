package model;

import java.util.List;

public class Classroom extends Room{
    private List<Group> groups;

    public Classroom(String name, String type, int capacity) {
        super(name, type, capacity);
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void addGroups(Group group) {
        this.groups.add(group);
    }
}
