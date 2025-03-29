package main;

import java.awt.*;

public class EventHandler {

    GamePanel gp;
    Rectangle eventRect;
    int eventRectDefaultX, eventRectDefaultY;

    public EventHandler(GamePanel gp) {
        this.gp = gp;

        eventRect = new Rectangle();
        eventRect.x = 23;
        eventRect.y = 23;
        eventRect.width = 2;
        eventRect.height = 2;
        eventRectDefaultX = eventRect.x;
        eventRectDefaultY = eventRect.y;
    }

    public void checkEvent() {
//        if (triggerEvent(10, 5, "any")) { // Example: Player steps on (10,5), battle starts
//            startBattle();
//        }
        if (triggerEvent(15, 8, "any")) { // Example: Player steps on (15,8), cutscene plays
            gp.ui.showMessage("A mysterious force stops you...");
            playCutscene();
        }
    }

    public boolean triggerEvent(int eventCol, int eventRow, String reqDirection) {
        boolean triggered = false;

        gp.player.solidArea.x = gp.player.worldX + gp.player.solidArea.x;
        gp.player.solidArea.y = gp.player.worldY + gp.player.solidArea.y;
        eventRect.x = eventCol * gp.tileSize + eventRect.x;
        eventRect.y = eventRow * gp.tileSize + eventRect.y;

        if (gp.player.solidArea.intersects(eventRect)) {
            if (gp.player.direction.equals(reqDirection) || reqDirection.equals("any")) {
                triggered = true;
            }
        }

        gp.player.solidArea.x = gp.player.solidAreaDefaultX;
        gp.player.solidArea.y = gp.player.solidAreaDefaultY;
        eventRect.x = eventRectDefaultX;
        eventRect.y = eventRectDefaultY;

        return triggered;
    }

//    public void startBattle() {
//        gp.ui.showMessage("A battle starts!");
//        gp.gameState = gp.battleState; // Change game state to battle
//    }

    public void playCutscene() {
        // Trigger a cutscene (this is where you would implement a transition)
        gp.ui.showMessage("A vision appears...");
    }
}
