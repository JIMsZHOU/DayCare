package controller.stat;

import api.ManageAPI;
import controller.manages.AnnualMange;
import controller.manages.GroupManage;
import controller.manages.StudentManage;
import model.person.Student;
import model.space.Group;

import java.util.Date;
import java.util.List;

/**
 * The type Register manage.
 */
public final class RegisterManage implements ManageAPI {
    /**
     * Do reg check.
     *
     * @param date the date
     */
    public static void doRegCheck(Date date) {
        List<Group> groupList = GroupManage.getInstance().getGroupList();
        for (Group g : groupList) {
            int type = g.getType();
            for (Student s : g.getStudents()) {
                AnnualMange.getInstance().checkReg(s, type, date);
            }
        }
    }

    /**
     * Do vac check.
     *
     * @param date the date
     */
    public static void doVacCheck(Date date) {
        List<Student> studentList = StudentManage.getInstance().getStudentList();
        for (Student s : studentList) {
            AnnualMange.getInstance().checkVac(s, date);
        }
    }

    /**
     * Do check.
     *
     * @param date the date
     */
    public static void doCheck(Date date) {
        AnnualMange.getInstance().clear();
        doRegCheck(date);
        doVacCheck(date);
    }

    /**
     * Sets table.
     *
     * @param studentList the student list
     * @param info        the info
     */
    public static void setTable(List<Student> studentList, String[][] info) {
        for (int i = 0; i < studentList.size(); i++) {
            Student s = studentList.get(i);
            info[i][0] = Integer.toString(s.getId());
            info[i][1] = s.getFirstname();
            info[i][2] = s.getLastname();
            info[i][3] = Integer.toString(s.getAge());
            info[i][4] = s.getGender();
        }
    }
}
