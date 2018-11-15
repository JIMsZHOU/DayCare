package controller.manages;

import api.ManageAPI;
import model.space.Room;

import java.util.List;
import java.util.Vector;

public class RoomManage implements ManageAPI {
    private static RoomManage ourInstance = new RoomManage();

    public static synchronized RoomManage getInstance() {
        return ourInstance;
    }

    private int size;
    private List<Room> roomList;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    private RoomManage() {
        roomList = new Vector<>();
        size = 0;
    }

    public List<Room> getRoomList() {
        return roomList;
    }

    public void addRoom(Room room) {
        if (getRoom(room.getId()) != null) return;
        this.roomList.add(room);
        size ++;
    }

    public Room getRoom(int id) {
        for (int i = 0; i < roomList.size(); i++) {
            if (roomList.get(i).getId() == id) {
                return roomList.get(i);
            }
        }
        return null;
    }

    public void deleteRoom(Room room) {
        if (getRoom(room.getId()) == null) return;
        roomList.remove(room);
        size--;
    }

    public void deleteRoom(int id) {
        if (getRoom(id) == null) return;
        roomList.remove(getRoom(id));
        size--;
    }
}
