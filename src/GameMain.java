import Frames.MenuFrame;

import javax.swing.*;

public class GameMain {

    public static void main(String[] args) {
        MenuFrame frame = new MenuFrame("Frogger 2D");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
