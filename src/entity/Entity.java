package entity;

//parent class for entities

import java.awt.image.BufferedImage;

public class Entity {

    public int x, y;
    public int speed;

    public BufferedImage idleFront, idleBack, idleLeft, idleRight, up1, up2, down1, down2, left1, left2, right1, right2;        //Buffered Image describes an image with an accessible buffer of image data
    public String direction;

    public int spriteCounter = 0;
    public int spriteNum = 1;
}
