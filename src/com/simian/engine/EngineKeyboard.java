package com.simian.engine;/*
 * Do not modify
 * */

import com.simian.game.GameController;
import com.simian.game.KeyInput;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class EngineKeyboard extends KeyAdapter {
    public GameController gameController;
    private KeyInput keyInput;

    private int keyPressed;
    private int keyReleased;

    public EngineKeyboard(GameController gameController) {
        this.gameController = gameController;
        keyInput = new KeyInput(this, gameController);
    }

    public void keyPressed(KeyEvent e) {
        keyPressed = e.getKeyCode();

        keyInput.updatePressed();

        System.out.println(keyPressed + " Key Pressed");

    }

    public void keyReleased(KeyEvent e) {
        keyReleased = e.getKeyCode();

        keyInput.updateReleased();

        System.out.println(keyReleased + " Key Released");
    }

    public int getKeyPressed() {
        return keyPressed;
    }

    public int getKeyReleased() {
        return keyReleased;
    }

    public boolean keyIsPressed(int key) {
        return keyPressed == key;
    }

    public boolean keyIsReleased(int key) {
        return keyReleased == key;
    }
}
