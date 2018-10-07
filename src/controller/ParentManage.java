package controller;

public class ParentManage extends AbstractPersonManage{
    private static ParentManage ourInstance = new ParentManage();

    public static synchronized ParentManage getInstance() {
        return ourInstance;
    }

    private ParentManage() {
    }
}
