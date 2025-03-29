package main;

import java.awt.*;
import java.util.HashMap;

public class EventHandler {

    GamePanel gp;
    Rectangle eventRect;
    int eventRectDefaultX, eventRectDefaultY;

    HashMap<Point, Cutscene> cutsceneMap = new HashMap<>();
    boolean eventActive = false;
    Point currentEventLocation = null;

    public EventHandler(GamePanel gp) {
        this.gp = gp;

        eventRect = new Rectangle(23, 23, 2, 2);
        eventRectDefaultX = eventRect.x;
        eventRectDefaultY = eventRect.y;

        setupCutscenes();
    }

    private void setupCutscenes() {
        cutsceneMap.put(new Point(26, 52), new IntroCutscene(gp));
        // add more cutscenes with tile coordinates here
        // cutsceneMap.put(new Point(x, y), new AnotherCutscene(gp));
    }

    public void checkEvent() {
        if (eventActive && !isPlayerInEventArea()) {
            exitEvent();
            return;
        }

        for (Point eventPoint : cutsceneMap.keySet()) {
            if (!eventActive && hit(eventPoint.x, eventPoint.y, "any")) {
                cutsceneMap.get(eventPoint).play();
                eventActive = true;
                break;
            }
        }
    }

    private boolean isPlayerInEventArea() {
        if (gp.player == null || currentEventLocation == null) return false;

        gp.player.solidArea.x = gp.player.worldX + gp.player.solidArea.x;
        gp.player.solidArea.y = gp.player.worldY + gp.player.solidArea.y;

        eventRect.x = currentEventLocation.x * gp.tileSize + eventRectDefaultX;
        eventRect.y = currentEventLocation.y * gp.tileSize + eventRectDefaultY;

        boolean stillInArea = gp.player.solidArea.intersects(eventRect);

        gp.player.solidArea.x = gp.player.solidAreaDefaultX;
        gp.player.solidArea.y = gp.player.solidAreaDefaultY;
        eventRect.x = eventRectDefaultX;
        eventRect.y = eventRectDefaultY;

        return stillInArea;
    }

    public boolean hit(int eventCol, int eventRow, String reqDirection) {
        if (gp.player == null) return false;

        int playerSolidX = gp.player.solidArea.x;
        int playerSolidY = gp.player.solidArea.y;

        gp.player.solidArea.x = gp.player.worldX + gp.player.solidArea.x;
        gp.player.solidArea.y = gp.player.worldY + gp.player.solidArea.y;
        eventRect.x = eventCol * gp.tileSize + eventRectDefaultX;
        eventRect.y = eventRow * gp.tileSize + eventRectDefaultY;

        boolean hit = false;

        if (gp.player.solidArea.intersects(eventRect)) {
            if (reqDirection.equals("any") || gp.player.direction.equals(reqDirection)) {
                hit = true;
                currentEventLocation = new Point(eventCol, eventRow);
            }
        }

        gp.player.solidArea.x = playerSolidX;
        gp.player.solidArea.y = playerSolidY;
        eventRect.x = eventRectDefaultX;
        eventRect.y = eventRectDefaultY;

        return hit;
    }

    public void exitEvent() {
        gp.gameState = gp.playState;
        gp.ui.currentDialouge = "";
        gp.currentSpeaker = "NULL";
        gp.ui.speakerName = "";
        eventActive = false;
        currentEventLocation = null;
    }
}
