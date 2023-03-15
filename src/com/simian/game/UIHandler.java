package com.simian.game;

import com.simian.engine.*;
import com.simian.engine.UI.Menu;
import com.simian.game.UI.Menus.MenuPlay;

import java.awt.*;
import java.util.ArrayList;

public class UIHandler {
    private Menu currentMenu;
    private ArrayList<Menu> menus;
    ActionTag action = null;

    /************************
    * Common game variables *
    *************************/

    Menu nullMenu = new Menu(GameState.Quit);

    /******************
     * User variables *
     ******************/


    public UIHandler() {

        /***************
         * Engine Code *
         ***************/

        menus = new ArrayList<>();

        /*************
         * Game Code *
         *************/

        // stubMenu
        MenuPlay playMenu = new MenuPlay();
        menus.add(playMenu);
        currentMenu = playMenu;

    }

    public void update() {
        currentMenu.update();
    }

    /*
     * Renders the current menu
     * */
    public void render(Graphics g) {
        currentMenu.render(g);

        // Debug/Console
        Utility.drawState(g);
        if (VariableHandler.isConsole())
            Utility.drawCommand(g);
    }

    public void checkHover(int mx, int my) {
        currentMenu.checkHover(mx, my);
    }

    public void checkButtonAction(int mx, int my) {
        action = currentMenu.checkButtonAction(mx, my);
    }

    public void chooseSelected() {
        currentMenu.chooseSelected();
    }

    /*
     * Changes the menu to match the current gameState. If no matching menu is found, it's set to an empty menu.
     * */
    private void findNewCurrent(GameState state) {
        boolean menuChanged = false;
//        currentMenu = nullMenu;

        for (Menu menu: menus) {
            if (menu.getState() == state) {
                currentMenu = menu;
                menuChanged = true;
                break;
            }
        }

        if (!menuChanged)
            currentMenu = nullMenu;
    }

    public void keyboardSelection(char c) {
        currentMenu.keyboardSelection(c);
    }

    public ActionTag getAction() {
        return action;
    }

    public void endAction() {
        action = null;
    }

    public void updateState(GameState state) {
        findNewCurrent(state);
    }

    /***************************
     * Render Helper Functions *
     ***************************/

    /*******************
     * Debug Functions *
     *******************/
}
