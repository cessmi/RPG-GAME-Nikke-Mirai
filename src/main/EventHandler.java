package main;

import java.awt.*;

public class EventHandler {

    GamePanel gp;
    Rectangle eventRect;
    int eventRectDefaultX, eventRectDefaultY;
    boolean eventActive = false;
    Point currentEventLocation = null;

    public EventHandler(GamePanel gp) {
        this.gp = gp;
        eventRect = new Rectangle(23, 23, 2, 2);
        eventRectDefaultX = eventRect.x;
        eventRectDefaultY = eventRect.y;
    }

    public void checkEvent() {
        // Check if we should exit current event
        if (eventActive && !isPlayerInEventArea()) {
            exitEvent();
            return;
        }

        // Check for new event
        if (!eventActive && hit(36, 54, "any")) {
            testEvent(gp.dialougeState);
        }
    }

    private boolean isPlayerInEventArea() {
        if (gp.player == null || currentEventLocation == null) return false;

        gp.player.solidArea.x = gp.player.worldX + gp.player.solidArea.x;
        gp.player.solidArea.y = gp.player.worldY + gp.player.solidArea.y;

        eventRect.x = currentEventLocation.x * gp.tileSize + eventRectDefaultX;
        eventRect.y = currentEventLocation.y * gp.tileSize + eventRectDefaultY;

        boolean stillInArea = gp.player.solidArea.intersects(eventRect);

        // Reset positions
        gp.player.solidArea.x = gp.player.solidAreaDefaultX;
        gp.player.solidArea.y = gp.player.solidAreaDefaultY;
        eventRect.x = eventRectDefaultX;
        eventRect.y = eventRectDefaultY;

        return stillInArea;
    }

    public boolean hit(int eventCol, int eventRow, String reqDirection) {
        if (gp.player == null) return false;

        // Save original positions
        int playerSolidX = gp.player.solidArea.x;
        int playerSolidY = gp.player.solidArea.y;

        // Calculate positions
        gp.player.solidArea.x = gp.player.worldX + gp.player.solidArea.x;
        gp.player.solidArea.y = gp.player.worldY + gp.player.solidArea.y;
        eventRect.x = eventCol * gp.tileSize + eventRectDefaultX;
        eventRect.y = eventRow * gp.tileSize + eventRectDefaultY;

        boolean hit = false;

        if (gp.player.solidArea.intersects(eventRect)) {
            if (reqDirection.equals("any") ||
                    gp.player.direction.equals(reqDirection)) {
                hit = true;
                currentEventLocation = new Point(eventCol, eventRow);
            }
        }

        // Reset positions
        gp.player.solidArea.x = playerSolidX;
        gp.player.solidArea.y = playerSolidY;
        eventRect.x = eventRectDefaultX;
        eventRect.y = eventRectDefaultY;

        return hit;
    }

    public void testEvent(int gameState) {
        if (gp.ui == null) return;

        gp.gameState = gameState;
        gp.ui.currentDialouge = "Event triggered! Move away to exit.";
        gp.currentSpeaker = "NULL";
        gp.ui.speakerName = "";
        eventActive = true;
    }

    public void exitEvent() {
        gp.gameState = gp.playState;
        gp.ui.currentDialouge = "";
        eventActive = false;
        currentEventLocation = null;
        gp.currentSpeaker = "NULL";
        gp.ui.speakerName = "";

    }
}