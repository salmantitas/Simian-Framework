import java.awt.*;
import java.util.LinkedList;

public class UIHandler {
    private LinkedList<MenuItem> menuItems = new LinkedList<>();
    private LinkedList<Button> buttons = new LinkedList<>();

    public UIHandler() {


    }

//    public void update() {
//
//    }

    public void render(Graphics g) {
        for (MenuItem menuItem: menuItems) {
            if (menuItem.stateIs(Engine.currentState))
                menuItem.render(g);
        }

        for (Button button: buttons) {
            if (Engine.currentState == button.getRenderState())
                button.render(g);
        }
    }

    public void checkOverlap(int mx, int my) {
        for (Button button: buttons) {
            if (button.getRenderState() == Engine.currentState)
                if (button.mouseOverlap(mx, my))
                    Engine.setState(button.getTargetSate());
        }
    }

    public void addButton(int x, int y, int size, String text, GameState renderState, GameState targetState) {
        buttons.add(new Button(x, y, size, text, renderState, targetState));
    }

    public void addButton(int x, int y, int size, String text, GameState renderState, GameState targetState, Color borderColor, Color textColor) {
        buttons.add(new Button(x, y, size, text, renderState, targetState, borderColor, textColor));
    }

    public void addButton(int x, int y, int size, String text, GameState renderState, GameState targetState, Color borderColor, Color textColor, Font font) {
        buttons.add(new Button(x, y, size, text, renderState, targetState, borderColor, textColor, font));
    }

    public void addPanel(int x, int y, int width, int height, GameState state) {
        menuItems.add(new MenuItem(x, y, width, height, state));
    }

    public void addPanel(int x, int y, int width, int height, GameState state, GameState other) {
        menuItems.add(new MenuItem(x, y, width, height, state, other));
    }

    public void addPanel(int x, int y, int width, int height, GameState state, float transparency, Color color) {
        menuItems.add(new MenuItem(x, y, width, height, state, transparency, color));
    }

    public void addPanel(int x, int y, int width, int height, GameState state, GameState other, float transparency, Color color) {
        menuItems.add(new MenuItem(x, y, width, height, state, other, transparency, color));
    }

    public void addPanel(MenuItem menuItem) {
        menuItems.add(menuItem);
    }
}
