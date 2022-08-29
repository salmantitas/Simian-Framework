package com.euhedral.game;

import com.euhedral.engine.*;
import com.euhedral.game.UI.UIHandler;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

// Manages the game itself, and passes instructions to all other classes under it
public class GameController {
    private UIHandler uiHandler;

    public Scanner scanner;
    public static String cmd;

    /********************************************
     * Window Settings - Manually Configurable *
     *******************************************/

    private int gameWidth = Engine.WIDTH;
    private double gameRatio = 4/3;
    private int gameHeight = Engine.HEIGHT;
    private String gameTitle = Engine.TITLE;
    private Color gameBackground = Engine.BACKGROUND_COLOR;

    // High Score
    private LinkedList<Integer> highScore = new LinkedList<>();
    private int highScoreNumbers = 5;
    private boolean updateHighScore = false;

    // Objects
    private VariableManager variableManager;
    private EntityManager entityManager;

    // Camera
    private Camera camera;
    int offsetHorizontal;
    int offsetVertical;

    // Graphics
    public static Texture texture;

    // Level Generation
    private LevelGenerator levelGenerator;

    // LevelMap to automate level loading
    private HashMap<Integer, BufferedImage> levelMap;

    // Levels
    private int levelWidth, levelHeight;
    private boolean loadMission = false;

    /******************
     * User variables *
     ******************/

    /************
     * Graphics *
     ************/

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

//        Engine.menuState();
        variableManager = new VariableManager();
        entityManager = new EntityManager(variableManager);
        scanner = new Scanner(System.in);

        // Attempt loading latest save-file
        /*
        load();
        */
    }

    private void initializeGraphics() {
        /*************
         * Game Code *
         *************/

        texture = new Texture();
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

        // Initialize Manual Levels
        levelMap = new HashMap<>();
        //        addLevel(1, "/level1.png");

        levelGenerator = new LevelGenerator(this);
    }

    public void update() {
        //        System.out.println(Engine.currentState);
        Engine.timer++;

        if (Engine.stateIs(GameState.Quit))
            Engine.stop();

        if (!Engine.stateIs(GameState.Pause) && !Engine.stateIs(GameState.Game) && !Engine.stateIs(GameState.Transition))
            resetGame();

        uiHandler.update();

        if (Engine.stateIs(GameState.Transition)) {
            /*************
             * Game Code *
             *************/
        }

        /*
         * Disable the level load permission, as the level is already running
         * */
        if (Engine.stateIs(GameState.Game) && !VariableManager.isConsole()) {
            loadMission = false;
            boolean endGameCondition = variableManager.getHealth() <= 0;

            if (endGameCondition) {
                Engine.gameOverState();
                resetGame();
            }

            /*************
             * Game Code *
             *************/

            entityManager.update();
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
            entityManager.render(g);


        }

        /***************
         * Engine Code *
         ***************/

        // The UI must be rendered after everything else, to ensure that it is on top
        uiHandler.render(g);
    }

    private void renderInCamera(Graphics g) {
        /***************
         * Engine Code *
         ***************/

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

    public void resetGame() {
        /***************
         * Engine Code *
         ***************/

        Engine.timer = 0;
        variableManager.resetScore();
        variableManager.resetPower();
        variableManager.resetHealth();

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

    public void save() {
        SaveLoad.saveGame();
        System.out.println("Saving");
    }

    public void load() {
        try {
            SaveLoad.loadGame();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Loading");
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

    public void notifyUIHandler(GameState state) {
        uiHandler.updateState(state);
    }

    public static Texture getTexture() {
        return texture;
    }

    /************************
     * High Score Functions *
     ************************/

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

//    private void updateHighScore() {
//        /***************
//         * Engine Code *
//         ***************/
//
//        if (updateHighScore) {
//            int toAddIndex = 0;
//            for (int hs: highScore) {
//                if (hs > score) {
//                    toAddIndex++;
//                }
//                else break;
//            }
//            highScore.add(toAddIndex, score);
//            updateHighScore = false;
//        }
//    }

    /***************************
     * Render Helper Functions *
     ***************************/

    private void drawScore(Graphics g) {
        variableManager.renderScore(g);
    }

    private void drawHealth(Graphics g) {
        variableManager.renderHealth(g);
    }

    private void drawPower(Graphics g) {
        variableManager.renderPower(g);
    }

//    private void drawLives(Graphics g) {
//        int x = Engine.intAtWidth640(10);
//        int y = x/2;
//        int sep = x*2; //x/5;
//        int width = Engine.intAtWidth640(16);
//        int height = width;
//        Color color = Color.GREEN;
//        for (int i = 0; i < lives; i++)
//        {
//            g.setColor(color);
//            g.fillOval(x + sep * i, y, width, height);
//        }
//    }

    public void drawHighScore(Graphics g) {
        g.setFont(new Font("arial", 1, 20));
        g.setColor(Color.WHITE);
        for (int i = 0; i < highScoreNumbers; i++) {
            g.drawString("Score " + (i+1) + ": " + highScore.get(i), Utility.percWidth(75), Utility.percHeight( 10 * i + 10));
        }
    }

    /******************
     * User functions *
     ******************/

    // Checks whether the level completion requirement has been fulfilled
    public void checkLevelStatus() {
        // If [condition fulfilled]
        // Progress to next level or endgame
        // else, nothing
    }

    public void setLevelHeight(int h) {
        levelHeight = h;
    }

    private void addLevel(int num, String path) {
        BufferedImage level = Engine.loader.loadImage(path);
        levelMap.put(num, level);
    }
}
