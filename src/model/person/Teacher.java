package model.person;

/**
 * Teacher should not contain address, since it is better to let students and parents don't know where teacher lives.
 * And teacher have description to describe what teacher better for.
 */
public class Teacher extends Person {
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private String description;
    public Teacher(int id, String firstname, String lastname, int age, String gender, String cellphone, String email, String description) {
        super(id, firstname, lastname, age, gender, cellphone, email, null);
        this.description = description;
    }


}
