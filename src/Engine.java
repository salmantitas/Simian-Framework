import java.awt.*;
import java.awt.image.BufferStrategy;

public class Engine extends Canvas {

    /*
    * By Default:
    * VERSION = 0.1
    * TITLE = "Euhedral Engine 0.1"
    * SCREEN_RATIO = 4.0/3.0
    * WIDTH = 640
    * HEIGHT = 480
    * BACKGROUND_COLOR = Color.BLACK
    */
    public double VERSION = 0.12;
    public String TITLE = "Euhedral Engine " + VERSION;
    public double SCREEN_RATIO = 4.0/3.0;
    public int WIDTH = 640;
    public int HEIGHT = (int) (WIDTH / SCREEN_RATIO);
    public Color BACKGROUND_COLOR = Color.BLACK;

    private boolean gameExit = false;
    private static Game game;

    public GameController gameController;

    public GameState currentState = GameState.Game;

    public EngineKeyboard keyInput;
    public EngineMouse mouseInput;

    public Engine() {
        keyInput = new EngineKeyboard();
        mouseInput = new EngineMouse();

        gameController = new GameController();
        game = new Game(this);
        addKeyListener(keyInput);
        addMouseListener(mouseInput);
        System.out.println("Game initialized");
        new Window(WIDTH, HEIGHT, TITLE, this);
    }

    public void update() {
        game.update();
    }

    public void render() {
        BufferStrategy bs = getBufferStrategy();
        if (bs == null) {
            createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();

        g.setColor(BACKGROUND_COLOR);
        g.fillRect(0, 0, WIDTH, WIDTH);

        gameController.render(g);
        game.render(g);

        g.dispose();
        bs.show();
    }

    public void gameLoop() {
        System.out.println("Game loop started");
        long lastTime = System.nanoTime();
        final int TARGET_FPS = 60;
        final long OPTIMAL_TIME = 1000000000 / TARGET_FPS;
        long lastFPStime = 0;
        int fps = 0;

        while (!gameExit) {
            long now = System.nanoTime();
            long updateLength = now - lastTime;
            lastTime = now;
            double delta = updateLength / ((double) OPTIMAL_TIME);
            lastFPStime += updateLength;

            while (delta >= 1) {
                update();
                System.out.println("Updating");
                delta--;
            }
            if (!gameExit) {
                render();
                System.out.println("Rendering");
            }

            fps++;

            if (lastFPStime >= 1000000000) // if a second has passed
            {
                System.out.println("FPS: " + fps);
                lastFPStime = 0;
                fps = 0;
            }
        }
        System.out.println("Game loop exited");
    }

    public static void main(String[] args) {
        System.out.println("Euhedral Engine Started");
        new Engine();
    }

    // Functions to adjust game properties

    public void setWIDTH(int width) {
        WIDTH = width;
    }

    // HEIGHT = WIDTH / SCREEN_RATIO, that is WIDTH * numerator / denominator
    public void setSCREEN_RATIO(double denominator, double numerator) {
        SCREEN_RATIO = (1.0 * denominator) / (1.0 * numerator);
        updateHeight();
    }

    private void updateHeight() {
        HEIGHT = (int) (WIDTH / SCREEN_RATIO);
    }

    public void setTITLE(String title) {
        TITLE = title;
    }

    public void setBACKGROUND_COLOR(Color color) {
        BACKGROUND_COLOR = color;
    }

    public void setBACKGROUND_COLOR(int red, int green, int blue) {
        BACKGROUND_COLOR = new Color(red, green, blue);
    }

    public int perc(int parameter, double percentage) {
        return  (int) (parameter * percentage/ 100.0);
    }

    public int percWidth(double percentage) {
        return perc(WIDTH, percentage);
    }

    public int percHeight(double percentage) {
        return perc(HEIGHT, percentage);
    }

    // UI Functions
    public void addButton(int x, int y, int size, String text, GameState state) {
        gameController.addButton(x, y, size, text, state);
    }

    public void addButton(int x, int y, int size, String text, GameState state, Font font, Color borderColor, Color textColor) {
        gameController.addButton(x, y, size, text, state, font, borderColor, textColor);
    }

    public void addPanel(int x, int y, int width, int height, GameState state) {
        gameController.addPanel(x, y, width, height, state);
    }

    public void addPanel(int x, int y, int width, int height, GameState state, float transparency, Color color) {
        gameController.addPanel(x, y, width, height, state, transparency, color);
    }

    // GameState Functions
    public void setState(GameState state) {
        currentState = state;
    }

    public void gameState() {
        setState(GameState.Game);
    }

    public void menuState() {
        setState(GameState.Menu);
    }
}
