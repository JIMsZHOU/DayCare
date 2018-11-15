package view;

import controller.factories.GroupFactory;
import controller.manages.GroupManage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * The type Add group.
 */
public class AddGroup {

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
    private JComboBox comboBox;
    private ListGroup listGroup;

    /**
     * Create the application.
     *
     * @param listGroup the list group
     */
    public AddGroup(ListGroup listGroup) {
        this.listGroup = listGroup;
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.getContentPane().setLayout(new BorderLayout(0, 0));

        JPanel panel = new JPanel();
        frame.getContentPane().add(panel, BorderLayout.SOUTH);
        panel.setLayout(new GridLayout(1, 0, 0, 0));

        JButton btnApply = new JButton("Apply");
        btnApply.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                GroupManage.getInstance().addGroup(
                        new GroupFactory().getObject(
                                Integer.parseInt(textField.getText()),
                                textField_1.getText(),
                                comboBox.getSelectedIndex()
                        )
                );
                listGroup.fresh();
            }
        });
        panel.add(btnApply);

        JPanel panel_1 = new JPanel();
        frame.getContentPane().add(panel_1, BorderLayout.WEST);
        panel_1.setLayout(new GridLayout(3, 0, 0, 0));

        JLabel lblNewLabel = new JLabel("GroupID:");
        panel_1.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Name:");
        panel_1.add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("Type:");
        panel_1.add(lblNewLabel_2);

        JPanel panel_2 = new JPanel();
        frame.getContentPane().add(panel_2, BorderLayout.CENTER);
        panel_2.setLayout(new GridLayout(0, 1, 0, 0));

        textField = new JTextField();
        panel_2.add(textField);
        textField.setColumns(10);

        textField_1 = new JTextField();
        panel_2.add(textField_1);
        textField_1.setColumns(10);

        String[] content = {"6-12", "13-24", "25-35", "36-47", "48-59", "60-~"};
        comboBox = new JComboBox(content);
        panel_2.add(comboBox);
    }

}
