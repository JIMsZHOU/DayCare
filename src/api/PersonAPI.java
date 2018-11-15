package api;

/**
 * Person should contain all feature that a person should have.
 * <p>
 * The data should have: ID, firstname, lastname, age, gender, cellphone, email, address
 * We should have concrete character, which may have or not have some of the data
 * <p>
 * The method should have: get set method, show method, compare method.
 * Should both use comparable and comparator to fit in different sort situation
 */
public abstract class PersonAPI {
    /**
     * Show.
     */
    public abstract void show();
}
