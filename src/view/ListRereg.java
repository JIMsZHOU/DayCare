package view;

import controller.manages.AnnualMange;
import model.person.Student;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Vector;

public class ListRereg {

    public JFrame getFrame() {
        return frame;
    }

    private JFrame frame;
    private LoginScreen loginScreen;

    /**
     * Create the application.
     */
    public ListRereg(LoginScreen loginScreen) {
        this.loginScreen = loginScreen;
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        List<Student> studentList = AnnualMange.getInstance().getReg();
        JList list = new JList((Vector) studentList);
        JScrollBar js = new JScrollBar();
        list.add(js);
        frame.getContentPane().add(list, BorderLayout.CENTER);
    }

}
