package controller.manages;

import api.ManageAPI;
import model.person.Teacher;
import model.space.Group;

import java.util.List;
import java.util.Vector;

public class TeacherManage implements ManageAPI {
    private static TeacherManage ourInstance = new TeacherManage();

    public static synchronized TeacherManage getInstance() {
        return ourInstance;
    }

    private int size;
    private List<Teacher> teacherList;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    private TeacherManage() {
        teacherList = new Vector<>();
        size = 0;
    }

    public List<Teacher> getTeacherList() {
        return teacherList;
    }

    public void addTeacher(Teacher teacher) {
        if (getTeacher(teacher.getId()) != null) return;
        this.teacherList.add(teacher);
        size ++;
    }

    public Teacher getTeacher(int id) {
        for (int i = 0; i < teacherList.size(); i++) {
            if (teacherList.get(i).getId() == id) {
                return teacherList.get(i);
            }
        }
        return null;
    }

    public void deleteTeacher(int id) {
        if (getTeacher(id) == null) return;
        teacherList.remove(getTeacher(id));
        size--;
        for (Group g : GroupManage.getInstance().getGroupList()) {
            if (g.getTeacher().getId() == id) {
                g.setTeacher(null);
            }
        }
    }
}
