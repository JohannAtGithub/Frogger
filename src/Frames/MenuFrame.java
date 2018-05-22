package Frames;

import Objects.FroggerGame;
import UI.CustomizedButtonUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class MenuFrame extends JFrame implements ActionListener {

    private JButton start;
    private JButton exit;
    private Image backgroundIMG;
    private int width;
    private int height;

    public MenuFrame(String title) {
        super(title);
        width = 660;
        height = 410;
        setSize(width, height);
        setLocationRelativeTo(null);
        setUndecorated(true);
        setResizable(false);
        setLayout(null);


        /*
         * Set the background but don't draw yet
         */
        try {
            this.backgroundIMG = ImageIO.read(new File("src/Textures/menu_background.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Border emptyBorder = BorderFactory.createEmptyBorder();

        /*
         * Set the game title and a shadow
         */
        int titleWidth = 270;
        int titleHeight = 55;
        int titleX = 24;
        int titleY = 30;
        int titleSize = 47;
        String fontNameTitle = "Ravie";

        JLabel gameTitle = new JLabel("Frogger");
        gameTitle.setBounds(0, 0, titleWidth, titleHeight);
        gameTitle.setFont(new Font(fontNameTitle, Font.BOLD, titleSize));
        gameTitle.setForeground(new Color(251,102,8));
        gameTitle.setLocation(titleX, titleY);
        add(gameTitle);

        JLabel gameTitleShadow = new JLabel("Frogger");
        gameTitleShadow.setBounds(0,0, titleWidth, titleHeight);
        gameTitleShadow.setFont(new Font(fontNameTitle, Font.BOLD, titleSize));
        gameTitleShadow.setForeground(new Color(68,71,140));
        gameTitleShadow.setBackground(Color.black);
        gameTitleShadow.setLocation(titleX + 4, titleY + 4);
        add(gameTitleShadow);

        /*
         * Set the buttons and style them
         */
        Color hoverColor = Color.black;
        Color normalColor = new Color(183,233,98);
        Color pressedColor = new Color(45,45,45);
        Color fontColor = new Color(251,102,8);
        String fontNameButtons = "Snap ITC";
        int fontSizeButtons = 25;
        int buttonPositionX = 75;
        int buttonPositionY = 135;
        int buttonWidth = 160;
        int buttonHeight = 40;
        int verticalDistance = 55;

        start = new JButton("Start");
        start.addActionListener(this);
        start.setBorder(emptyBorder);
        start.setUI(new CustomizedButtonUI(normalColor, hoverColor, pressedColor, new Font(fontNameButtons, Font.PLAIN, fontSizeButtons), fontColor));
        start.setBounds(buttonPositionX, buttonPositionY, buttonWidth, buttonHeight);
        add(start);

        exit = new JButton("Exit");
        exit.addActionListener(this);
        exit.setBorder(emptyBorder);
        exit.setUI(new CustomizedButtonUI(normalColor, hoverColor, pressedColor, new Font(fontNameButtons, Font.PLAIN, fontSizeButtons), fontColor));
        exit.setBounds(buttonPositionX, buttonPositionY + verticalDistance, buttonWidth, buttonHeight);
        add(exit);
        
        /*
         * Draw the background at latest
         * else the other labels aren't visible.
         */
        JLabel background = new JLabel(new ImageIcon(this.backgroundIMG));
        background.setBounds(28,getHeight() - 438, 400, 438);
        background.setBounds(0,0,width,height);
        add(background);
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == start) {
            new FroggerGame();
        } else if (e.getSource() == exit) {
            System.exit(0);
        }
    }
}
