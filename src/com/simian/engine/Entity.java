package com.simian.engine;

import com.simian.game.EntityID;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Entity {

    protected int x, y, width, height;
    protected EntityID id;
    protected boolean active = true;

    protected Color color;
    protected BufferedImage image;
    protected BufferedImage images[];

    // Animation
    // why are there here again?
    protected Animation anim;
    protected int animationSpeed = 3;

    // this can be completely commented out if the
    // game has no functional use of physics
    protected float gravity = 1f, terminalVel;

    // every object is initialized to be not jumping or affected by gravity
    protected boolean gravityAffected = false, jumping = false, friction = false;

    public Entity(int x, int y, EntityID id) {
        this.x = x;
        this.y = y;
        this.id = id;
        initialize();
    }

    public Entity(int x, int y, EntityID id, BufferedImage image) {
        this(x,y, id);
        this.image = image;
    }

    public Entity(int x, int y, EntityID id, BufferedImage[] images) {
        this(x,y, id);
        this.images = images;

    }

    protected abstract void initialize();

    public abstract void update();

    public abstract void render(Graphics g);

    protected void drawDefault(Graphics g) {
        if (images != null) {
            drawAnimation(g);
        }
        else if (image != null) {
            g.drawImage(image, (int) x, (int) y, null);
        }
        else {
            setColor(g);
            drawRect(g);
        }
    }

    protected void drawAnimation(Graphics g) {

    }

    protected void renderBounds(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        Color boundColor = Color.green;

//        g.setColor(Color.white);
//        g2d.draw(getBounds());

        g.setColor(boundColor);
        g2d.draw(getBoundsTop());
        g2d.draw(getBoundsBottom());
        g2d.draw(getBoundsLeft());
        g2d.draw(getBoundsRight());
    }

    // Getters & Setters

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public EntityID getId() {
        return id;
    }

    public void setId(EntityID id) {
        this.id = id;
    }

    public boolean isGravityAffected() {
        return gravityAffected;
    }

    public void setGravityAffected(boolean gravityAffected) {
        this.gravityAffected = gravityAffected;
    }

    public boolean isJumping() {
        return jumping;
    }

    public void setJumping(boolean jumping) {
        this.jumping = jumping;
    }

    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, (int) width, (int) height);
    }

    public Rectangle getBoundsTop() {
        return new Rectangle((int) (x + 0.2*width), (int) y,  (int) (0.6* width),  height/4);
    }

    public Rectangle getBoundsBottom() {
        return new Rectangle((int) (x + 0.2*width), (int) y + 3*height/4,  (int) (0.6* width),  height/4);
    }

    public Rectangle getBoundsLeft() {
        return new Rectangle((int) x, (int) (y + 0.35*height),  width/4,  (int) (height * 0.3));
    }

    public Rectangle getBoundsRight() {
        return new Rectangle((int) x + 3*width/4, (int) (y + 0.35*height),  width/4,  (int) (height * 0.3));
    }

    protected void setColor(Graphics g) {
        g.setColor(color);
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    protected void drawImage(Graphics g, BufferedImage image) {
        g.drawImage(image, (int) x, (int) y, null);
    }

    protected void drawRect(Graphics g) {
        g.fillRect((int) x, (int) y, width, height);
    }

    public boolean isActive() {
        return active;
    }

    public void enable() {
        setActive(true);
    }

    public void disable() {
        setActive(false);
    }

    private void setActive(boolean active) {
        this.active = active;
    }

    /*
     * Debug
     * */

    protected void printLocation() {
        System.out.printf("__ at (%d, %d)", x, y);
    }

    public EntityID getID() {
        return id;
    }
}
