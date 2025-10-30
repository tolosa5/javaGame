package Main;

import Inputs.KeyboardInputs;
import Inputs.MouseInputs;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

import static utils.Constants.PlayerConstants.*;

public class GamePanel extends JPanel
{
    private MouseInputs mouseInputs;
    private float xDelta = 100, yDelta = 100;
    private BufferedImage img, subImage;
    private BufferedImage[][] animations;
    private int animTick, animIndex, animSpeed = 18;
    private int playerAction = PlayerAnimations.IDLE.getIndex();

    public GamePanel()
    {
        mouseInputs = new MouseInputs(this);
        importImg();
        loadAnimations();

        setPanelSize();
        addKeyListener(new KeyboardInputs(this));
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
    }

    private void loadAnimations()
    {
        animations = new BufferedImage[14][10];

        for (int j = 0; j < animations.length; j++)
        {
            for (int i = 0; i < animations[j].length; i++)
            {
                animations[j][i] = img.getSubimage(i * 75, j * 48, 75, 48);
            }
        }
    }

    private void importImg()
    {
        //InputStream is = getClass().getResourceAsStream("/player_sprite.png");

        try
        {
            img = ImageIO.read(getClass().getResourceAsStream("/player_sprites.png"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    private void setPanelSize()
    {
        Dimension screenSize = new Dimension(1280, 800);
        setMinimumSize(screenSize);
        setPreferredSize(screenSize);
        setMaximumSize(screenSize);
    }

    public void changeXDelta(int value)
    {
        xDelta += value;
    }

    public void changeYDelta(int value)
    {
        yDelta += value;
    }

    private void updateAnimationTick()
    {
        animTick++;
        if (animTick >= animSpeed)
        {
            animTick = 0;
            animIndex++;
            if (animIndex >= GetSpriteAmount(playerAction))
                animIndex = 0;
        }
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        updateAnimationTick();
        g.drawImage(animations[playerAction][animIndex], (int)xDelta, (int)yDelta, 128, 80, null);
    }
}
