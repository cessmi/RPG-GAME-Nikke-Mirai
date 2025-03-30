package entity;

import main.GamePanel;
import main.JumpScare;
import main.JumpScare2;

public class NPC_SmilingGirl extends Entity {

    public boolean postJumpscare = false;

    public NPC_SmilingGirl(GamePanel gp) {
        super(gp);

        direction = "south";
        speed = 1;

        getImage();
        setDialouge();
    }

    public void getImage() {
        south0 = setup("/npc/npc_static/npc3");
        idleImage = south0;
    }

    public void setDialouge() {
        dialouges[0] = "Oh. You can see me?";
        dialouges[1] = "Not everyone does.\nOr maybe they choose not to.";
        dialouges[2] = "You're not like them though.\nYou looked straight at me.";
        dialouges[3] = "That's rude, y'know? Staring.";
        dialouges[4] = "What if I stared back?";
        dialouges[5] = "*grins wider*";
        dialouges[6] = "You’re still here? Wow.\nMost people walk away by now.";
        dialouges[7] = "Are you brave?";
        dialouges[8] = "Or just really... really... *dumb*?";
        dialouges[9] = "Let's test it.";
        dialouges[10] = "...";
        dialouges[11] = "...";
        dialouges[12] = "RAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAHHHHHHHHHH!!!"; // Jumpscare trigger line

        // Post-jumpscare dialogue
        dialouges[13] = "AHAHAHAHA! You flinched! You *so* flinched!";
        dialouges[14] = "That was adorable.";
        dialouges[15] = "You’re my favorite now.";
        dialouges[16] = "...Wanna go again?";
    }

    @Override
    public void setAction() {
        isMoving = false;
    }

    @Override
    public void speak() {
        gp.ui.speakerName = "Smiling Girl";
        gp.currentSpeaker = "Smiling Girl";

        if (!dialogueFinished && !postJumpscare) {
            if (dialougesIndex <= 12) {
                gp.ui.currentDialouge = dialouges[dialougesIndex];
                dialougesIndex++;

                if (dialougesIndex == 13) {
                    dialogueFinished = true;
                }
            } else {
                dialogueFinished = true;
            }

        } else if (dialogueFinished && !postJumpscare) {
            // Jumpscare trigger
            if (gp.keyH.enterPressed) {
                new JumpScare2();
                gp.playSE(5);
                gp.keyH.enterPressed = false; // ⬅️ prevent double triggers
                dialogueFinished = false;
                postJumpscare = true;
                dialougesIndex = 13;
            }

        } else if (postJumpscare) {
            // Post-jumpscare dialogue
            if (dialougesIndex <= 16) {
                gp.ui.currentDialouge = dialouges[dialougesIndex];
                dialougesIndex++;
            } else {
                // Loop "..." after everything
                gp.ui.currentDialouge = dialouges[16];
            }
        }
    }
}
