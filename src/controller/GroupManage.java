package controller;

import model.Group;
import model.Student;
import model.Teacher;

import java.util.List;
import java.util.Vector;

public class GroupManage {
    private static GroupManage ourInstance = new GroupManage();

    public static synchronized GroupManage getInstance() {
        return ourInstance;
    }

    private List<Group> allGroups;
    private GroupManage() {
        allGroups = new Vector<>();
    }

    List<Group> listallgoroups() {
        return allGroups;
    }

    Group getGroup(String groupname) {
        for (Group anGroup:
             allGroups) {
            if (anGroup.getName().equals(groupname)) {
                return anGroup;
            }
        }
        return null;
    }

    void addGroup(Group groupname) {
        allGroups.add(groupname);
    }

    void deleteGroup(Group groupname) {
        allGroups.remove(groupname);
    }

    void deleteGroup(String groupname) {
        Group g = getGroup(groupname);
        deleteGroup(g);
    }

    void updateGroup(Group group) {

    }
}
