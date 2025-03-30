package main;

import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class JumpScare2 extends JFrame {

    JLabel label;
    Color[] flashColors = {Color.BLACK, Color.RED, Color.WHITE};
    int flashIndex = 0;

    public JumpScare2() {
        setUndecorated(true);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());

        // Jumpscare image
        label = new JLabel(new ImageIcon(getClass().getResource("/jumpscare/jump2.jpg")));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);
        add(label, BorderLayout.CENTER);

        setVisible(true);

        // Flash the screen every 100ms
        Timer flashTimer = new Timer();
        flashTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                getContentPane().setBackground(flashColors[flashIndex]);
                flashIndex = (flashIndex + 1) % flashColors.length;
            }
        }, 0, 100); // every 100 milliseconds

        // Shake the window for about 400ms (20 iterations with 20ms delay)
        Point originalLocation = getLocation();
        Timer shakeTimer = new Timer();
        shakeTimer.scheduleAtFixedRate(new TimerTask() {
            int shakeCount = 0;
            @Override
            public void run() {
                int offsetX = (int)(Math.random() * 10) - 5; // Shake horizontally by ±5 pixels
                int offsetY = (int)(Math.random() * 10) - 5; // Shake vertically by ±5 pixels
                setLocation(originalLocation.x + offsetX, originalLocation.y + offsetY);
                shakeCount++;
                if (shakeCount >= 20) {
                    shakeTimer.cancel();
                    setLocation(originalLocation);
                }
            }
        }, 0, 20);

        // Auto close and stop flashing after 2 seconds
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                flashTimer.cancel();
                dispose();
            }
        }, 2000);
    }

}
