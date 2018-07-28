import java.awt.*;

public class MenuItem {

    int x, y, width, height;
    float transparency;
    Color color;
    GameState state;

    public MenuItem(int x, int y, int width, int height, GameState state) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.state = state;
        transparency = 0.7f;
        color = Color.GRAY;
    }

    public MenuItem(int x, int y, int width, int height, GameState state, float transparency, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.state = state;
        this.transparency = transparency;
        this.color = color;
    }

    public void render(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setComposite(makeTransparent(transparency));

        g.setColor(color);
        g.fillRect(x, y, width, height);

        // Ensure that nothing on top of the transparent panel is rendered transparent
        g2d.setComposite(makeTransparent(1));
    }

    // Not very sure what's happening here
    private AlphaComposite makeTransparent(float alpha) {
        int type = AlphaComposite.SRC_OVER;
        return(AlphaComposite.getInstance(type, alpha));
    }
}
