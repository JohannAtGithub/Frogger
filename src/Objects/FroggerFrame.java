package Objects;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class FroggerFrame extends JFrame {

    public FroggerFrame() {
        super("Frogger 2D");

        //Game should be able to close by ESC key
        InputMap im = getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap am = getRootPane().getActionMap();

        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "cancel");
        am.put("cancel", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        setResizable(false);
        setSize(FroggerPanel.WIDTH, FroggerPanel.HEIGHT);
        setLocationRelativeTo(null);
        setUndecorated(true);

        //create the window
        pack();

        //Create the panel
        FroggerPanel p = new FroggerPanel();

        //get the frames insets
        Insets frameInsets = getInsets();
        //calculate the panel size
        int frameWidth = p.getWidth() + (frameInsets.left + frameInsets.right);
        int frameHeight = p.getHeight() + (frameInsets.top + frameInsets.bottom);
        //set frame size
        setPreferredSize(new Dimension(frameWidth, frameHeight));
        //turn off the layout options
        setLayout(null);
        //add panel to the frame
        add(p);
        //adjust the window to meet its new preferred size
        pack();
        setVisible(true);
    }
}
