package view;


import Driver.SwingConsole;
import controller.manages.RoomManage;
import model.space.Room;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListRoom {

    void fresh() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                getRoominfo();
                loginScreen.fresh();
            }
        });
    }

    private static String getType(int type) {
        switch (type) {
            case 0:
                return "6-12";
            case 1:
                return "13-24";
            case 2:
                return "25-35";
            case 3:
                return "36-47";
            case 4:
                return "48-59";
            case 5:
                return "60-~";
            default:
                return "0";
        }
    }

    private void getRoominfo() {

        roomList = RoomManage.getInstance().getRoomList();
        String[][] info = new String[roomList.size()][6];
        String[] column = {"RoomID", "Name", "type", "Remain"};
        model.setColumnIdentifiers(column);
        for (int i = 0; i < roomList.size(); i++) {
            Room s = roomList.get(i);
            info[i][0] = Integer.toString(s.getId());
            info[i][1] = s.getName();
            info[i][2] = getType(s.getType());
            info[i][3] = String.valueOf(s.getRemain());
        }
        model.setDataVector(info, column);
        model.fireTableDataChanged();
    }

    private List<Room> roomList;
    private LoginScreen loginScreen;

    public JFrame getFrame() {
        return frame;
    }

    private JFrame frame;
    private JButton btadd;
    private JButton btdelete;
    private JButton btshow;
    private JButton btReg;
    private JButton btVac;
    private JPanel panel_1;
    private JLabel titleText;
    private JPanel panel_2;
    private JTable table;
    private DefaultTableModel model;
    private JPanel panel_3;
    private JButton sortID;
    private JButton sortFn;
    private JButton sortLn;
    private JButton sortAge;
    private JLabel lblSort;

    /**
     * Create the application.
     */
    public ListRoom(LoginScreen loginScreen) {
        this.loginScreen = loginScreen;
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setTitle("ListRoom");
        frame.getContentPane().setLayout(new BorderLayout(0, 0));

        JPanel panel = new JPanel();
        frame.getContentPane().add(panel, BorderLayout.EAST);
        panel.setLayout(new GridLayout(5, 1, 0, 0));

        btadd = new JButton("Add");
        btadd.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                SwingConsole.run(new AddRoom(ListRoom.this).getFrame(), 100, 100, 550, 300);
            }
        });
        panel.add(btadd);

        btdelete = new JButton("Delete");
        btdelete.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String id = String.valueOf(table.getModel().getValueAt(table.getSelectedRow(), 0));
                RoomManage.getInstance().deleteRoom(Integer.parseInt(id));
                fresh();
            }
        });
        panel.add(btdelete);


        panel_1 = new JPanel();
        frame.getContentPane().add(panel_1, BorderLayout.NORTH);

        titleText = new JLabel("RoomList");
        titleText.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
        panel_1.add(titleText);

        panel_2 = new JPanel();
        frame.getContentPane().add(panel_2, BorderLayout.CENTER);

        model = new DefaultTableModel();
        table = new JTable(model);
        panel_2.add(table);

        panel_3 = new JPanel();
        frame.getContentPane().add(panel_3, BorderLayout.SOUTH);
        panel_3.setLayout(new GridLayout(1, 3, 0, 0));

        sortID = new JButton("ID");
        sortID.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Collections.sort(RoomManage.getInstance().getRoomList(),
                        new Comparator<Room>() {
                            @Override
                            public int compare(Room o1, Room o2) {
                                return o1.getId() - o2.getId();
                            }
                        });
                fresh();
            }
        });
        panel_3.add(sortID);

        sortFn = new JButton("Name");
        sortFn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Collections.sort(RoomManage.getInstance().getRoomList(),
                        new Comparator<Room>() {
                            @Override
                            public int compare(Room o1, Room o2) {
                                return o1.getName().compareTo(o2.getName());
                            }
                        });
                fresh();
            }
        });
        panel_3.add(sortFn);

        sortLn = new JButton("Type");
        sortLn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Collections.sort(RoomManage.getInstance().getRoomList(),
                        new Comparator<Room>() {
                            @Override
                            public int compare(Room o1, Room o2) {
                                return o1.getType() - o2.getType();
                            }
                        });
                fresh();
            }
        });
        panel_3.add(sortLn);

        sortAge = new JButton("Remain");
        sortAge.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Collections.sort(RoomManage.getInstance().getRoomList(),
                        new Comparator<Room>() {
                            @Override
                            public int compare(Room o1, Room o2) {
                                return o1.getRemain() - o2.getRemain();
                            }
                        });
                fresh();
            }
        });
        panel_3.add(sortAge);

        lblSort = new JLabel("SORT");
        lblSort.setHorizontalAlignment(SwingConstants.CENTER);
        panel_3.add(lblSort);

        fresh();
    }

}

