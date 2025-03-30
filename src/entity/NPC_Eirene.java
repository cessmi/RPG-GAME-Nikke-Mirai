package entity;

import main.GamePanel;

public class NPC_Eirene extends Entity{

    public NPC_Eirene(GamePanel gp) {
        super(gp);

        direction = "south";
        speed = 1;

        getImage();
        setDialouge();
    }

    public void getImage() {
        south0 = setup("/npc/npc_static/npc2");

        idleImage = south0;
    }

    public void setDialouge(){

        dialouges[0] = "Have you seen the man with the brown coat?";
        dialouges[1] = "He promised he’d meet me here.";
        dialouges[2] = "I brought his favorite tea.\nIt’s cold now, but I don’t mind.";
        dialouges[3] = "It’s silly… I don’t even know if he made it\naboard.";
        dialouges[4] = "But waiting feels better than forgetting.";
        dialouges[5] = "You look like someone who keeps their\npromises.";
        dialouges[6] = "If you find him, tell him I waited.";
        dialouges[7] = "Even if he’s forgotten...\nI haven’t.";
        dialouges[8] = "...";

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

        gp.ui.speakerName = "Eirene";
        gp.currentSpeaker = "Eirene";

        if (dialougesIndex < 8) {
            gp.ui.currentDialouge = dialouges[dialougesIndex];
            dialougesIndex++;
        } else {
            // Always show dialogue index 8 after finishing the conversation.
            gp.ui.currentDialouge = dialouges[8];
        }
    }


}
