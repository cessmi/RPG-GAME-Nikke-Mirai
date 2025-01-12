import main.GamePanel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        //create Frame
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //user can xit the window
        window.setResizable(false); //so the window cannot be resized
        window.setTitle("Nikke Mirai");

        //change logo
       try{
           BufferedImage logo = ImageIO.read(Main.class.getResourceAsStream("/player/nikkefrontidle.png"));
           window.setIconImage(logo);
       } catch (IOException e) {
           e.printStackTrace();
        }

        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);

        window.pack();

        window.setLocationRelativeTo(null); //not specifying the location; window will be in the center
        window.setVisible(true);

        gamePanel.startGameThread();
    }

}

