package Main;

import Inputs.KeyboardInputs;
import Inputs.MouseInputs;
import utils.Constants;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel
{
    private MouseInputs mouseInputs;
    private Game game;

    public GamePanel(Game game)
    {
        mouseInputs = new MouseInputs(this);
        this.game = game;

        setPanelSize();
        addKeyListener(new KeyboardInputs(this));
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
    }

    private void setPanelSize()
    {
        Dimension screenSize = new Dimension(1280, 800);
        setPreferredSize(screenSize);
    }

    public void updateGame()
    {

    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        game.render(g);
    }

    public Game getGame()
    {
        return game;
    }
}
