package view;

import Driver.SwingConsole;
import controller.manages.TeacherManage;
import model.person.Teacher;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * The type List teacher.
 */
public class ListTeacher {

    /**
     * Fresh.
     */
    void fresh() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                getTeacherinfo();
                loginScreen.fresh();
            }
        });
    }

    private void getTeacherinfo() {

        teacherList = TeacherManage.getInstance().getTeacherList();
        String[][] info = new String[teacherList.size()][6];
        String[] column = {"TeacherID", "Firstname", "Lastname", "Age", "Gender"};
        model.setColumnIdentifiers(column);
        for (int i = 0; i < teacherList.size(); i++) {
            Teacher s = teacherList.get(i);
            info[i][0] = Integer.toString(s.getId());
            info[i][1] = s.getFirstname();
            info[i][2] = s.getLastname();
            info[i][3] = Integer.toString(s.getAge());
            info[i][4] = s.getGender();
        }
        model.setDataVector(info, column);
        model.fireTableDataChanged();
    }

    private List<Teacher> teacherList;
    private LoginScreen loginScreen;

    /**
     * Gets frame.
     *
     * @return the frame
     */
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
     *
     * @param loginScreen the login screen
     */
    public ListTeacher(LoginScreen loginScreen) {
        this.loginScreen = loginScreen;
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setTitle("ListTeacher");
        frame.getContentPane().setLayout(new BorderLayout(0, 0));

        JPanel panel = new JPanel();
        frame.getContentPane().add(panel, BorderLayout.EAST);
        panel.setLayout(new GridLayout(4, 1, 0, 0));

        btadd = new JButton("Add");
        btadd.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                SwingConsole.run(new AddTeacher(ListTeacher.this).getFrame(), 100, 100, 550, 400);
            }
        });
        panel.add(btadd);

        btdelete = new JButton("Delete");
        btdelete.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String id = String.valueOf(table.getModel().getValueAt(table.getSelectedRow(), 0));
                TeacherManage.getInstance().deleteTeacher(Integer.parseInt(id));
                fresh();
            }
        });
        panel.add(btdelete);

        btshow = new JButton("Show");
        btshow.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String id = String.valueOf(table.getModel().getValueAt(table.getSelectedRow(), 0));
                SwingConsole.run(new ShowTeacher(ListTeacher.this, TeacherManage.getInstance().getTeacher(Integer.parseInt(id))).getFrame(), 100, 100, 550, 500);
                fresh();
            }
        });

        panel.add(btshow);

        btReg = new JButton("Register");
        btReg.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String id = String.valueOf(table.getModel().getValueAt(table.getSelectedRow(), 0));
                SwingConsole.run(new RegTeacher(ListTeacher.this, TeacherManage.getInstance().getTeacher(Integer.parseInt(id))).getFrame(), 100, 100, 550, 500);
            }
        });

        panel.add(btReg);

        panel_1 = new JPanel();
        frame.getContentPane().add(panel_1, BorderLayout.NORTH);

        titleText = new JLabel("TeacherList");
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
                Collections.sort(TeacherManage.getInstance().getTeacherList(), new Comparator<Teacher>() {
                    @Override
                    public int compare(Teacher o1, Teacher o2) {
                        return o1.getId() - o2.getId();
                    }
                });
                fresh();
            }
        });
        panel_3.add(sortID);

        sortFn = new JButton("Firstname");
        sortFn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Collections.sort(TeacherManage.getInstance().getTeacherList(), new Comparator<Teacher>() {
                    @Override
                    public int compare(Teacher o1, Teacher o2) {
                        return o1.getFirstname().compareTo(o2.getFirstname());
                    }
                });
                fresh();
            }
        });
        panel_3.add(sortFn);

        sortLn = new JButton("Lastname");
        sortLn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Collections.sort(TeacherManage.getInstance().getTeacherList(), new Comparator<Teacher>() {
                    @Override
                    public int compare(Teacher o1, Teacher o2) {
                        return o1.getLastname().compareTo(o2.getLastname());
                    }
                });
                fresh();
            }
        });
        panel_3.add(sortLn);

        sortAge = new JButton("Age");
        sortAge.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Collections.sort(TeacherManage.getInstance().getTeacherList(), new Comparator<Teacher>() {
                    @Override
                    public int compare(Teacher o1, Teacher o2) {
                        return o1.getAge() - o2.getAge();
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

