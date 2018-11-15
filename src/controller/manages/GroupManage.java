package controller.manages;

import api.ManageAPI;
import model.space.Group;

import java.util.List;
import java.util.Vector;

/**
 * The type Group manage.
 */
public class GroupManage implements ManageAPI {
    private static GroupManage ourInstance = new GroupManage();

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static synchronized GroupManage getInstance() {
        return ourInstance;
    }

    private int size;
    private List<Group> groupList;

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

    private GroupManage() {
        groupList = new Vector<>();
        size = 0;
    }

    /**
     * Gets group list.
     *
     * @return the group list
     */
    public List<Group> getGroupList() {
        return groupList;
    }

    /**
     * Add group.
     *
     * @param group the group
     */
    public void addGroup(Group group) {
        if (getGroup(group.getId()) != null) return;
        this.groupList.add(group);
        size = groupList.size();
    }

    /**
     * Gets group.
     *
     * @param id the id
     * @return the group
     */
    public Group getGroup(int id) {
        for (int i = 0; i < groupList.size(); i++) {
            if (groupList.get(i).getId() == id) {
                return groupList.get(i);
            }
        }
        return null;
    }

    /**
     * Delete group.
     *
     * @param group the group
     */
    public void deleteGroup(Group group) {
        if (getGroup(group.getId()) == null) return;
        groupList.remove(group);
        size = groupList.size();
    }

    /**
     * Delete group.
     *
     * @param id the id
     */
    public void deleteGroup(int id) {
        if (getGroup(id) == null) return;
        groupList.remove(getGroup(id));
        size = groupList.size();
    }

}
