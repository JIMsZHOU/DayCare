package model.space;

import api.SpaceAPI;

public class Space extends SpaceAPI implements Comparable<Space>{
    private int id;
    private String name;
    private int type;
    private final int capacity;
    private int remain;

    protected Space(int id, String name, int type, int capacity) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.capacity = capacity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getRemain() {
        return remain;
    }

    public void setRemain(int remain) {
        this.remain = remain;
    }

    @Override
    public int compareTo(Space o) {
        return this.getId() - o.getId();
    }

    @Override
    public void show() {
        System.out.println("id=" + id +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", capacity=" + capacity +
                ", remain=" + remain);
    }

    @Override
    public String toString() {
        return "Space{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", capacity=" + capacity +
                ", remain=" + remain +
                '}';
    }
}
