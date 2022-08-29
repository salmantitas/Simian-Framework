package com.euhedral.game;

import com.euhedral.engine.Entity;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

// Manages all entities in game
public class EntityManager {
    private VariableManager variableManager;

    private LinkedList<Entity> entities;

    // Player

    // Entity Lists

    EntityManager(VariableManager variableManager) {
        /***************
         * Engine Code *
         ***************/

        this.variableManager = variableManager;

        /*************
         * Game Code *
         *************/

        // todo: Code here, remove entities stub if unnecessary

        entities = new LinkedList<>(); // stub
    }

    public void initializeGraphics() {
        /*************
         * Game Code *
         *************/
//        playerSpriteSheet = new SpriteSheet("/player.png");
//        playerImage = new BufferedImage[2];
//        playerImage[0] = playerSpriteSheet.grabImage(1,1,32,32);
//        playerImage[1] = playerSpriteSheet.grabImage(2,1,32,32);
    }

    public void initializeAnimations() {
        /*************
         * Game Code *
         *************/
    }

    public void update() {
        /*************
         * Game Code *
         *************/

        // todo: Code here

        for (Entity e: entities) {
            e.update();
        }
    }

    public void render(Graphics g) {
        /*************
         * Game Code *
         *************/

        // todo: Code here

        for (Entity e: entities) {
            e.render(g);
        }
    }

    public void spawnEntity(int x, int y, EntityID id, Color color) {

    }

    /********************
     * Player Functions *
     ********************/

    /*******************************
     * Entity Management Functions *
     ****************-**************/

    public void addEntity(Entity entity) {
        entities.add(entity);

        /*************
         * Game Code *
         *************/
    }

    public void removeEntity(Entity entity) {
        entities.remove(entity);

        /*************
         * Game Code *
         *************/
    }

    private void updateEntities() {
        for (int i = 0; i < entities.size(); i++) {
            Entity entity = entities.get(i);
            entity.update();
        }
    }

    private void updateActiveEntities(LinkedList<Entity> list) {
        for (int i = 0; i < list.size(); i++) {
            Entity entity = list.get(i);
            if (entity.isActive())
                entity.update();
        }
    }

    private void renderEntities(Graphics g) {
        for (int i = 0; i < entities.size(); i++) {
            Entity entity = entities.get(i);
            entity.render(g);
        }
    }
}
