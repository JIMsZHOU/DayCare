package controller.factories;

import api.FactoryAPI;
import model.person.Parent;
import model.person.Student;

import java.util.Date;

public class StudentFactory implements FactoryAPI {
    public Student getObject(int id, String firstname, String lastname, int age, String gender, Parent parent) {
        return new Student(id, firstname, lastname, age, gender, parent, null, null);
    }

    public Student getObject(int id, String firstname, String lastname, int age, String gender, Parent parent, Date registerDate, Date vaccineDate) {
        return new Student(id, firstname, lastname, age, gender, parent, registerDate, vaccineDate);
    }

    public Student getObject(int id, String firstname, String lastname, int age, String gender, Parent parent, Date registerDate) {
        return new Student(id, firstname, lastname, age, gender, parent, registerDate, null);
    }
}
