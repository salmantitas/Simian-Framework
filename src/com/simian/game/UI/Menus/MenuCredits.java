package com.simian.game.UI.Menus;

import com.simian.engine.GameState;
import com.simian.engine.UI.Button;
import com.simian.engine.UI.ButtonNav;
import com.simian.engine.UI.Menu;
import com.simian.engine.Utility;

import java.awt.*;
import java.util.ArrayList;

public class MenuCredits extends Menu {

    public MenuCredits() {
        super(GameState.Credits);
        MAXBUTTON = 1;
        options = new Button[MAXBUTTON];

        ButtonNav backToMenu = new ButtonNav(x2, yFINAL, Utility.perc(buttonSize, 80), "Main Menu", GameState.Menu);
        options[0] = backToMenu;
    }

    @Override
    public void render(Graphics g) {
        super.render(g);

        drawText(g);

        super.postRender(g);
    }

    private void drawText(Graphics g) {
        g.setFont(new Font("arial", 1, titleSize));
        g.setColor(Color.WHITE);

        g.drawString("Credits", x15, y00);

        g.setFont(new Font("arial", 1, 30));
        ArrayList<String> text = new ArrayList<>();
        text.add("Credit Text Line 1");
        text.add(""); // Space

        int lineHeightInPixel = 40;
        for (int i = 0; i < text.size(); i++)
        {
            String s = text.get(i);
            g.drawString(s, x0, y20 + (i+1)*lineHeightInPixel);
        }
    }
}
