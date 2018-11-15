package view;

import controller.factories.ParentFactory;
import controller.factories.StudentFactory;
import controller.manages.StudentManage;
import model.person.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * The type Add student.
 */
public class AddStudent {

    private ListStudent listStudent;

    /**
     * Gets frame.
     *
     * @return the frame
     */
    public JFrame getFrame() {
        return frame;
    }

    private JFrame frame;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextField textField_5;
    private JTextField textField_6;
    private JTextField textField_7;
    private JTextField textField_8;
    private JTextField textField_9;
    private JTextField textField_10;
    private JTextField textField_11;
    private JTextField textField_12;

    /**
     * Create the application.
     *
     * @param listStudent the list student
     */
    public AddStudent(ListStudent listStudent) {
        this.listStudent = listStudent;
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.getContentPane().setLayout(new BorderLayout(0, 0));

        JPanel panel = new JPanel();
        frame.getContentPane().add(panel, BorderLayout.WEST);
        panel.setLayout(new GridLayout(13, 1, 0, 0));

        JLabel Sid = new JLabel("StudentID:");
        panel.add(Sid);

        JLabel Sfn = new JLabel("Firstname:");
        panel.add(Sfn);

        JLabel Sln = new JLabel(" Lastname:");
        panel.add(Sln);

        JLabel Sage = new JLabel("    Age:");
        panel.add(Sage);

        JLabel Sgender = new JLabel("  Gender:");
        panel.add(Sgender);

        JLabel Pid = new JLabel("ParentID:");
        panel.add(Pid);

        JLabel Pfn = new JLabel("Firstname:");
        panel.add(Pfn);

        JLabel Pln = new JLabel(" Lastname:");
        panel.add(Pln);

        JLabel Page = new JLabel("    Age:");
        panel.add(Page);

        JLabel Pgender = new JLabel("  Gender:");
        panel.add(Pgender);

        JLabel Pcel = new JLabel("Cellphone:");
        panel.add(Pcel);

        JLabel Pem = new JLabel("   Email:");
        panel.add(Pem);

        JLabel Padr = new JLabel("Address:");
        panel.add(Padr);

        JPanel panel_1 = new JPanel();
        frame.getContentPane().add(panel_1, BorderLayout.SOUTH);
        panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JButton btnNewButton = new JButton("Apply");
        btnNewButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Student s = new StudentFactory().getObject(
                        Integer.parseInt(textField.getText()),
                        textField_1.getText(),
                        textField_2.getText(),
                        Integer.parseInt(textField_3.getText()),
                        textField_4.getText(),
                        new ParentFactory().getObject(
                                Integer.parseInt(textField_5.getText()),
                                textField_6.getText(),
                                textField_7.getText(),
                                Integer.parseInt(textField_8.getText()),
                                textField_9.getText(),
                                textField_10.getText(),
                                textField_11.getText(),
                                textField_12.getText()));
                s.setVaccineDate(AbstractFrameDate.today);
                StudentManage.getInstance().addStudent(s);
                listStudent.fresh();
            }
        });
        panel_1.add(btnNewButton);

        JPanel panel_2 = new JPanel();
        frame.getContentPane().add(panel_2, BorderLayout.CENTER);
        panel_2.setLayout(new GridLayout(13, 1, 0, 0));

        textField = new JTextField();
        panel_2.add(textField);
        textField.setColumns(10);

        textField_1 = new JTextField();
        panel_2.add(textField_1);
        textField_1.setColumns(10);

        textField_2 = new JTextField();
        panel_2.add(textField_2);
        textField_2.setColumns(10);

        textField_3 = new JTextField();
        panel_2.add(textField_3);
        textField_3.setColumns(10);

        textField_4 = new JTextField();
        panel_2.add(textField_4);
        textField_4.setColumns(10);

        textField_5 = new JTextField();
        panel_2.add(textField_5);
        textField_5.setColumns(10);

        textField_6 = new JTextField();
        panel_2.add(textField_6);
        textField_6.setColumns(10);

        textField_7 = new JTextField();
        panel_2.add(textField_7);
        textField_7.setColumns(10);

        textField_8 = new JTextField();
        panel_2.add(textField_8);
        textField_8.setColumns(10);

        textField_9 = new JTextField();
        panel_2.add(textField_9);
        textField_9.setColumns(10);

        textField_10 = new JTextField();
        panel_2.add(textField_10);
        textField_10.setColumns(10);

        textField_11 = new JTextField();
        panel_2.add(textField_11);
        textField_11.setColumns(10);

        textField_12 = new JTextField();
        panel_2.add(textField_12);
        textField_12.setColumns(10);
    }

}
