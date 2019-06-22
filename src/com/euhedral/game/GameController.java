package com.euhedral.game;

import com.euhedral.engine.BufferedImageLoader;
import com.euhedral.engine.Engine;
import com.euhedral.engine.Entity;
import com.euhedral.engine.GameState;

import java.awt.*;
import java.util.LinkedList;
import java.util.Random;

public class GameController {
    private UIHandler uiHandler;
    private Random r = new Random();

    /********************************************
     * Window Settings - Manually Configurable *
     *******************************************/

    private int gameWidth = Engine.WIDTH;
    private double gameRatio = 4/3;
    private int gameHeight = Engine.HEIGHT;
    private String gameTitle = Engine.TITLE;
    private Color gameBackground = Engine.BACKGROUND_COLOR;

    /****************************************
     * Common Game Variables                *
     * Comment Out Whichever is Unnecessary *
     ****************************************/

    // Score
    private int score = 0;
    private int scoreX = Engine.percWidth(5);
    private int scoreY = Engine.percHeight(15);
    private int scoreSize = Engine.percWidth(4);

    // Vitality
    private int lives = 3;

    private int healthX = Engine.percWidth(2.5);
    private int healthY = 5 * healthX;
    private final int healthDefault = 100;
    private int health = healthDefault;

    // Power
    private int powerX = Engine.percWidth(37);
    private int powerY = scoreY;
    private int powerSize = scoreSize;
    private final int maxPower = 5;
    private int power = 1;

    // High Score
    private LinkedList<Integer> highScore = new LinkedList<>();
    private int highScoreNumbers = 5;
    private boolean updateHighScore = false;

    // Objects
    private Player player;
    private LinkedList<Entity> entities = new LinkedList<>();

    // Camera
    private Camera camera;
    int offsetHorizontal;
    int offsetVertical;

    // Graphics
    private BufferedImageLoader loader;

    // Level Generation
    private LevelGenerator levelGenerator;

    // Levels
    private int levelWidth, levelHeight;
    private boolean loadMission;

    /******************
     * User variables *
     ******************/

    public GameController() {

        /******************
         * Window Setting *
         ******************/
        Engine.setTITLE(gameTitle);
        Engine.setWIDTH(gameWidth);
        Engine.setRatio(gameRatio);
        Engine.setBACKGROUND_COLOR(gameBackground);
        gameHeight = Engine.HEIGHT;
        uiHandler = new UIHandler();
        initializeGame();
        initializeGraphics();
        initializeAnimations();
        initializeLevel();
    }

    /*************************
     * Initializer Functions *
     *************************/

    private void initializeGame() {
        /*************
         * Game Code *
         *************/
    }

    private void initializeGraphics() {
        /*************
         * Game Code *
         *************/
    }

    private void initializeAnimations() {
        /*************
         * Game Code *
         *************/
    }

    private void initializeLevel() {
        /*************
         * Game Code *
         *************/
    }

    public void update() {
        //        System.out.println(Engine.currentState);
        Engine.timer++;

        if (Engine.currentState == GameState.Quit)
            Engine.stop();

        if (Engine.currentState != GameState.Pause && Engine.currentState != GameState.Game || Engine.currentState != GameState.Transition)
            resetGame();

        if (Engine.currentState == GameState.Transition) {
            /*************
             * Game Code *
             *************/
        }

        if (Engine.currentState == GameState.Game) {
            loadMission = false;
            boolean endGameCondition = false;

            if (endGameCondition) {
                Engine.gameOverState();
                enableHighScoreUpdate();
                resetGame();
            }

            /*************
             * Game Code *
             *************/
        }
    }

    public void render(Graphics g) {

        if (Engine.currentState == GameState.Highscore) {
            drawHighScore(g);
        }

        if (Engine.currentState == GameState.Transition) {
            /*************
             * Game Code *
             *************/

        }

        if (Engine.currentState == GameState.Game || Engine.currentState == GameState.Pause || Engine.currentState == GameState.GameOver) {

//            renderInCamera(g);

            /*************
             * Game Code *
             *************/


        }

        /***************
         * Engine Code *
         ***************/

        // The UI must be rendered after everything else, to ensure that it is on top
        uiHandler.render(g);
    }

    private void renderInCamera(Graphics g) {
        /*****************
         * Engine Conde *
         *****************/

        Graphics2D g2d = (Graphics2D) g;

        // Camera start
        g2d.translate(camera.getX(), camera.getY());

        /*************
         * Game Code *
         *************/

        /*****************
         * Engine Conde *
         *****************/

        // Camera end
        g2d.translate(-camera.getX(), -camera.getY());

    }

    /************************
     * User Input Functions *
     ************************/

    public void mouseMoved(int mx, int my) {
        /*************
         * Game Code *
         *************/
    }

    public void mouseDragged(int mx, int my) {
        /*************
         * Game Code *
         *************/
    }

    public void mousePressedAt(int mx, int my) {
        /*************
         * Game Code *
         *************/
    }

    public void mouseReleasedAt(int mx, int my) {
        /*************
         * Game Code *
         *************/
        checkButtonAction(mx, my);
    }

    public void mouseButtonPressed(int mouse) {
        /*************
         * Game Code *
         *************/
    }

    public void mouseButtonReleased(int mouse) {
        /*************
         * Game Code *
         *************/
    }

    public void keyPressed(int key) {
        /*************
         * Game Code *
         *************/
    }

    public void keyReleased(int key) {
        /*************
         * Game Code *
         *************/
    }

    /***************************
     * Game Managing Functions *
     ***************************/

    // High Score

    private void setupHighScore() {
        /***************
         * Engine Code *
         ***************/

        for (int i = 0; i < highScoreNumbers; i++) {
            highScore.add(0);
        }
    }

    private void enableHighScoreUpdate() {
        /***************
         * Engine Code *
         ***************/

        updateHighScore = true;
    }

    private void updateHighScore() {
        /***************
         * Engine Code *
         ***************/

        if (updateHighScore) {
            int toAddIndex = 0;
            for (int hs: highScore) {
                if (hs > score) {
                    toAddIndex++;
                }
                else break;
            }
            highScore.add(toAddIndex, score);
            updateHighScore = false;
        }
    }

    public void resetGame() {
        /***************
         * Engine Code *
         ***************/

        Engine.timer = 0;
        score = 0;
        power = 1;
        health = healthDefault;

        /*************
         * Game Code *
         *************/

    }

    public void checkButtonAction(int mx, int my) {
        /***************
         * Engine Code *
         ***************/

        uiHandler.checkButtonAction(mx, my);
        performAction();
    }

    private void performAction() {
        /***************
         * Engine Code *
         ***************/

        ActionTag action = uiHandler.getAction();
        if (action != null) {
            /*************
             * Game Code *
             *************/

            /***************
             * Engine Code *
             ***************/

            uiHandler.endAction();
        }
    }

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

    private void renderEntities(Graphics g) {
        for (int i = 0; i < entities.size(); i++) {
            Entity entity = entities.get(i);
            entity.render(g);
        }
    }

    /***************************
     * Render Helper Functions *
     ***************************/

    private void drawScore(Graphics g) {
        g.setFont(new Font("arial", 1, 20));
        g.setColor(Color.WHITE);
        g.drawString("Score: " + score, scoreX, scoreY);
    }

    private void drawLives(Graphics g) {
        int x = Engine.intAtWidth640(10);
        int y = x/2;
        int sep = x*2; //x/5;
        int width = Engine.intAtWidth640(16);
        int height = width;
        Color color = Color.GREEN;
        for (int i = 0; i < lives; i++)
        {
            g.setColor(color);
            g.fillOval(x + sep * i, y, width, height);
        }
    }

    private void drawHealth(Graphics g) {
        int width = Engine.intAtWidth640(2);
        int height = width * 6;
        Color backColor = Color.lightGray;
        Color healthColor = Color.GREEN;
        g.setColor(backColor);
        g.fillRect(healthX, healthY, healthDefault * width, height);
        g.setColor(healthColor);
        g.fillRect(healthX, healthY, health * width, height);
    }

    private void drawPower(Graphics g) {
        g.setFont(new Font("arial", 1, powerSize));
        g.setColor(Color.WHITE);
        g.drawString("Power: " + power, powerX, powerY);
    }

    public void drawHighScore(Graphics g) {
        g.setFont(new Font("arial", 1, 20));
        g.setColor(Color.WHITE);
        for (int i = 0; i < highScoreNumbers; i++) {
            g.drawString("Score " + (i+1) + ": " + highScore.get(i), Engine.percWidth(75), Engine.percHeight( 10 * i + 10));
        }
    }

    /******************
     * User functions *
     ******************/
}
