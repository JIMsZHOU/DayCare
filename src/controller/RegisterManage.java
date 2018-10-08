package controller;

import model.*;

import java.text.SimpleDateFormat;
import java.util.Date;

public class RegisterManage {

    private static int getCapacity(String type) {
        int capacity = 0;
        switch (type) {
            case "6-12":
                capacity = 4;
                break;
            case "13-24":
                capacity = 5;
                break;
            case "25-35":
                capacity = 6;
                break;
            case "36-47":
                capacity = 8;
                break;
            case "48-59":
                capacity = 12;
                break;
            case "60-20000":
                capacity = 15;
                break;
            default:
                break;
        }
        return capacity;
    }

    public static void addStudenttoGroup(Group group, Student student) {
        String[] sa = group.getType().split("-");
        int age = student.getAge();
        if (Integer.parseInt(sa[0]) <= age && Integer.parseInt(sa[1]) >= age){
            Group g = GroupManage.getInstance().getGroup(group.getName());
            student.setRegisterDate(new Date());
            if (g != null && !g.getStudents().contains(student) && g.getCapacity() > g.getStudents().size()) g.addStudent(student);
        }
    }

    public static void addTeachertoGroup(Group group, Teacher teacher) {
        Group g = GroupManage.getInstance().getGroup(group.getName());
        if (g.getTeacher() == null) g.setTeacher(teacher);
    }

    public static void addGrouptoClassroom(Classroom classroom, Group group) {
        if (classroom.getType().equals(group.getType())) {
            Classroom c = ClassroomManage.getInstance().getClassroom(classroom.getName());
            if (c != null && !c.getGroups().contains(group) && c.getCapacity() > c.getGroups().size()) c.addGroups(group);
        }
    }

    public static void registerGroup(String groupname, String grouptype) {
        int capacity = getCapacity(grouptype);
        if (capacity != 0) GroupManage.getInstance().addGroup(new Group(groupname, grouptype, capacity));
    }

    public static void registerClassroom(String classroomname, String classroomtype) {
        int capacity = getCapacity(classroomtype);
        if (capacity != 0) ClassroomManage.getInstance().addClassroom(new Classroom(classroomname, classroomtype, capacity));
    }

    public static void registerTeacher(String firstname, String lastname, int age, String gender, String cellphone, String email) {
        if (TeacherManage.getInstance().getPerson(firstname,lastname) == null) TeacherManage.getInstance().addPerson(new Teacher(firstname,lastname,age,gender,cellphone,email));
    }

    public static void registerStudent(String firstname, String lastname, int age, String gender,String pfirstname, String plastname, int page, String pgender, String pcellphone, String pemail, String paddress) {
        if (StudentManage.getInstance().getPerson(firstname,lastname) == null) {
            Parent p = (Parent) ParentManage.getInstance().getPerson(pfirstname,plastname);
            if (p == null) {
                p = new Parent(pfirstname,plastname,page,pgender,pcellphone,pemail,paddress);
            }
            StudentManage.getInstance().addPerson(new Student(firstname,lastname,age,gender,p));
            ParentManage.getInstance().addPerson(p);
        }
    }

    public static void updateStudent(String firstname, String lastname, int age, String gender) {
        Student s = (Student) StudentManage.getInstance().getPerson(firstname,lastname);
        s.setAge(age);
        s.setGender(gender);
    }

    public static void updateTeacher(String firstname, String lastname, int age, String gender, String cellphone, String email) {
        Teacher t = (Teacher) TeacherManage.getInstance().getPerson(firstname,lastname);
        t.setAge(age); t.setGender(gender); t.setCellphone(cellphone);t.setEmail(email);
    }

    public static void updateParent(String firstname, String lastname, int age, String gender, String cellphone, String email, String address) {
        Parent p = (Parent) ParentManage.getInstance().getPerson(firstname,lastname);
        p.setAge(age);p.setGender(gender);p.setCellphone(cellphone);p.setEmail(email);p.setAddress(address);
    }

    public void takeVaccine(String firstname, String lastname) {
        Student s = (Student) StudentManage.getInstance().getPerson(firstname, lastname);
        s.setVaccineDate(new Date());
    }
}
