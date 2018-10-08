package controller;

import model.Student;

import java.util.Date;

public class StudentManage extends AbstractPersonManage{
    private static StudentManage ourInstance = new StudentManage();

    public static synchronized StudentManage getInstance() {
        return ourInstance;
    }

    private StudentManage() {

    }
}
