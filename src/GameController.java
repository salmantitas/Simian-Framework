import java.awt.*;

public class GameController {
    private UIHandler uiHandler;

    public GameController() {
        uiHandler = new UIHandler();
    }

    public void update() {

    }

    public void render(Graphics g) {
        uiHandler.render(g);
    }

    public void addButton(int x, int y, int size, String text, GameState state) {
        uiHandler.addButton(x, y, size, text, state);
    }

    public void addButton(int x, int y, int size, String text, GameState state, Font font, Color borderColor, Color textColor) {
        uiHandler.addButton(x, y, size, text, state, font, borderColor, textColor);
    }

    public void addPanel(int x, int y, int width, int height, GameState state) {
        uiHandler.addPanel(x, y, width, height, state);
    }

    public void addPanel(int x, int y, int width, int height, GameState state, float transparency, Color color) {
        uiHandler.addPanel(x, y, width, height, state, transparency, color);
    }
}
