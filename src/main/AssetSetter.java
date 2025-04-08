package main;

import entity.*;
import object.OBJ_Book;
import object.OBJ_Door;
import object.OBJ_Key;

public class AssetSetter {

    GamePanel gp;

    public AssetSetter(GamePanel gp){
        this.gp = gp;
    }

    public void setObject(){

        //KEY
        gp.obj[0] = new OBJ_Key(gp);
        gp.obj[0].worldX = 46 * gp.tileSize;
        gp.obj[0].worldY = 52 * gp.tileSize;

        //BOOK
        gp.obj[1] = new OBJ_Book(gp);
        gp.obj[1].worldX = 33 * gp.tileSize;
        gp.obj[1].worldY = 55 * gp.tileSize;

        //DOOR
        gp.obj[3] = new OBJ_Door(gp);
        gp.obj[3].worldX = 16 * gp.tileSize;
        gp.obj[3].worldY = 54 * gp.tileSize;
    }

    public void setNpc(){

        gp.npc[0]= new NPC_Acacius(gp);
        gp.npc[0].worldX = 42 * gp.tileSize;
        gp.npc[0].worldY = 52 * gp.tileSize;

        gp.npc[1] = new NPC_Daphni(gp);
        gp.npc[1].worldX = 70 * gp.tileSize;
        gp.npc[1].worldY = 53 * gp.tileSize;

        gp.npc[2] = new NPC_Phoibus(gp);
        gp.npc[2].worldX = 62 * gp.tileSize;
        gp.npc[2].worldY = 51 * gp.tileSize;

        gp.npc[3] = new NPC_WiseGirl(gp);
        gp.npc[3].worldX = 49 * gp.tileSize;
        gp.npc[3].worldY = 51 * gp.tileSize;

        gp.npc[4] = new NPC_Shein(gp);
        gp.npc[4].worldX = 4 * gp.tileSize;
        gp.npc[4].worldY = 51 * gp.tileSize;

        gp.npc[5] = new NPC_JP(gp);
        gp.npc[5].worldX = 27 * gp.tileSize;
        gp.npc[5].worldY = 54 * gp.tileSize;

        //6 is SmilingGirl

        gp.npc[7] = new NPC_Eirene(gp);
        gp.npc[7].worldX = 58 * gp.tileSize;
        gp.npc[7].worldY = 51 * gp.tileSize;

    }
}
