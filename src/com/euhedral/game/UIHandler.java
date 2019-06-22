package com.euhedral.game;

import com.euhedral.engine.*;
import com.euhedral.engine.Button;
import com.euhedral.engine.MenuItem;
import com.euhedral.engine.Panel;

import java.awt.*;
import java.util.LinkedList;

public class UIHandler {
    private LinkedList<MenuItem> menuItems = new LinkedList<>();
    private LinkedList<ButtonNav> navButtons = new LinkedList<>();
    private LinkedList<ButtonAction> actButtons = new LinkedList<>();
    ActionTag action = null;

    // Common game variables

    private int selectedButton = -1;

    // Title Variables

    int titleX = Engine.percWidth(2);
    int titleY = Engine.percHeight(20);
    int titleSize = Engine.percWidth(11.5);
    Color titleColor = Color.BLACK;

    // Button Variables

    int buttonSize = Engine.percWidth(5);
    int leftButtonX = Engine.percWidth(5);
    int midLeftButtonX = Engine.percWidth(38);
    int midButtonX = Engine.percWidth(45);
    int midRightButtonX = Engine.percWidth(50);
    int rightButtonX = Engine.percWidth(80);
    int topButtonY = Engine.percHeight(30);
    int midHeightButtonY = Engine.percHeight(50);
    int lowestButtonY = Engine.percHeight(70);

    // User Variables

    public UIHandler() {

        // Game Backdrop

        // Main Menu



        // In-Game

        // Transition

        // Game Over

        // High Score Menu

    }

//    public void update() {
//
//    }

    public void render(Graphics g) {
        if (Engine.currentState == GameState.Help) {
            drawHelpText(g);
        }

        if (Engine.currentState == GameState.Pause) {
            drawPause(g);
        }

        if (Engine.currentState == GameState.GameOver) {
            drawGameOverScreen(g);
        }

        for (MenuItem menuItem: menuItems) {
            if (menuItem.stateIs(Engine.currentState))
                menuItem.render(g);
        }

        for (ButtonNav buttonNav : navButtons) {
            if (buttonNav.stateIs(Engine.currentState))
                buttonNav.render(g);
        }

        for (ButtonAction actButton : actButtons) {
            if (actButton.stateIs(Engine.currentState)) {
                actButton.render(g);
            }
        }

        if (Engine.currentState == GameState.Menu) {
            drawTitle(g);
        }
    }

    public void checkHover(int mx, int my) {
        for (ButtonNav button: navButtons) {
            if (button.stateIs(Engine.currentState)) {
                if (button.mouseOverlap(mx, my)) {
                    button.select();
                } else button.deselect();
            }
        }

        for (ButtonAction button: actButtons) {
            if (button.stateIs(Engine.currentState)) {
                if (button.mouseOverlap(mx, my)) {
                    button.select();
                } else button.deselect();
            }
        }
    }

    public void checkButtonAction(int mx, int my) {
        for (ButtonNav buttonNav : navButtons) {
            if (buttonNav.stateIs(Engine.currentState))
                if (buttonNav.mouseOverlap(mx, my)) {
                    Engine.setState(buttonNav.getTargetSate());
                    break;
                }
        }

        for (ButtonAction actButton : actButtons) {
            if (actButton.stateIs(Engine.currentState)) {
                if (actButton.mouseOverlap(mx, my)) {
                    this.action = actButton.getAction();
                    break;
                }
            }
        }
    }

    public void chooseSelected() {
        Button selected = null;

        for (ButtonNav buttonNav : navButtons) {
            if (buttonNav.stateIs(Engine.currentState))
                if (buttonNav.isSelected()) {
                    Engine.setState(buttonNav.getTargetSate());
                    break;
                }
        }

        if (selected == null) {

            for (ButtonAction actButton : actButtons) {
                if (actButton.stateIs(Engine.currentState)) {
                    if (actButton.isSelected()) {
                        this.action = actButton.getAction();
                    }
                }
            }
        }
    }

    public ActionTag getAction() {
        return action;
    }

    public void endAction() {
        action = null;
    }

    /***************************
     * Render Helper Functions *
     ***************************/

    private void drawTitle(Graphics g) {
        Font font = new Font("arial", 1, titleSize);
        g.setFont(font);
        g.setColor(titleColor);
        g.drawString(Engine.TITLE, titleX, titleY);
    }

    public void drawPause(Graphics g) {
        g.setFont(new Font("arial", 1, Engine.percWidth(20)));
        g.setColor(Color.WHITE);
        g.drawString("PAUSE", Engine.percWidth(16), Engine.percHeight(25));
    }

    public void drawGameOverScreen(Graphics g) {
        g.setFont(new Font("arial", 1, 200));
        g.setColor(Color.WHITE);
        g.drawString("GAME OVER", Engine.percWidth(2), Engine.HEIGHT/2);
    }

    private void drawHelpText(Graphics g) {
        int num = 0;
        g.setFont(new Font("arial", 1, 30));
        g.setColor(Color.WHITE);
        String[] help = new String[num];
        int lineHeightInPixel = 80;
        /*help[0] = "W-A-S-D for movement";
        help[1] = "SPACEBAR to shoot";
        help[2] = "CTRL to switch between air and ground weapons";
        help[3] = "ESC or P in-game to pause or resume";
        help[4] = "ESC from menu to quit";*/
        int helpX = 200;
        for (int i = 0; i < help.length; i++) {
            g.drawString(help[i], helpX, (i+1)*lineHeightInPixel);
        }
    }

    /****************
     * UI Functions *
     ****************/

    public void addButton(ButtonNav buttonNav) {
        navButtons.add(buttonNav);
    }

    public void addButton(ButtonAction actButton) {
        actButtons.add(actButton);
    }

    public void addButton(int x, int y, int size, String text, GameState renderState, GameState targetState) {
        navButtons.add(new ButtonNav(x, y, size, text, renderState, targetState));
    }

    public void addButton(int x, int y, int size, String text, GameState renderState, GameState targetState, Color borderColor, Color textColor) {
        navButtons.add(new ButtonNav(x, y, size, text, renderState, targetState, borderColor, textColor));
    }

    public void addButton(int x, int y, int size, String text, GameState renderState, GameState targetState, Color borderColor, Color textColor, Font font) {
        navButtons.add(new ButtonNav(x, y, size, text, renderState, targetState, borderColor, textColor, font));
    }

    public void addPanel(Panel panel) {
        menuItems.add(panel);
    }

    public void addPanel(int x, int y, int width, int height, GameState state) {
        menuItems.add(new Panel(x, y, width, height, state));
    }


    public void addPanel(int x, int y, int width, int height, GameState state, float transparency, Color color) {
        menuItems.add(new Panel(x, y, width, height, state, transparency, color));
    }
}
