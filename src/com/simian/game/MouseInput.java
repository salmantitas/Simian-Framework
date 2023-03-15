package com.simian.game;

import com.simian.engine.EngineMouse;

import java.awt.event.MouseAdapter;

public class MouseInput extends MouseAdapter {
    private GameController gameController;
    private EngineMouse mouse;

    public MouseInput(EngineMouse engineMouse, GameController gameController) {
        this.gameController = gameController;
        mouse = engineMouse;
    }

    public void updatePressed() {
        notifyPress(mouse.getButtonPressed());
    }

    public void updateReleased() {
        notifyRelease(mouse.getButtonReleased());
        gameController.checkButtonAction(getMxReleased(), getMyReleased());
    }

    public void updateMoved() {
        notifyMoved(getMxMoved(), getMyMoved());
    }
    public void updateDragged() {
        notifyDragged(getMxDrag(), getMyDrag());
    }

    public int getMxMoved() {
        return mouse.getMxMove();
    }

    public int getMyMoved() {
        return mouse.getMyMove();
    }

    public int getMxDrag() {
        return mouse.getMxDrag();
    }

    public int getMyDrag() {
        return mouse.getMyDrag();
    }

    public int getMxPressed() {
        return mouse.getMxPressed();
    }

    public int getMyPressed() {
        return mouse.getMyPressed();
    }

    public int getMxReleased() {
        return mouse.getMxReleased();
    }

    public int getMyReleased() {
        return mouse.getMyReleased();
    }

    private void notifyPress(int me) {
        gameController.mouseButtonPressed(me);
    }

    private void notifyRelease(int me) {
        gameController.mouseButtonReleased(me);
    }

    private void notifyMoved(int mx, int my) {
        gameController.mouseMoved(mx, my);
    }

    private void notifyDragged(int mx, int my) {
        gameController.mouseDragged(mx, my);
    }
}
