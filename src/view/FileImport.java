package view;

import controller.stat.FileManage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * The type File import.
 */
public class FileImport {

    /**
     * Gets frame.
     *
     * @return the frame
     */
    public JFrame getFrame() {
        return frame;
    }

    private LoginScreen loginScreen;
    private JFrame frame;
    private JLabel fileLabel;
    private JTextField textField;
    private JButton fileButton;

    /**
     * Create the application.
     *
     * @param loginScreen the login screen
     */
    public FileImport(LoginScreen loginScreen) {
        this.loginScreen = loginScreen;
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 560, 65);
        frame.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        fileLabel = new JLabel("File:");
        frame.getContentPane().add(fileLabel);

        textField = new JTextField();
        frame.getContentPane().add(textField);
        textField.setColumns(35);

        fileButton = new JButton("Select");
        frame.getContentPane().add(fileButton);
        fileButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String filepath = textField.getText();
                FileManage.ReadCSV(filepath);
                frame.dispose();
                loginScreen.fresh();
            }
        });
    }

}
