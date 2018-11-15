package model.person;

import api.PersonAPI;

/**
 * This class Person is derived from PersonAPI
 * Person class have all features that normal person should have.
 * We give the getter and setter method to update the data of Person.
 * Implement comparable to achieve sort
 * Also, provide show method to output the information of Person object.
 * <p>
 * Besides, we provided a protected access constructor for subclass.
 */
public class Person extends PersonAPI implements Comparable<Person> {
    private int id;
    private String firstname;
    private String lastname;
    private int age;
    private String gender;
    private String cellphone;
    private String email;
    private String address;

    /**
     * Instantiates a new Person.
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

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets firstname.
     *
     * @return the firstname
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * Sets firstname.
     *
     * @param firstname the firstname
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * Gets lastname.
     *
     * @return the lastname
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * Sets lastname.
     *
     * @param lastname the lastname
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * Gets age.
     *
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * Sets age.
     *
     * @param age the age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Gets gender.
     *
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * Sets gender.
     *
     * @param gender the gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * Gets cellphone.
     *
     * @return the cellphone
     */
    public String getCellphone() {
        return cellphone;
    }

    /**
     * Sets cellphone.
     *
     * @param cellphone the cellphone
     */
    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    /**
     * Gets email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets email.
     *
     * @param email the email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets address.
     *
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets address.
     *
     * @param address the address
     */
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
