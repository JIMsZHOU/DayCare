package model.person;

/**
 * Parent class don't have other features, and have all data that Person have.
 * Derived from Person class.*/
public class Parent extends Person {
    public Parent(int id, String firstname, String lastname, int age, String gender, String cellphone, String email, String address) {
        super(id, firstname, lastname, age, gender, cellphone, email, address);
    }
}
