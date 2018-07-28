import java.awt.*;

public class Button {
    private int x, y, size, width, height;
    private String text;
    private Font font;
    private GameState state;
    private Color borderColor, textColor;


    public Button(int x, int y, int size, String text, GameState state) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.text = text;
        this.state = state;
        font = new Font("arial", 1, size);
        borderColor = Color.BLUE;
        textColor = Color.RED;
    }

    public Button(int x, int y, int size, String text, GameState state, Font font, Color borderColor, Color textColor) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.text = text;
        this.state = state;
        this.font = font;
        this.borderColor = borderColor;
        this.textColor = textColor;
    }

    public void render(Graphics g) {
        g.setFont(font);
        width = (g.getFontMetrics().stringWidth(text)) * 3 / 2;
        height = width / 2;

        g.setColor(Color.BLUE);
        g.drawRect(x, y, width, height);

        g.setColor(Color.RED);
        g.drawString(text, x + width / 6, y + height * 2 / 3);
    }

    public boolean mouseOverlap(int mx, int my) {
        return (mx >= x && mx <= x + width && my >= y && my <= y + height);
    }

    public GameState getState() {
        return state;
    }

    public void setText(String text) {
        this.text = text;
    }
}
