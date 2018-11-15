package Driver;

import javax.swing.*;

/**
 * The type Swing console.
 */
public class SwingConsole {
    /**
     * Run.
     *
     * @param f      the f
     * @param x      the x
     * @param y      the y
     * @param width  the width
     * @param height the height
     */
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

    /**
     * Run.
     *
     * @param frame the frame
     */
    public static void run(final JFrame frame) {
        run(frame, 100, 100, 600, 600);
    }

    /**
     * Run.
     *
     * @param frame the frame
     * @param w     the w
     * @param h     the h
     */
    public static void run(final JFrame frame, final int w, final int h) {
        run(frame, 100, 100, w, h);
    }
}
