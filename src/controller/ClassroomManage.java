package controller;

import model.Classroom;

import java.util.List;
import java.util.Vector;

public class ClassroomManage {
    private static ClassroomManage ourInstance = new ClassroomManage();

    public static synchronized ClassroomManage getInstance() {
        return ourInstance;
    }

    private List<Classroom> classrooms;
    private ClassroomManage() {
        classrooms = new Vector<>();
    }

    Classroom getClassroom(String classroomname) {
        for (Classroom anClassroom:
                classrooms) {
            if (anClassroom.getName().equals(classroomname)) {
                return anClassroom;
            }
        }
        return null;
    }

    void addClassroom(Classroom classroom) {
        classrooms.add(classroom);
    }

    void deleteClassroom(Classroom classroom) {
        classrooms.remove(classroom);
    }

    void deleteClassroom(String classroomname) {
        Classroom c = getClassroom(classroomname);
        deleteClassroom(c);
    }

    void updateClassroom(Classroom classroom) {
        Classroom c = getClassroom(classroom.getName());
        if (c != null) {
            deleteClassroom(c);
            addClassroom(c);
        }
    }
}
