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

    List<Group> listallgroups() {
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

    void addGroup(Group group) {
        allGroups.add(group);
    }

    void deleteGroup(Group group) {
        allGroups.remove(group);
    }

    void deleteGroup(String groupname) {
        Group g = getGroup(groupname);
        deleteGroup(g);
    }

    void updateGroup(Group group) {
        Group g = getGroup(group.getName());
        if (g != null) {
            deleteGroup(g);
            addGroup(g);
        }
    }
}
