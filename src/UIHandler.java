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
            menuItem.render(g);
        }

        for (Button button: buttons) {
            button.render(g);
        }
    }

    public void addButton(int x, int y, int size, String text, GameState state) {
        buttons.add(new Button(x, y, size, text, state));
    }

    public void addButton(int x, int y, int size, String text, GameState state, Font font, Color borderColor, Color textColor) {
        buttons.add(new Button(x, y, size, text, state, font, borderColor, textColor));
    }

    public void addPanel(int x, int y, int width, int height, GameState state) {
        menuItems.add(new MenuItem(x, y, width, height, state));
    }

    public void addPanel(int x, int y, int width, int height, GameState state, float transparency, Color color) {
        menuItems.add(new MenuItem(x, y, width, height, state, transparency, color));
    }
}
