import java.awt.*;
import java.util.Random;

public class GameController {
    private UIHandler uiHandler;
    private Random r = new Random();

    /******************
     * User variables *
     ******************/

    public GameController() {
        uiHandler = new UIHandler();

        /******************
         * Window Setting *
         ******************/

        /*************
         * Game Code *
         *************/
    }

    public void update() {
        Engine.timer++;

        if (Engine.currentState != GameState.Pause && Engine.currentState != GameState.Game)
            resetGame();

        if (Engine.currentState == GameState.Game) {

            /*************
             * Game Code *
             *************/
        }
    }

    public void render(Graphics g) {
        uiHandler.render(g);

        if (Engine.currentState == GameState.Pause) {
            drawPause(g);
        }

        if (Engine.currentState == GameState.Game) {

            /*************
             * Game Code *
             *************/
        }
    }

    public void resetGame() {

        /*************
         * Game Code *
         *************/

    }

    public void checkOverlap(int mx, int my) {
        uiHandler.checkOverlap(mx, my);
    }

    public void drawPause(Graphics g) {
        g.setColor(Color.WHITE);
        g.drawString("PAUSED", 100, 100);
    }

    public void addButton(int x, int y, int size, String text, GameState renderState, GameState targetState) {
        uiHandler.addButton(x, y, size, text, renderState, targetState);
    }

    public void addButton(int x, int y, int size, String text, GameState renderState, GameState targetState, Color borderColor, Color textColor) {
        uiHandler.addButton(x, y, size, text, renderState, targetState, borderColor, textColor);
    }

    public void addButton(int x, int y, int size, String text, GameState renderState, GameState targetState, Color borderColor, Color textColor, Font font) {
        uiHandler.addButton(x, y, size, text, renderState, targetState, borderColor, textColor, font);
    }

    public void addPanel(int x, int y, int width, int height, GameState state) {
        uiHandler.addPanel(x, y, width, height, state);
    }

    public void addPanel(int x, int y, int width, int height, GameState state, float transparency, Color color) {
        uiHandler.addPanel(x, y, width, height, state, transparency, color);
    }

    /******************
     * User functions *
     ******************/
}
