package model.person;

/**
 * Teacher should not contain address, since it is better to let students and parents don't know where teacher lives.
 * And teacher have description to describe what teacher better for.
 */
public class Teacher extends Person {
    /**
     * Gets description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets description.
     *
     * @param description the description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    private String description;

    /**
     * Instantiates a new Teacher.
     *
     * @param id          the id
     * @param firstname   the firstname
     * @param lastname    the lastname
     * @param age         the age
     * @param gender      the gender
     * @param cellphone   the cellphone
     * @param email       the email
     * @param description the description
     */
    public Teacher(int id, String firstname, String lastname, int age, String gender, String cellphone, String email, String description) {
        super(id, firstname, lastname, age, gender, cellphone, email, null);
        this.description = description;
    }


}
