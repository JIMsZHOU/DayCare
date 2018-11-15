package model.person;

/**
 * Parent class don't have other features, and have all data that Person have.
 * Derived from Person class.
 */
public class Parent extends Person {
    /**
     * Instantiates a new Parent.
     *
     * @param id        the id
     * @param firstname the firstname
     * @param lastname  the lastname
     * @param age       the age
     * @param gender    the gender
     * @param cellphone the cellphone
     * @param email     the email
     * @param address   the address
     */
    public Parent(int id, String firstname, String lastname, int age, String gender, String cellphone, String email, String address) {
        super(id, firstname, lastname, age, gender, cellphone, email, address);
    }
}
