package controller;

import model.Teacher;

public class TeacherManage extends AbstractPersonManage{
    private static TeacherManage ourInstance = new TeacherManage();

    public static synchronized TeacherManage getInstance() {
        return ourInstance;
    }

    private TeacherManage() { }
}
