package model;

import java.util.Date;

public class Student extends Person{
    private Parent parent;
    private Date registerDate;
    private Date vaccineDate;

    public Student(String firstname, String lastname, int age, Parent parent) {
        this(firstname, lastname, age, null, parent,null, null);
    }

    public Student(String firstname, String lastname, int age, String gender, Parent parent, Date registerDate, Date vaccineDate) {
        super(firstname, lastname, age, gender, null, null, null);
        this.parent = parent;
        this.registerDate = registerDate;
        this.vaccineDate = vaccineDate;
    }

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public Date getVaccineDate() {
        return vaccineDate;
    }

    public void setVaccineDate(Date vaccineDate) {
        this.vaccineDate = vaccineDate;
    }
}
