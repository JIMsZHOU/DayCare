package controller.factories;

import api.FactoryAPI;
import model.person.Teacher;

/**
 * The type Teacher factory.
 */
public class TeacherFactory implements FactoryAPI {
    /**
     * Gets object.
     *
     * @param id          the id
     * @param firstname   the firstname
     * @param lastname    the lastname
     * @param age         the age
     * @param gender      the gender
     * @param cellphone   the cellphone
     * @param email       the email
     * @param description the description
     * @return the object
     */
    public Teacher getObject(int id, String firstname, String lastname, int age, String gender, String cellphone, String email, String description) {
        return new Teacher(id, firstname, lastname, age, gender, cellphone, email, description);
    }

    /**
     * Gets object.
     *
     * @param id        the id
     * @param firstname the firstname
     * @param lastname  the lastname
     * @return the object
     */
    public Teacher getObject(int id, String firstname, String lastname) {
        return new Teacher(id, firstname, lastname, -1, "", "", "", "");
    }
}
