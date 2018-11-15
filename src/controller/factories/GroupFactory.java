package controller.factories;

import api.FactoryAPI;
import model.space.Group;

/**
 * The type Group factory.
 */
public class GroupFactory implements FactoryAPI {
    /**
     * Gets object.
     *
     * @param id   the id
     * @param name the name
     * @param type the type
     * @return the object
     */
    public Group getObject(int id, String name, int type) {
        return new Group(id, name, type);
    }
}
