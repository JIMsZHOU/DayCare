package controller.manages;

import api.ManageAPI;
import model.person.Student;
import model.space.Group;

import java.util.List;
import java.util.Vector;

public class StudentManage implements ManageAPI {
    private static StudentManage ourInstance = new StudentManage();

    public static synchronized StudentManage getInstance() {
        return ourInstance;
    }

    private int size;
    private List<Student> studentList;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    private StudentManage() {
        studentList = new Vector<>();
        size = 0;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public Student getStudent(int id) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getId() == id) {
                return studentList.get(i);
            }
        }
        return null;
    }

    public void addStudent(Student student) {
        if (getStudent(student.getId()) != null) return;
        this.studentList.add(student);
        size = studentList.size();
    }

    public void deleteStudent(int id) {
        if (getStudent(id) == null) return;
        studentList.remove(getStudent(id));
        size = studentList.size();
        for (Group g : GroupManage.getInstance().getGroupList()) {
            g.deteleStudent(getStudent(id));
        }
    }
}
