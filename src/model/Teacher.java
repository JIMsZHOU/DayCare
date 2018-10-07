package model;

public class Teacher extends Person {
    public Teacher(String firstname, String lastname) {
        super(firstname, lastname);
    }

    public Teacher(String firstname, String lastname, int age, String gender, String cellphone, String email) {
        super(firstname, lastname, age, gender, cellphone, email, null);
    }
}
