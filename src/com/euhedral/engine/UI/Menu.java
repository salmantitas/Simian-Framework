package com.euhedral.engine.UI;

import com.euhedral.engine.GameState;
import com.euhedral.engine.Utility;
import com.euhedral.game.ActionTag;
import com.euhedral.game.UI.MessageBox;
import com.euhedral.game.VariableManager;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

// Displays collection of Interactive and Non-Interactive Menu Items
// Each Menu is specific to a gameState
public class Menu {

    protected ActionTag action = null;
    private int index = 0; // for buttons
    private GameState state;
    protected LinkedList<MenuItem> menuItems = new LinkedList<>();

    protected Button[] options;
    protected int MAXBUTTON;

    protected ArrayList<MessageBox> messageBoxes;
    protected int activeMessageBoxes;

    // Title Variables

    protected int titleX = Utility.percWidth(9);
    protected int titleY = Utility.percHeight(20);
    protected int titleSize = Utility.percWidth(11.5);
    protected Color titleColor = Color.BLACK;

    protected int buttonSize = Utility.percWidth(5);
    protected int x0 = Utility.percWidth(5);
    protected int x2 = Utility.percWidth(40);
    protected int x3 = Utility.percWidth(45);
    protected int x4 = Utility.percWidth(50);
    protected int xFINAL = Utility.percWidth(75);
    protected int y0 = Utility.percHeight(30);
    protected int y1 = Utility.percHeight(40);
    protected int y2 = Utility.percHeight(50);
    protected int y3 = Utility.percHeight(60);
    protected int yFINAL = Utility.percHeight(70);

    public Menu(GameState state) {
        this.state = state;
        messageBoxes = new ArrayList<>();
        activeMessageBoxes = 0;
    }

    public void update() {

    }

    public void render(Graphics g) {
        for (MenuItem menuItem: menuItems) {
            menuItem.render(g);
        }

        for (int i = 0; i < MAXBUTTON; i++) {
            Button button = options[i];
            button.render(g);
        }
    }

    // UIItems here will be rendered on top of everything else
    protected void postRender(Graphics g) {
        /************
        * Game Code *
        *************/
    }

    /*
     * Selects the button over which the cursor is hovering.
     * Everything else is deselected.
     * */
    public void checkHover(int mx, int my) {
        for (int i = 0; i < messageBoxes.size(); i++) {
            MessageBox messageBox = messageBoxes.get(i);
            if (messageBox.mouseOverlap(mx, my)) {
                messageBox.checkHover(mx, my);
            }
        }
        if (activeMessageBoxes == 0) {
            for (int i = 0; i < MAXBUTTON; i++) {
                Button button = options[i];
                if (button.mouseOverlap(mx, my)) {
                    button.select();
                } else button.deselect();
            }
        }
    }

    /*
     * Checks whether the mouse has clicked on a button. If true, the button is activated.
     * */
    public void checkButtonAction(int mx, int my) {
        for (int i = 0; i < messageBoxes.size(); i++) {
            MessageBox messageBox = messageBoxes.get(i);
            if (messageBox.mouseOverlap(mx, my)) {
                if (messageBox.isEnabled()) {
                    messageBox.checkButtonAction(mx, my);
                    if (!messageBox.isEnabled())
                        activeMessageBoxes--;
                    // todo: else drag
                }
            }
        }
        for (int i = 0; i < MAXBUTTON; i++) {
            if (activeMessageBoxes == 0) {
                Button button = options[i];
                if (button.mouseOverlap(mx, my)) {
                    if (button.isEnabled()) {
                        activateButton(button);
                        break;
                    }
                }
            }
        }
    }

    /*
     * If the selected button is a navigation button, the GameState is changed. Otherwise, the ActionTag is applied.
     * */
    public void activateButton(Button button) {
        if (button instanceof ButtonNav) {
            button.activate();
        } else {
            ButtonAction actButton = (ButtonAction) button;
            this.action = actButton.getAction();
        }
    }

    /*
     * Activates the button that is selected
     * */
    public void chooseSelected() {
        activateButton(options[index]);
    }

    /*
     * Changes selected button by keypress
     * */
    public void keyboardSelection(char c) {
        if (activeMessageBoxes == 0) {
            if (c == 'r') {
                options[index].deselect();
                index = (index + 1) % MAXBUTTON;
                options[index].select();
            } else {
                options[index].deselect();
                index = (index - 1);
                if (index < 0) index = MAXBUTTON - 1;
                options[index].select();
            }
        }
    }

    public GameState getState() {
        return state;
    }

    public ActionTag getAction() {
        return action;
    }

    public int getActiveMessageBoxes() {
        return activeMessageBoxes;
    }

    public void keyPressed(int key) {

    }

    // todo: Experimental feature
    // Editor Feature
    // Save buttons' location
    protected void exportButtons() {
        List<List<Integer>> rows = new ArrayList<>();

        for (int i =0; i < MAXBUTTON; i++) {
            Button b = options[i];
            List<Integer> data = Arrays.asList(b.x, b.y);
            rows.add(data);
        }

        try {
            String filename = this.getClass().getSimpleName();
            FileWriter csvWriter = new FileWriter(filename + ".csv");

            for (List<Integer> data : rows) {
                for (Integer i : data) {

                    csvWriter.append(Integer.toString(i));
                    csvWriter.append(",");
                }
                csvWriter.append("\n");
            }

            csvWriter.flush();
            csvWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // todo: Experimental feature
    // Editor Feature
    // Load buttons' location
    protected void importButtons() throws IOException{
        String filename = this.getClass().getSimpleName();
        String pathString = filename + ".csv";

        List<Integer[]> rows = new ArrayList<>();
        Integer[] data = new Integer[2];

        // Code modified and implemented from:
        // https://stackabuse.com/reading-and-writing-csvs-in-java/

        File csvFile = new File(pathString);
        if (csvFile.isFile()) {
            BufferedReader csvReader = new BufferedReader(new FileReader(pathString));
            String row;

            // Assumes there's only one line to parse
            while ((row = csvReader.readLine()) != null) {
                String[] sData = row.split(",");
//                List<Integer> iData = Arrays.asList(Integer.parseInt(sData[0]), Integer.parseInt(sData[1]));
                Integer[] iData = new Integer[2];
                for (int i = 0; i < 2; i++) {
                    iData[i] = Integer.parseInt(sData[i]);
                }
                rows.add(iData);
            }
        }

        for (int i = 0; i < MAXBUTTON; i++) {
            Button b = options[i];
            b.x = rows.get(i)[0];
            b.y = rows.get(i)[1];
        }
    }

    /****************
     * UI Functions *
     ****************/

    public void addPanel(Panel panel) {
        menuItems.add(panel);
    }

    public void addPanel(int x, int y, int width, int height, GameState state) {
        menuItems.add(new Panel(x, y, width, height, state));
    }


    public void addPanel(int x, int y, int width, int height, GameState state, float transparency, Color color) {
        menuItems.add(new Panel(x, y, width, height, state, transparency, color));
    }

    public void addMessageBox(MessageBox messageBox) {
        messageBoxes.add(messageBox);
        activeMessageBoxes++;
    }
}
