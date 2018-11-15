package model.space;

import java.util.List;
import java.util.Vector;

/**
 * Type will present the interval of age should be added in Group, and same type group add in Room
 */
public class Room extends Space {

    private List<Group> groups;

    public Room(int id, String name, int type) {
        super(id, name, type, defineCap(type));
        this.groups = new Vector<>();
        this.keepsize();
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public void addGroup(Group group) {
        if (this.getRemain() == 0) return;
        this.groups.add(group);
        this.keepsize();
    }

    public void deleteGroup(Group group) {
        if (group == null) return;
        for (int i = 0; i < this.groups.size(); i++) {
            if (this.groups.get(i).equals(group)) this.groups.remove(i);
        }
        this.keepsize();
    }

    private void keepsize() {
        this.setRemain(this.getCapacity() - this.groups.size());
    }

    private static int defineCap(int type) {
        switch (type) {
            case 0: return 3; // 6 - 12 month
            case 1: return 3; // 13 -24 month
            case 2: return 3; // 25 - 35 month
            case 3: return 3; // 36 - 47 month
            case 4: return 2; // 48 - 59 month
            case 5: return 2; // 60 - more month
            default: return -1; //return -1 means it was error
        }
    }
}
