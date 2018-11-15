package view;

import controller.stat.RegisterManage;
import model.person.Student;
import model.space.Group;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

/**
 * The type Show group.
 */
public class ShowGroup {

    /**
     * Gets frame.
     *
     * @return the frame
     */
    public JFrame getFrame() {
        return frame;
    }

    private JFrame frame;
    private JTable table;

    private ListGroup listGroup;
    private Group group;


    /**
     * Create the application.
     *
     * @param listGroup the list group
     * @param group     the group
     */
    public ShowGroup(ListGroup listGroup, Group group) {
        this.group = group;
        this.listGroup = listGroup;
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        DefaultTableModel model = new DefaultTableModel();
        List<Student> studentList = group.getStudents();
        String[][] info = new String[studentList.size()][6];
        String[] column = {"StudentID", "Firstname", "Lastname", "Age", "Gender"};
        RegisterManage.setTable(studentList, info);
        model.setDataVector(info, column);
        model.setColumnIdentifiers(column);
        table = new JTable(model);
        frame.getContentPane().add(table, BorderLayout.NORTH);
    }


}
