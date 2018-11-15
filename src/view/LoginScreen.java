package view;

import Driver.SwingConsole;
import controller.manages.*;
import controller.stat.RegisterManage;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;
import java.util.Date;

public class LoginScreen extends AbstractFrameDate{

    private JFrame frame;
    private JTextField yearText;
    private JTextField monthText;
    private JTextField dayText;

    private JButton btnumStudent;
    private JButton btnumTeacher;
    private JButton btnumGroup;
    private JButton btnumRoom;
    private JButton btreregnum;
    private JButton btvacnum;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        LoginScreen loginScreen =  new LoginScreen();
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                loginScreen.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                loginScreen.frame.setBounds(100, 100, 550, 550);
                loginScreen.frame.setVisible(true);
            }
        });
    }

    /**
     * Create the application.
     */
    public LoginScreen() {
        today = new Date();
        initialize();
    }

    void fresh() {
        RegisterManage.doCheck(today);
        yearText.setText(getYear(today));
        monthText.setText(getMonth(today));
        dayText.setText(getDay(today));
        btnumStudent.setText(String.valueOf(StudentManage.getInstance().getStudentList().size()));
        btnumGroup.setText(String.valueOf(GroupManage.getInstance().getGroupList().size()));
        btnumRoom.setText(String.valueOf(RoomManage.getInstance().getRoomList().size()));
        btnumTeacher.setText(String.valueOf(TeacherManage.getInstance().getTeacherList().size()));
        btreregnum.setText(String.valueOf(AnnualMange.getInstance().getReg().size()));
        btvacnum.setText(String.valueOf(AnnualMange.getInstance().getVac().size()));
    }

    private String getYear(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return String.valueOf(calendar.get(Calendar.YEAR));
    }

    private String getMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return String.valueOf(calendar.get(Calendar.MONTH) + 1);
    }

    private String getDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));
    }

    private Date changeDate(int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month-1, day);
        return calendar.getTime();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setTitle("Welcome");

        JPanel panel = new JPanel();
        frame.getContentPane().add(panel, BorderLayout.NORTH);

        JLabel title = new JLabel("DayCare Management System");
        title.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
        panel.add(title);

        JPanel panel_1 = new JPanel();
        frame.getContentPane().add(panel_1, BorderLayout.SOUTH);
        panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JLabel todayText = new JLabel("Today is: ");
        panel_1.add(todayText);

        JLabel Y = new JLabel("Year");
        panel_1.add(Y);

        yearText = new JTextField();
        panel_1.add(yearText);
        yearText.setColumns(5);

        JLabel M = new JLabel("Month");
        panel_1.add(M);

        monthText = new JTextField();
        panel_1.add(monthText);
        monthText.setColumns(5);

        JLabel D = new JLabel("Day");
        panel_1.add(D);

        dayText = new JTextField();
        panel_1.add(dayText);
        dayText.setColumns(5);

        JButton changeDate = new JButton("Apply");
        panel_1.add(changeDate);
        changeDate.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                today = changeDate(Integer.parseInt(yearText.getText()), Integer.parseInt(monthText.getText()), Integer.parseInt(dayText.getText()));
                System.out.println(today);
                fresh();
            }
        });

        JPanel panel_2 = new JPanel();
        frame.getContentPane().add(panel_2, BorderLayout.EAST);

        JLabel numStudent = new JLabel("Total\tstudent\tnumber: ");

        btnumStudent = new JButton();
        btnumStudent.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                SwingConsole.run(new ListStudent(LoginScreen.this).getFrame(), 100, 100, 550, 550);
            }
        });

        JLabel numTeacher = new JLabel("Total\tteacher\tnumber: ");

        btnumTeacher = new JButton();
        btnumTeacher.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                SwingConsole.run(new ListTeacher(LoginScreen.this).getFrame(), 100, 100, 550, 550);
            }
        });

        JLabel numGroup = new JLabel("Registered\tgroup\tnumber: ");

        btnumGroup = new JButton();
        btnumGroup.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                SwingConsole.run(new ListGroup(LoginScreen.this).getFrame(), 100, 100, 550, 550);
            }
        });

        JLabel numRoom = new JLabel("Registered\troom\tnumber: ");

        btnumRoom = new JButton();
        btnumRoom.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                SwingConsole.run(new ListRoom(LoginScreen.this).getFrame(), 100, 100, 550, 550);
            }
        });


        JLabel reregstdnum = new JLabel("Student\tneed\tre-register: ");

        btreregnum = new JButton();
        btreregnum.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                SwingConsole.run(new ListRereg(LoginScreen.this).getFrame(), 100, 100, 550, 550);
            }
        });

        JLabel vacstdnum = new JLabel("Student\tneed\tvaccine: ");

        btvacnum = new JButton();
        btvacnum.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                SwingConsole.run(new ListVac(LoginScreen.this).getFrame(), 100, 100, 550, 550);
            }
        });


        GroupLayout gl_panel_2 = new GroupLayout(panel_2);
        gl_panel_2.setHorizontalGroup(
                gl_panel_2.createParallelGroup(Alignment.LEADING)
                        .addGroup(Alignment.TRAILING, gl_panel_2.createSequentialGroup()
                                .addContainerGap(200, Short.MAX_VALUE)
                                .addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING)
                                        .addComponent(numTeacher)
                                        .addComponent(numStudent)
                                        .addComponent(numGroup)
                                        .addComponent(numRoom)
                                        .addComponent(reregstdnum)
                                        .addComponent(vacstdnum))
                                .addGap(130)
                                .addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
                                        .addComponent(btvacnum)
                                        .addComponent(btreregnum)
                                        .addComponent(btnumGroup)
                                        .addComponent(btnumRoom)
                                        .addComponent(btnumStudent)
                                        .addComponent(btnumTeacher))
                                .addGap(110))
        );
        gl_panel_2.setVerticalGroup(
                gl_panel_2.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_panel_2.createSequentialGroup()
                                .addGap(60)
                                .addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(btnumStudent)
                                        .addComponent(numStudent))
                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                .addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(btnumTeacher)
                                        .addComponent(numTeacher))
                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                .addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(btnumGroup)
                                        .addComponent(numGroup))
                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                .addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(btnumRoom)
                                        .addComponent(numRoom))
                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                .addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(btreregnum)
                                        .addComponent(reregstdnum))
                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                .addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(btvacnum)
                                        .addComponent(vacstdnum))
                                .addContainerGap(130, Short.MAX_VALUE))
        );
        panel_2.setLayout(gl_panel_2);

        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);

        JMenu menu1 = new JMenu("File");
        menuBar.add(menu1);
        JMenu menu2 = new JMenu("Action");
        menuBar.add(menu2);

        JMenuItem mnImportCsv = new JMenuItem("Import from .csv file");
        mnImportCsv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingConsole.run(new FileImport(LoginScreen.this).getFrame(), 100, 100, 650, 65);
            }
        });
        menu1.add(mnImportCsv);

        JMenuItem mnReload = new JMenuItem("Reload System");
        mnReload.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                today = new Date();
                fresh();
            }
        });

        menu2.add(mnReload);

        fresh();
    }

}
