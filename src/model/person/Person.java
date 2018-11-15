package model.person;

import api.PersonAPI;

/**
 * This class Person is derived from PersonAPI
 * Person class have all features that normal person should have.
 * We give the getter and setter method to update the data of Person.
 * Implement comparable to achieve sort
 * Also, provide show method to output the information of Person object.
 *
 * Besides, we provided a protected access constructor for subclass.
 */
public class Person extends PersonAPI implements Comparable<Person>{
    private int id;
    private String firstname;
    private String lastname;
    private int age;
    private String gender;
    private String cellphone;
    private String email;
    private String address;

    protected Person(int id, String firstname, String lastname, int age, String gender, String cellphone, String email, String address) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.gender = gender;
        this.cellphone = cellphone;
        this.email = email;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    /* Originally the Person will be sort by ID*/
    @Override
    public int compareTo(Person o) {
        return this.getId() - o.getId();
    }

    @Override
    public void show() {
        System.out.println("id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", cellphone='" + cellphone + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'');
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", cellphone='" + cellphone + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
