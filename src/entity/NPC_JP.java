package entity;

import main.GamePanel;

public class NPC_JP extends Entity{

    public NPC_JP(GamePanel gp) {
        super(gp);

        direction = "south";
        speed = 1;

        getImage();
        setDialouge();
    }

    public void getImage() {
        south0 = setup("/npc/npc_static/jp");

        idleImage = south0;
    }

    public void setDialouge(){

        dialouges[0] = "Essentially... everything is an object.";
        dialouges[1] = "You found me? Must be a bug...\nor destiny.";
        dialouges[2] = "This world runs on inheritance and\ninterfaces.\n*Polymorphism?* Absolutely.";
        dialouges[3] = "Draw your UML diagram.\nEven if the gods don't ask for it.";
        dialouges[4] = "Anything is possible...\nif your syntax is correct.";
        dialouges[5] = "But don’t get too attached to the structure.";
        dialouges[6] = "This... won't be used in real life anyway.";
        dialouges[7] = "Unless your life *is* code.";
        dialouges[8] = "Essentially...";
        dialouges[9] = "Wait—did you submit the lab?";
        dialouges[10]= "...";

    }

    @Override
    public void setAction(){
        isMoving = false;
    }

    int dialoguesIndex = 0;
    int postDialogueClicks = 0;
    boolean easterEggUnlocked = false;

    @Override
    public void speak() {

        gp.ui.speakerName = "JP";
        gp.currentSpeaker = "JP";

        if (dialougesIndex < 10) {
            gp.ui.currentDialouge = dialouges[dialougesIndex];
            dialougesIndex++;
        } else {
            // Always show dialogue index 10 after finishing the conversation.
            gp.ui.currentDialouge = dialouges[10];
        }
    }


}
