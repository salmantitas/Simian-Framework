package com.euhedral.game;

import com.euhedral.engine.Engine;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends GameObject {

    private float riseVelocity;;

    public Player(float x, float y) {
        super(x, y, ObjectID.Player);
    }

    public Player(float x, float y, BufferedImage image) {
        super(x, y, image, ObjectID.Player);
    }

    public Player(float x, float y, BufferedImage[] images) {
        super(x, y, images, ObjectID.Player);
    }

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
