package view;

import controller.manages.GroupManage;
import model.person.Teacher;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RegTeacher {
    public JFrame getFrame() {
        return frame;
    }

    private JFrame frame;
    private JTextField textField;
    private ListTeacher listTeacher;
    private Teacher teacher;

    public RegTeacher(ListTeacher listTeacher, Teacher teacher) {
        this.teacher = teacher;
        this.listTeacher = listTeacher;
        initialize();
    }

    private void initialize() {
        frame = new JFrame();

        frame.getContentPane().setLayout(new GridLayout(1, 3, 0, 0));

        JLabel lblNewLabel = new JLabel("Enter the GroupID:");
        frame.getContentPane().add(lblNewLabel);

        textField = new JTextField();
        frame.getContentPane().add(textField);
        textField.setColumns(6);

        JButton btnNewButton = new JButton("Confirm");
        btnNewButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                GroupManage.getInstance().
                        getGroup(Integer.parseInt(textField.getText())).
                        setTeacher(teacher);
                listTeacher.fresh();
                frame.dispose();
            }

        });
        frame.getContentPane().add(btnNewButton);
    }
}

