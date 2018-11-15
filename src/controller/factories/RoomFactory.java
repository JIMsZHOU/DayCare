package controller.factories;

import api.FactoryAPI;
import model.space.Room;

/**
 * The type Room factory.
 */
public class RoomFactory implements FactoryAPI {
    /**
     * Gets object.
     *
     * @param id   the id
     * @param name the name
     * @param type the type
     * @return the object
     */
    public Room getObject(int id, String name, int type) {
        return new Room(id, name, type);
    }
}
