package model.person;

import java.util.Date;

/**
 * Student shouldn't have cellphone number, email and address. Since those information should contain in Parent information
 * Moreover, student have some special feature which is parent, register date, and vaccine date*/
public class Student extends Person {
    private Parent parent;
    private Date registerDate;
    private Date vaccineDate;


    public Student(int id, String firstname, String lastname, int age, String gender, Parent parent, Date registerDate, Date vaccineDate) {
        super(id, firstname, lastname, age, gender, null, null, null);
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

    @Override
    public void show() {
        System.out.println("id=" + this.getId() +
                ", firstname='" + this.getFirstname() + '\'' +
                ", lastname='" + this.getLastname() + '\'' +
                ", age=" + this.getAge() +
                ", gender='" + this.getGender() + '\'' +
                ", parent='" + this.getParent().getFirstname() + this.getParent().getLastname() +'\'');
    }

    @Override
    public String toString() {
        return "id=" + this.getId() +
                ", firstname='" + this.getFirstname() + '\'' +
                ", lastname='" + this.getLastname() + '\'' +
                ", age=" + this.getAge() +
                ", gender='" + this.getGender() + '\'' +
                ", parent='" + this.getParent().getFirstname() + this.getParent().getLastname() + "\'";
    }

    /* Originally the Student will be sorted by age*/
    @Override
    public int compareTo(Person o) {
        return this.getAge() - o.getAge();
    }
}
