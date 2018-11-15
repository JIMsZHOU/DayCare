package controller.manages;

import api.ManageAPI;
import model.person.Student;
import model.space.Group;

import java.util.List;
import java.util.Vector;

/**
 * The type Student manage.
 */
public class StudentManage implements ManageAPI {
    private static StudentManage ourInstance = new StudentManage();

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static synchronized StudentManage getInstance() {
        return ourInstance;
    }

    private int size;
    private List<Student> studentList;

    /**
     * Gets size.
     *
     * @return the size
     */
    public int getSize() {
        return size;
    }

    /**
     * Sets size.
     *
     * @param size the size
     */
    public void setSize(int size) {
        this.size = size;
    }

    private StudentManage() {
        studentList = new Vector<>();
        size = 0;
    }

    /**
     * Gets student list.
     *
     * @return the student list
     */
    public List<Student> getStudentList() {
        return studentList;
    }

    /**
     * Gets student.
     *
     * @param id the id
     * @return the student
     */
    public Student getStudent(int id) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getId() == id) {
                return studentList.get(i);
            }
        }
        return null;
    }

    /**
     * Add student.
     *
     * @param student the student
     */
    public void addStudent(Student student) {
        if (getStudent(student.getId()) != null) return;
        this.studentList.add(student);
        size = studentList.size();
    }

    /**
     * Delete student.
     *
     * @param id the id
     */
    public void deleteStudent(int id) {
        if (getStudent(id) == null) return;
        studentList.remove(getStudent(id));
        size = studentList.size();
        for (Group g : GroupManage.getInstance().getGroupList()) {
            g.deteleStudent(getStudent(id));
        }
    }
}
