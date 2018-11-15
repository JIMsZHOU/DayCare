package controller.factories;

import api.FactoryAPI;
import model.space.Room;

public class RoomFactory implements FactoryAPI {
    public Room getObject(int id, String name, int type) {
        return new Room(id, name, type);
    }
}
