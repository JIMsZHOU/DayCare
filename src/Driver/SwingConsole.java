package Driver;

import javax.swing.*;

public class SwingConsole {
    public static void run(final JFrame f, final int x, final int y, final int width, final int height) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                f.setBounds(x, y, width, height);
                f.setVisible(true);
            }
        });
    }

    public static void run(final JFrame frame) {
        run(frame, 100, 100, 600, 600);
    }

    public static void run(final JFrame frame, final int w, final int h) {
        run(frame, 100, 100, w, h);
    }
}
