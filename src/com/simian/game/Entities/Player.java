package com.simian.game.Entities;

import com.simian.engine.MobileEntity;
import com.simian.game.EntityID;

import java.awt.*;

public class Player extends MobileEntity {

    public Player(int x, int y) {
        super(x, y, EntityID.Player);
    }

//    public Player(int x, int y, BufferedImage image) {
//        super(x, y, image, EntityID.Player);
//    }
//
//    public Player(int x, int y, BufferedImage[] images) {
//        super(x, y, images, EntityID.Player);
//    }

    @Override
    public void initialize() {
        /*************
         * Game Code *
         *************/

    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics g) {

    }

    @Override
    public void drawAnimation(Graphics g) {

    }

    /******************
     * User functions *
     ******************/
}
