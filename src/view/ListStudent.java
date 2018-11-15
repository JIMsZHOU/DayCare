package view;

import Driver.SwingConsole;
import controller.manages.StudentManage;
import controller.stat.RegisterManage;
import model.person.Student;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListStudent {

    void fresh() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                getStudentinfo();
                loginScreen.fresh();
            }
        });
    }

    private void getStudentinfo() {

        studentList = StudentManage.getInstance().getStudentList();
        String[][] info = new String[studentList.size()][6];
        String[] column = {"StudentID", "Firstname", "Lastname", "Age", "Gender"};
        RegisterManage.setTable(studentList, info);
        model.setDataVector(info, column);
        model.fireTableDataChanged();
    }

    private List<Student> studentList;
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
    public ListStudent(LoginScreen loginScreen) {
        this.loginScreen = loginScreen;
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setTitle("ListStudent");
        frame.getContentPane().setLayout(new BorderLayout(0, 0));

        JPanel panel = new JPanel();
        frame.getContentPane().add(panel, BorderLayout.EAST);
        panel.setLayout(new GridLayout(5, 1, 0, 0));

        btadd = new JButton("Add");
        btadd.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                SwingConsole.run(new AddStudent(ListStudent.this).getFrame(), 100, 100, 550, 400);
            }
        });
        panel.add(btadd);

        btdelete = new JButton("Delete");
        btdelete.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String id = String.valueOf(table.getModel().getValueAt(table.getSelectedRow(), 0));
                StudentManage.getInstance().deleteStudent(Integer.parseInt(id));
                fresh();
            }
        });
        panel.add(btdelete);

        btshow = new JButton("Show");
        btshow.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ShowStudent ss = new ShowStudent(ListStudent.this);
                SwingConsole.run(ss.getFrame(), 100, 100, 550, 400);
                String id = String.valueOf(table.getModel().getValueAt(table.getSelectedRow(), 0));
                ss.setInfo(StudentManage.getInstance().getStudent(Integer.parseInt(id)));
            }
        });

        panel.add(btshow);

        btReg = new JButton("Register");
        btReg.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String id = String.valueOf(table.getModel().getValueAt(table.getSelectedRow(), 0));
                SwingConsole.run(new RegStudent(ListStudent.this,
                        StudentManage.getInstance().getStudent(Integer.parseInt(id))).getFrame(), 100, 100, 500, 100);
            }
        });
        panel.add(btReg);

        btVac = new JButton("Take Vaccine");
        btVac.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String id = String.valueOf(table.getModel().getValueAt(table.getSelectedRow(), 0));
                SwingConsole.run(new TakeVac(StudentManage.getInstance().getStudent(Integer.parseInt(id))).getFrame(), 100, 100, 550, 40);
                fresh();
            }
        });
        panel.add(btVac);

        panel_1 = new JPanel();
        frame.getContentPane().add(panel_1, BorderLayout.NORTH);

        titleText = new JLabel("StudentList");
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
                Collections.sort(StudentManage.getInstance().getStudentList(), new Comparator<Student>() {
                    @Override
                    public int compare(Student o1, Student o2) {
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
                Collections.sort(StudentManage.getInstance().getStudentList(), new Comparator<Student>() {
                    @Override
                    public int compare(Student o1, Student o2) {
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
                Collections.sort(StudentManage.getInstance().getStudentList(), new Comparator<Student>() {
                    @Override
                    public int compare(Student o1, Student o2) {
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
                Collections.sort(StudentManage.getInstance().getStudentList(), new Comparator<Student>() {
                    @Override
                    public int compare(Student o1, Student o2) {
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

