package entity;

import main.GamePanel;

public class NPC_Acacius extends Entity{

    public NPC_Acacius(GamePanel gp) {
        super(gp);

        direction = "south";
        speed = 1;

        getImage();
        setDialouge();
    }

    public void getImage() {
        north0 = setup("/npc/npc1_north");
        south0 = setup("/npc/npc1_south");
        west0 = setup("/npc/npc1_west");
        east0 = setup("/npc/npc1_east");

        idleImage = west0;
    }

    public void setDialouge(){

        dialouges[0] = "Oh...a new one";
        dialouges[1] = "I miss my farm";
        dialouges[2] = "I wonder how she's doing";
        dialouges[3] = "I'm...innocent";
        dialouges[4] = "...";
    }

    @Override
    public void setAction(){
        isMoving = false;
    }

    public void speak(){

        //DO CHARACTER SPECIFIC STUFF

        super.speak();
    }

}
