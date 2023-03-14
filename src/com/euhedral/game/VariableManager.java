package com.euhedral.game;

import com.euhedral.engine.Attribute;
import com.euhedral.engine.Engine;
import com.euhedral.engine.Utility;

import java.awt.*;
import java.util.HashMap;

public class VariableManager {

    /****************************************
     * Global Game Variables                *
     * Comment Out Whichever is Unnecessary *
     ****************************************/
    private static boolean hud = true;
    private static boolean console = false;
    private static boolean tutorial = true;

    /****************************************
     * Common Game Variables                *
     * Comment Out Whichever is Unnecessary *
     ****************************************/

    // Notifications
    public static String saveText = "Game Saved Successfully.";
    public static String loadText = "Game Loaded Successfully.";
    public static String saveDataNotification = "";
    public static int notificationSet;

    // Attributes

    public static Attribute health;

    // Score
    private static int score = 0;
    private static int scoreX = Utility.percWidth(2.5);
    private static int scoreY = Utility.percHeight(4);
    private static int scoreSize = Utility.percWidth(2);

    public static HashMap<Color, EntityID> colorMap;

    /******************
     * User Variables *
     ******************/

    private int healthBossDef, healthBoss;
    private int bossScore = 500;
    private boolean bossLives = false;

    // todo: ActionTag will be updated here
    private ActionTag action = null;

    public VariableManager() {
        colorMap = new HashMap<>();
        initializeColorMap();
        initializeAttributes();
    }

    private void initializeColorMap() {
        /*************
         * Game Code *
         *************/

    }

    private void initializeAttributes() {
        health = new Attribute(100, false);
        health.setY(Utility.percHeight(5));
        health.setBodyColor(Color.green);
    }

    public static void console() {
        console = !console;
        System.out.println("Console is " + console);
    }

    public static boolean isConsole() {
        return console;
    }

    public static boolean isHud() {
        return hud;
    }

    public void resetScore() {
        score = 0;
    }

    public void increaseScore(int score) {
        this.score += score;
    }

    public void decreaseScore(int score) {
        this.score -= score;
    }

    /**********
     * Render *
     **********/

    public static void renderHUD(Graphics g) {
        renderScore(g);
        health.renderBar(g);
    }

    public static void renderScore(Graphics g) {
        g.setFont(new Font("arial", 1, scoreSize));
        g.setColor(Color.WHITE);
        g.drawString("Score: " + score, scoreX, scoreY);
    }

    protected void drawBossHealth(Graphics g) {
        int startX = Utility.percWidth(35);
        int endX = Utility.percWidth(65);
        int diffX = endX - startX;

        int y = Utility.percHeight(28);
        int width = diffX / healthBossDef;
        int height = width;
        Color backColor = Color.lightGray;
        Color healthColor = Color.RED;
        g.setColor(backColor);
        g.fillRect(startX, y, healthBossDef * width, height);
        g.setColor(healthColor);
        g.fillRect(startX, y, healthBoss * width, height);
    }


    /**********************
     * Getters and setters *
     ***********************/

    public static int getScore() {
        return score;
    }

    public static void setScore(int score) {
        VariableManager.score = score;
    }

    public int getScoreX() {
        return scoreX;
    }

    public void setScoreX(int scoreX) {
        VariableManager.scoreX = scoreX;
    }

    public int getScoreY() {
        return scoreY;
    }

    public void setScoreY(int scoreY) {
        VariableManager.scoreY = scoreY;
    }

    public int getScoreSize() {
        return scoreSize;
    }

    public void setScoreSize(int scoreSize) {
        VariableManager.scoreSize = scoreSize;
    }

    public int getHealthBossDef() {
        return healthBossDef;
    }

    public void setHealthBossDef(int healthBossDef) {
        this.healthBossDef = healthBossDef;
    }

    public int getHealthBoss() {
        return healthBoss;
    }

    public void setHealthBoss(int healthBoss) {
        this.healthBoss = healthBoss;
    }

    public int getBossScore() {
        return bossScore;
    }

    public void setBossScore(int bossScore) {
        this.bossScore = bossScore;
    }

    public boolean isBossLives() {
        return bossLives;
    }

    public void setBossLives(boolean bossLives) {
        this.bossLives = bossLives;
    }

    public static boolean tutorialEnabled() {
        return tutorial;
    }

    public static void toggleTutorial() {
        tutorial = !tutorial;
        SaveLoad.saveSettings();
    }

    public static void resetSaveDataNotification() {
        saveDataNotification = "";
    }
}
