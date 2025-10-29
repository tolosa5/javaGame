import javax.swing.*;
import java.awt.*;

public class GameWindow extends JPanel
{
    public JFrame jFrame;

    public GameWindow(GamePanel gamePanel)
    {
        jFrame = new JFrame();

        jFrame.setSize(400,400);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.add(gamePanel);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);



        jFrame.setResizable(false);
        jFrame.setLayout(null);
        jFrame.setFocusable(true);
    }
}
