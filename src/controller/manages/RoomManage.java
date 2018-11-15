package controller.manages;

import api.ManageAPI;
import model.space.Room;

import java.util.List;
import java.util.Vector;

/**
 * The type Room manage.
 */
public class RoomManage implements ManageAPI {
    private static RoomManage ourInstance = new RoomManage();

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static synchronized RoomManage getInstance() {
        return ourInstance;
    }

    private int size;
    private List<Room> roomList;

    /**
     * Gets size.
     *
     * @return the size
     */
    public int getSize() {
        return size;
    }

    /**
     * Sets size.
     *
     * @param size the size
     */
    public void setSize(int size) {
        this.size = size;
    }

    private RoomManage() {
        roomList = new Vector<>();
        size = 0;
    }

    /**
     * Gets room list.
     *
     * @return the room list
     */
    public List<Room> getRoomList() {
        return roomList;
    }

    /**
     * Add room.
     *
     * @param room the room
     */
    public void addRoom(Room room) {
        if (getRoom(room.getId()) != null) return;
        this.roomList.add(room);
        size++;
    }

    /**
     * Gets room.
     *
     * @param id the id
     * @return the room
     */
    public Room getRoom(int id) {
        for (int i = 0; i < roomList.size(); i++) {
            if (roomList.get(i).getId() == id) {
                return roomList.get(i);
            }
        }
        return null;
    }

    /**
     * Delete room.
     *
     * @param room the room
     */
    public void deleteRoom(Room room) {
        if (getRoom(room.getId()) == null) return;
        roomList.remove(room);
        size--;
    }

    /**
     * Delete room.
     *
     * @param id the id
     */
    public void deleteRoom(int id) {
        if (getRoom(id) == null) return;
        roomList.remove(getRoom(id));
        size--;
    }
}
