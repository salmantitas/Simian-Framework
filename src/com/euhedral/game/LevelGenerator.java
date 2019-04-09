package com.euhedral.game;

import java.awt.image.BufferedImage;
import java.util.Random;

public class LevelGenerator {

    private GameController gameController;
    private Random random = new Random();

    public LevelGenerator(GameController gameController) {
        this.gameController = gameController;
    }

    public void loadImageLevel(BufferedImage image) {
        int w = image.getWidth();
        int h = image.getHeight();

        System.out.println("Width, Height: " + w + " " + h);

        for (int j = h - 1; j >= 0; j--) {
            for (int i = w - 1; i >= 0; i--) {
                int pixel = image.getRGB(i, j);
                int r = (pixel >> 16) & 0xff;
                int g = (pixel >> 8) & 0xff;
                int b = pixel & 0xff;

                /*************
                 * Game Code *
                 *************/
            }
        }


    }


}
