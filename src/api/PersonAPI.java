package api;

/**
 * Person should contain all feature that a person should have.
 *
 * The data should have: ID, firstname, lastname, age, gender, cellphone, email, address
 * We should have concrete character, which may have or not have some of the data
 *
 * The method should have: get set method, show method, compare method.
 * Should both use comparable and comparator to fit in different sort situation
 */
public abstract class PersonAPI {
    public abstract void show();
}
