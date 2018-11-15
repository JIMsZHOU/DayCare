package controller.factories;

import api.FactoryAPI;
import model.person.Parent;
import model.person.Student;

import java.util.Date;

/**
 * The type Student factory.
 */
public class StudentFactory implements FactoryAPI {
    /**
     * Gets object.
     *
     * @param id        the id
     * @param firstname the firstname
     * @param lastname  the lastname
     * @param age       the age
     * @param gender    the gender
     * @param parent    the parent
     * @return the object
     */
    public Student getObject(int id, String firstname, String lastname, int age, String gender, Parent parent) {
        return new Student(id, firstname, lastname, age, gender, parent, null, null);
    }

    /**
     * Gets object.
     *
     * @param id           the id
     * @param firstname    the firstname
     * @param lastname     the lastname
     * @param age          the age
     * @param gender       the gender
     * @param parent       the parent
     * @param registerDate the register date
     * @param vaccineDate  the vaccine date
     * @return the object
     */
    public Student getObject(int id, String firstname, String lastname, int age, String gender, Parent parent, Date registerDate, Date vaccineDate) {
        return new Student(id, firstname, lastname, age, gender, parent, registerDate, vaccineDate);
    }

    /**
     * Gets object.
     *
     * @param id           the id
     * @param firstname    the firstname
     * @param lastname     the lastname
     * @param age          the age
     * @param gender       the gender
     * @param parent       the parent
     * @param registerDate the register date
     * @return the object
     */
    public Student getObject(int id, String firstname, String lastname, int age, String gender, Parent parent, Date registerDate) {
        return new Student(id, firstname, lastname, age, gender, parent, registerDate, null);
    }
}
