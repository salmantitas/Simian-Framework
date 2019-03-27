package com.euhedral.game;

import com.euhedral.engine.Engine;

import java.awt.*;

public class Player extends GameObject {

    private float riseVelocity;;

    public Player(float x, float y) {
        super(x, y, ObjectID.Player);

        initialize();
    }

    private void initialize() {
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

    /******************
     * User functions *
     ******************/
}
