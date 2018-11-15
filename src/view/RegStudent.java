package view;

import controller.manages.GroupManage;
import model.person.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RegStudent {
    public JFrame getFrame() {
        return frame;
    }

    private JFrame frame;
    private JTextField textField;
    private ListStudent listStudent;
    private Student student;

    public RegStudent(ListStudent listStudent, Student student) {
        this.student = student;
        this.listStudent = listStudent;
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
                student.setRegisterDate(AbstractFrameDate.today);
                GroupManage.getInstance().
                        getGroup(Integer.parseInt(textField.getText())).
                        addStudent(student);
                listStudent.fresh();
                frame.dispose();
            }
        });
        frame.getContentPane().add(btnNewButton);
    }
}
