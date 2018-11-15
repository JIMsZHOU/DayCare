import view.LoginScreen;

import javax.swing.*;

public class Driver {
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        LoginScreen loginScreen =  new LoginScreen();
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                loginScreen.getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                loginScreen.getFrame().setBounds(100, 100, 550, 550);
                loginScreen.getFrame().setVisible(true);
            }
        });
    }
}
