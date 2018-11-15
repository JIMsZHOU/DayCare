package model.space;

import model.person.Student;
import model.person.Teacher;

import java.util.List;
import java.util.Vector;

public class Group extends Space {

    private Teacher teacher;
    private List<Student> students;

    public Group(int id, String name, int type) {
        super(id, name, type, defineCap(type));
        this.students = new Vector<>();
        this.keepsize();
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void addStudent(Student student) {
        if (this.getRemain() == 0) return;
        this.students.add(student);
        this.keepsize();
    }

    public void deteleStudent(Student student) {
        if (student == null) return;
        System.out.println("deleting...");
        students.remove(student);
        this.keepsize();
    }

    private void keepsize() {
        this.setRemain(this.getCapacity() - this.students.size());
    }

    private static int defineCap(int type) {
        switch (type) {
            case 0: return 4; // 6 - 12 month
            case 1: return 5; // 13 -24 month
            case 2: return 6; // 25 - 35 month
            case 3: return 8; // 36 - 47 month
            case 4: return 12; // 48 - 59 month
            case 5: return 15; // 60 - more month
            default: return -1; //return -1 means it was error
        }
    }
}
