package controller.factories;

import api.FactoryAPI;
import model.person.Parent;

public class ParentFactory implements FactoryAPI {
    public Parent getObject(int id, String firstname, String lastname, int age, String gender, String cellphone, String email, String address) {
        return new Parent(id, firstname, lastname, age, gender, cellphone, email, address);
    }

    public Parent getObject(int id, String firstname, String lastname) {
        // When age is -1 means don't have this information.
        return new Parent(id, firstname, lastname, -1, "", "", "", "");
    }
}
