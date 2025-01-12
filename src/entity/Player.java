package entity;


import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOError;
import java.io.IOException;

public class Player extends Entity{


    GamePanel gp;
    KeyHandler keyH;

    BufferedImage idleImage;

    public Player (GamePanel gp, KeyHandler keyH){

        this.gp = gp;
        this.keyH = keyH;

        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues(){
        x= 100;
        y=100;
        speed = 4;
        direction = "down";
    }
    public void getPlayerImage() {
        try {
            idleFront = ImageIO.read(getClass().getClassLoader().getResource("player/nikkefrontidle.png"));
            up1 = ImageIO.read(getClass().getClassLoader().getResource("player/nikkebackwalk1.png"));
            up2 = ImageIO.read(getClass().getClassLoader().getResource("player/nikkebackwalk2.png"));
            idleBack = ImageIO.read(getClass().getClassLoader().getResource("player/nikkebackidle.png"));
            idleLeft = ImageIO.read(getClass().getClassLoader().getResource("player/nikkesidewalkleftidle.png"));
            idleRight = ImageIO.read(getClass().getClassLoader().getResource("player/nikkeidlesideidle.png"));
            down1 = ImageIO.read(getClass().getClassLoader().getResource("player/nikkefrontwalk1.png"));
            down2 = ImageIO.read(getClass().getClassLoader().getResource("player/nikkefrontwalk2.png"));
            left1 = ImageIO.read(getClass().getClassLoader().getResource("player/nikkesidewalkleft1.png"));
            left2 = ImageIO.read(getClass().getClassLoader().getResource("player/nikkesidewalkleft2.png"));
            right1 = ImageIO.read(getClass().getClassLoader().getResource("player/nikkeidlesidewalk1.png"));
            right2 = ImageIO.read(getClass().getClassLoader().getResource("player/nikkeidlesidewalk2.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void update() {

        if (keyH.downPressed == true || keyH.upPressed == true || keyH.leftPressed == true || keyH.rightPressed == true) {
            if (keyH.upPressed == true) {
                direction = "up";
                y -= speed;
            } else if (keyH.downPressed == true) {
                direction = "down";
                y += speed;
            } else if (keyH.leftPressed == true) {
                direction = "left";
                x -= speed;
            } else if (keyH.rightPressed == true) {
                direction = "right";
                x += speed;

            }

            spriteCounter++;
            if (spriteCounter > 12) {
                if (spriteNum == 1) {
                    spriteNum = 2;
                } else if (spriteNum == 2) {
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }

        } else {
            // If no keys are pressed, keep the direction but use idle frames
            switch (direction) {
                case "up":
                    idleImage = idleBack;
                    break;
                case "down":
                    idleImage = idleFront;
                    break;
                case "left":
                    idleImage = idleLeft;
                    break;
                case "right":
                    idleImage = idleRight;
                    break;


            }
        }
    }



    public void draw(Graphics2D g2){
        /*g2.setColor(Color.white);

        g2.fillRect(x, y, gp.tileSize, gp.tileSize);*/

        BufferedImage image = null;

        if (keyH.downPressed || keyH.upPressed || keyH.leftPressed || keyH.rightPressed) {
        switch(direction){
            case "up":
                if (spriteNum==1) {
                    image = up1;
                }
                if (spriteNum == 2){
                    image = up2;
                }
                break;

            case "down":
                if (spriteNum==1) {
                    image = down1;
                }
                if (spriteNum == 2){
                    image = down2;
                }
                break;

            case "left":
                if (spriteNum==1) {
                    image = left1;
                }
                if (spriteNum == 2){
                    image = left2;
                }
                break;

            case "right":
                if (spriteNum==1) {
                    image = right1;
                }
                if (spriteNum == 2){
                    image = right2;
                }
                break;

        }
        }
        else {
            image = idleImage;

        }
        g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
    }
}

