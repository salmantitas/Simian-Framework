package com.euhedral.game;

import com.euhedral.engine.Engine;
import com.euhedral.engine.Entity;

public class Camera {

    private float x,y;
    private float marker;

    public Camera(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public void update(Entity entity) {
        x = entity.getX() - Engine.WIDTH/2;
        y = entity.getY() - Engine.HEIGHT/2;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getMarker() {
        return marker;
    }

    public void setMarker(float marker) {
        this.marker = marker - Engine.HEIGHT;
    }


}
