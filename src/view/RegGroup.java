package view;

import controller.manages.RoomManage;
import model.space.Group;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * The type Reg group.
 */
public class RegGroup {
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
    private ListGroup listGroup;
    private Group group;

    /**
     * Instantiates a new Reg group.
     *
     * @param listGroup the list group
     * @param group     the group
     */
    public RegGroup(ListGroup listGroup, Group group) {
        this.group = group;
        this.listGroup = listGroup;
        initialize();
    }

    private void initialize() {
        frame = new JFrame();

        frame.getContentPane().setLayout(new GridLayout(1, 3, 0, 0));

        JLabel lblNewLabel = new JLabel("Enter the RoomID:");
        frame.getContentPane().add(lblNewLabel);

        textField = new JTextField();
        frame.getContentPane().add(textField);
        textField.setColumns(6);

        JButton btnNewButton = new JButton("Confirm");
        btnNewButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                RoomManage.getInstance().
                        getRoom(Integer.parseInt(textField.getText())).
                        addGroup(group);
                listGroup.fresh();
                frame.dispose();
            }
        });
        frame.getContentPane().add(btnNewButton);
    }
}
