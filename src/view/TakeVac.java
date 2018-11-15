package view;

import model.person.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;
import java.util.Date;

public class TakeVac {

    private Student student;

    public JFrame getFrame() {
        return frame;
    }

    private JFrame frame;
    private JTextField texYr;
    private JTextField texMt;
    private JTextField texDy;

    private Date changeDate(int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month-1, day);
        return calendar.getTime();
    }

    /**
     * Create the application.
     */
    public TakeVac(Student student) {
        this.student = student;
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
//        frame.setBounds(100, 100, 711, 68);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(new GridLayout(0, 8, 0, 0));

        JLabel lb = new JLabel("Input Date: ");
        panel.add(lb);

        JLabel yr = new JLabel("Year");
        panel.add(yr);

        texYr = new JTextField();
        panel.add(texYr);
        texYr.setColumns(6);

        JLabel mt = new JLabel("Month");
        panel.add(mt);

        texMt = new JTextField();
        panel.add(texMt);
        texMt.setColumns(6);

        JLabel dy = new JLabel("Day");
        panel.add(dy);

        texDy = new JTextField();
        panel.add(texDy);
        texDy.setColumns(6);

        JButton btnNewButton = new JButton("Done");
        btnNewButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                student.setVaccineDate(changeDate(Integer.parseInt(texYr.getText()), Integer.parseInt(texMt.getText()), Integer.parseInt(texDy.getText())));
                frame.dispose();
            }
        });
        panel.add(btnNewButton);
    }

}
