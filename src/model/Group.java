package model;

import java.util.List;

public class Group extends Room{
    private Teacher teacher;
    private List<Student> students;


    public Group(String name, String type, int capacity) {
        super(name, type, capacity);
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }
}
