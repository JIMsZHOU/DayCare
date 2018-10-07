package model;

import java.util.List;

public class Parent extends Person {
    List<Student> children;

    public Parent(String firstname, String lastname, List<Student> children) {
        super(firstname, lastname);
        this.children = children;
    }

    public Parent(String firstname, String lastname, int age, String gender, String cellphone, String email, String address, List<Student> children) {
        super(firstname, lastname, age, gender, cellphone, email, address);
        this.children = children;
    }
}
