package controller.manages;

import api.ManageAPI;
import model.space.Group;

import java.util.List;
import java.util.Vector;

public class GroupManage implements ManageAPI {
    private static GroupManage ourInstance = new GroupManage();

    public static synchronized GroupManage getInstance() {
        return ourInstance;
    }

    private int size;
    private List<Group> groupList;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    private GroupManage() {
        groupList = new Vector<>();
        size = 0;
    }

    public List<Group> getGroupList() {
        return groupList;
    }

    public void addGroup(Group group) {
        if (getGroup(group.getId()) != null) return;
        this.groupList.add(group);
        size = groupList.size();
    }

    public Group getGroup(int id) {
        for (int i = 0; i < groupList.size(); i++) {
            if (groupList.get(i).getId() == id) {
                return groupList.get(i);
            }
        }
        return null;
    }

    public void deleteGroup(Group group) {
        if (getGroup(group.getId()) == null) return;
        groupList.remove(group);
        size = groupList.size();
    }

    public void deleteGroup(int id) {
        if (getGroup(id) == null) return;
        groupList.remove(getGroup(id));
        size = groupList.size();
    }

}
