package com.euhedral.game.UI.Menus;

import com.euhedral.engine.GameState;
import com.euhedral.engine.UI.Button;
import com.euhedral.engine.UI.Menu;

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
