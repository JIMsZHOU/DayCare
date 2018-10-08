package model;

import java.util.List;
import java.util.Vector;

public class Parent extends Person {

//    public Parent(String firstname, String lastname) {
//        super(firstname, lastname);
//        children = new Vector<>();
//    }
    public Parent(String firstname, String lastname, int age, String gender, String cellphone, String email, String address) {
        super(firstname, lastname, age, gender, cellphone, email, address);
    }
}
