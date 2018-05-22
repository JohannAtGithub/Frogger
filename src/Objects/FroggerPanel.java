package Objects;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class FroggerPanel extends JPanel {

    public static final int WIDTH = 700, HEIGHT = 450;

    public FroggerPanel() {
        setSize(WIDTH, HEIGHT);
    }

    /*
     * Drawing the panel
     */
    public void paint(Graphics g) {
        int roadHeight = 199;
        int blackBarHeight = 100;
        int yellowStrapHeight = 4;
        int yellowStrapWidth = 70;

        //Set the background green
        g.setColor(Color.green);
        g.fillRect(0,0, getWidth(), getHeight());

        //set road curbs (white lines)
        g.setColor(Color.white);
        g.drawLine(0, 75, getWidth(), 75);
        g.drawLine(0, 275, getWidth(), 275);

        //draw the road
        g.setColor(Color.gray);
        g.fillRect(0,76, getWidth(), roadHeight);

        //draw the black bar to display lives and time
        g.setColor(Color.black);
        g.fillRect(0, getHeight() - blackBarHeight, getWidth(), blackBarHeight);

        //draw yellow straps
        g.setColor(Color.yellow);

        for (int y = 115; y < 275; y += 40) {
            for (int x = 15; x < WIDTH; x += 100) {
                g.fillRect(x, y, yellowStrapWidth, yellowStrapHeight);
            }
        }


        /*g.fillRect(15, 115, yellowStrapWidth, yellowStrapHeight);
        g.fillRect(115, 115, yellowStrapWidth, yellowStrapHeight);
        g.fillRect(215, 115, yellowStrapWidth, yellowStrapHeight);
        g.fillRect(315, 115, yellowStrapWidth, yellowStrapHeight);
        g.fillRect(415, 115, yellowStrapWidth, yellowStrapHeight);
        g.fillRect(515, 115, yellowStrapWidth, yellowStrapHeight);
        g.fillRect(615, 115, yellowStrapWidth, yellowStrapHeight);*/
    }

}
