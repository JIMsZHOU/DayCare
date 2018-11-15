package model.space;

import api.SpaceAPI;

/**
 * The type Space.
 */
public class Space extends SpaceAPI implements Comparable<Space> {
    private int id;
    private String name;
    private int type;
    private final int capacity;
    private int remain;

    /**
     * Instantiates a new Space.
     *
     * @param id       the id
     * @param name     the name
     * @param type     the type
     * @param capacity the capacity
     */
    protected Space(int id, String name, int type, int capacity) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.capacity = capacity;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    public int getType() {
        return type;
    }

    /**
     * Sets type.
     *
     * @param type the type
     */
    public void setType(int type) {
        this.type = type;
    }

    /**
     * Gets capacity.
     *
     * @return the capacity
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Gets remain.
     *
     * @return the remain
     */
    public int getRemain() {
        return remain;
    }

    /**
     * Sets remain.
     *
     * @param remain the remain
     */
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
