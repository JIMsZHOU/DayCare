package controller.factories;

import api.FactoryAPI;
import model.person.Teacher;

public class TeacherFactory implements FactoryAPI {
    public Teacher getObject(int id, String firstname, String lastname, int age, String gender, String cellphone, String email, String description) {
        return new Teacher(id, firstname, lastname, age, gender, cellphone, email, description);
    }

    public Teacher getObject(int id, String firstname, String lastname) {
        return new Teacher(id, firstname, lastname, -1, "", "", "", "");
    }
}
