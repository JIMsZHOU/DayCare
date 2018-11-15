package controller.factories;

import api.FactoryAPI;
import model.person.Parent;

/**
 * The type Parent factory.
 */
public class ParentFactory implements FactoryAPI {
    /**
     * Gets object.
     *
     * @param id        the id
     * @param firstname the firstname
     * @param lastname  the lastname
     * @param age       the age
     * @param gender    the gender
     * @param cellphone the cellphone
     * @param email     the email
     * @param address   the address
     * @return the object
     */
    public Parent getObject(int id, String firstname, String lastname, int age, String gender, String cellphone, String email, String address) {
        return new Parent(id, firstname, lastname, age, gender, cellphone, email, address);
    }

    /**
     * Gets object.
     *
     * @param id        the id
     * @param firstname the firstname
     * @param lastname  the lastname
     * @return the object
     */
    public Parent getObject(int id, String firstname, String lastname) {
        // When age is -1 means don't have this information.
        return new Parent(id, firstname, lastname, -1, "", "", "", "");
    }
}
