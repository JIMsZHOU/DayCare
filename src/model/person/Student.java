package model.person;

import java.util.Date;

/**
 * Student shouldn't have cellphone number, email and address. Since those information should contain in Parent information
 * Moreover, student have some special feature which is parent, register date, and vaccine date
 */
public class Student extends Person {
    private Parent parent;
    private Date registerDate;
    private Date vaccineDate;


    /**
     * Instantiates a new Student.
     *
     * @param id           the id
     * @param firstname    the firstname
     * @param lastname     the lastname
     * @param age          the age
     * @param gender       the gender
     * @param parent       the parent
     * @param registerDate the register date
     * @param vaccineDate  the vaccine date
     */
    public Student(int id, String firstname, String lastname, int age, String gender, Parent parent, Date registerDate, Date vaccineDate) {
        super(id, firstname, lastname, age, gender, null, null, null);
        this.parent = parent;
        this.registerDate = registerDate;
        this.vaccineDate = vaccineDate;
    }

    /**
     * Gets parent.
     *
     * @return the parent
     */
    public Parent getParent() {
        return parent;
    }

    /**
     * Sets parent.
     *
     * @param parent the parent
     */
    public void setParent(Parent parent) {
        this.parent = parent;
    }

    /**
     * Gets register date.
     *
     * @return the register date
     */
    public Date getRegisterDate() {
        return registerDate;
    }

    /**
     * Sets register date.
     *
     * @param registerDate the register date
     */
    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    /**
     * Gets vaccine date.
     *
     * @return the vaccine date
     */
    public Date getVaccineDate() {
        return vaccineDate;
    }

    /**
     * Sets vaccine date.
     *
     * @param vaccineDate the vaccine date
     */
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
                ", parent='" + this.getParent().getFirstname() + this.getParent().getLastname() + '\'');
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
