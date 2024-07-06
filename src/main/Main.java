package main;

import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        // Create the window.
        JFrame window = new JFrame("Simple Chess in Java");
        // Shut down the window.
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Set resizable false, so we can not resize the window.
        window.setResizable(false);

        // Add GamePanel to the window.
        GamePanel gp = new GamePanel();
        window.add(gp); // Add it the window.
        window.pack();

        // Make the window to show up at the center of the monitor.
        window.setLocationRelativeTo(null);
        // Set the window to be visible. So we can see it.
        window.setVisible(true);

        // Call the launchGame.
        gp.launchGame();
    }
}
