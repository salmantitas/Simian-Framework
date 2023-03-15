package com.simian.game.UI.Menus;

import com.simian.engine.GameState;
import com.simian.engine.UI.Button;
import com.simian.engine.UI.Menu;

import java.awt.*;

public class MenuPlay extends Menu {

    public MenuPlay() {
        /***************
         * Engine Code *
         ***************/

        super(GameState.Game);
        MAXBUTTON = 0;
        options = new Button[MAXBUTTON];

        /*************
         * Game Code *
         *************/

        // todo: Code here
    }

    @Override
    public void render(Graphics g) {
        /***************
         * Engine Code *
         ***************/

        super.render(g);

        /*************
         * Game Code *
         *************/

        // todo: Code here

        /***************
         * Engine Code *
         ***************/

        super.postRender(g);
    }
}
