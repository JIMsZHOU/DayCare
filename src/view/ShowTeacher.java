package view;

import model.person.Teacher;

import javax.swing.*;
import java.awt.*;

public class ShowTeacher {

    private ListTeacher listTeacher;
    private Teacher teacher;

    public JFrame getFrame() {
        return frame;
    }

    private JFrame frame;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextField textField_10;
    private JTextField textField_11;
    private JTextField textField_12;

    /**
     * Create the application.
     */
    public ShowTeacher(ListTeacher listTeacher, Teacher teacher) {
        this.teacher = teacher;
        this.listTeacher = listTeacher;
        initialize();
    }

    private void setTeacherinfo() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                textField.setText(String.valueOf(teacher.getId()));
                textField_1.setText(teacher.getFirstname());
                textField_2.setText(teacher.getLastname());
                textField_3.setText(String.valueOf(teacher.getAge()));
                textField_4.setText(teacher.getGender());
                textField_10.setText(teacher.getCellphone());
                textField_11.setText(teacher.getEmail());
                textField_12.setText(teacher.getDescription());
            }
        });
        listTeacher.fresh();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.getContentPane().setLayout(new BorderLayout(0, 0));

        JPanel panel = new JPanel();
        frame.getContentPane().add(panel, BorderLayout.WEST);
        panel.setLayout(new GridLayout(8, 1, 0, 0));

        JLabel Sid = new JLabel("TeacherID:");
        panel.add(Sid);

        JLabel Sfn = new JLabel("Firstname:");
        panel.add(Sfn);

        JLabel Sln = new JLabel(" Lastname:");
        panel.add(Sln);

        JLabel Sage = new JLabel("    Age:");
        panel.add(Sage);

        JLabel Sgender = new JLabel("  Gender:");
        panel.add(Sgender);

        JLabel Pcel = new JLabel("Cellphone:");
        panel.add(Pcel);

        JLabel Pem = new JLabel("   Email:");
        panel.add(Pem);

        JLabel Padr = new JLabel("Description:");
        panel.add(Padr);

        JPanel panel_2 = new JPanel();
        frame.getContentPane().add(panel_2, BorderLayout.CENTER);
        panel_2.setLayout(new GridLayout(8, 1, 0, 0));

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

        textField_10 = new JTextField();
        panel_2.add(textField_10);
        textField_10.setColumns(10);

        textField_11 = new JTextField();
        panel_2.add(textField_11);
        textField_11.setColumns(10);

        textField_12 = new JTextField();
        panel_2.add(textField_12);
        textField_12.setColumns(10);

        setTeacherinfo();
    }

}

