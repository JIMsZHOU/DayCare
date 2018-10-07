package model;

import java.util.List;

public class Group extends Room{
    private Teacher teacher;
    private List<Student> students;

    public Group(String name, String type, int capacity) {
        super(name, type, capacity);
    }

    public Group(String name, String type, int capacity, Teacher teacher, List<Student> students) {
        super(name, type, capacity);
        this.teacher = teacher;
        this.students = students;
    }
}
