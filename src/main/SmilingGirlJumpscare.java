package main;

import entity.NPC_SmilingGirl;
import java.awt.*;

public class SmilingGirlJumpscare implements Cutscene {
    GamePanel gp;

    public SmilingGirlJumpscare(GamePanel gp) {
        this.gp = gp;
    }

    @Override
    public void play() {
        // Play creepy sound
        gp.playSE(5); // make sure you assign a creepy SE to index 6

        // Spawn the NPC
        NPC_SmilingGirl npc = new NPC_SmilingGirl(gp);
        npc.worldX = gp.tileSize * 14;
        npc.worldY = gp.tileSize * 53;
        gp.npc[6] = npc;

//        // Optional: Freeze the player briefly or do a creepy flash
//        gp.ui.showMessage("...She's here.");
//        gp.gameState = gp.pauseState;
    }
}
