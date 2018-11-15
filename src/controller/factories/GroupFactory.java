package controller.factories;

import api.FactoryAPI;
import model.space.Group;

public class GroupFactory implements FactoryAPI {
    public Group getObject(int id, String name, int type) {
        return new Group(id, name, type);
    }
}
