package main;

public class IntroCutscene implements Cutscene {

    GamePanel gp;

    public IntroCutscene(GamePanel gp) {
        this.gp = gp;
    }

    @Override
    public void play() {
        gp.gameState = gp.dialougeState;
        gp.currentSpeaker = "NULL";
        gp.ui.speakerName = "";
        gp.ui.currentDialouge = "The air feels strange...\nSomething's not right.";
    }
}
