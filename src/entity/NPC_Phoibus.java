package entity;

import main.GamePanel;

public class NPC_Phoibus extends Entity{

    public NPC_Phoibus(GamePanel gp) {
        super(gp);

        direction = "south";
        speed = 1;

        getImage();
        setDialouge();
    }

    public void getImage() {
        south0 = setup("/npc/npc_static/Phoibus");

        idleImage = south0;
    }

    public void setDialouge(){

        dialouges[0] = "Ah... another face in the fog.\nYou don’t carry the usual weight.\nNot yet.";
        dialouges[1] = "The train moves, but it doesn’t\nalways carry us forward.\nSometimes... it loops.\nLike regret";
        dialouges[2] = "You saw her, didn’t you? The Conductor.\nDaphni.";
        dialouges[3] = "...She wasn’t always like this.";
        dialouges[4] = "She tried to change her fate. And I—";
        dialouges[5] = "...I tried to stop her from vanishing.";
        dialouges[6] = "Do you believe love is selfless? I did.\nUntil I saved her... and condemned her.";
        dialouges[7]= "She won’t say it, but she hates me for it.\nAnd I...";
        dialouges[8]= "...I still look at her like she’s\nthe only star in the sky.";
        dialouges[9] = "You’ll understand soon enough.\nWhat fate asks of us.";
        dialouges[10] = "...Just promise me something, traveler—";
        dialouges[11] = "When the library calls your name...\ndon't answer.";
        dialouges[12] = "...";
    }

    @Override
    public void setAction(){
        isMoving = false;
    }

    @Override
    public void speak() {
        gp.ui.speakerName = "Phoibus";

        if (dialougesIndex < 12) {
            String line = dialouges[dialougesIndex];
            gp.ui.currentDialouge = line;

            if (line.trim().equals("...")) {
                gp.currentSpeaker = "PhoibusSilent";
            } else {
                gp.currentSpeaker = "Phoibus";
            }

            dialougesIndex++;
            gp.ui.dialogueFinished = false; // still going
        } else {
            // Final line: show "..." and wait for player to confirm
            gp.ui.currentDialouge = dialouges[12];
            gp.currentSpeaker = "PhoibusSilent";
            gp.ui.dialogueFinished = true; // ✅ signals end
        }
    }



}
