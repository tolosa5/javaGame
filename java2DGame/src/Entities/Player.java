package Entities;

import utils.Constants;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import static utils.Constants.Directions.*;
import static utils.Constants.Directions.RIGHT;
import static utils.Constants.PlayerConstants.GetSpriteAmount;

public class Player extends Entity
{
    private BufferedImage[][] animations;
    private int animTick, animIndex, animSpeed = 20;
    private int playerAction = Constants.PlayerConstants.PlayerAnimations.IDLE.getIndex();
    private int playerDir = -1;
    private boolean left, up, right, down;
    private boolean isMoving = false, isAttacking = false;

    private int speed = 2;

    public Player(float x, float y)
    {
        super(x, y);
        loadAnimations();
    }

    public void update()
    {
        updateAnimationTick();
        updatePos();
        setAnimation();
    }
    public void render(Graphics g)
    {
        g.drawImage(animations[playerAction][animIndex], (int)x, (int)y, 128, 80, null);
    }

    private void updateAnimationTick()
    {
        animTick++;
        if (animTick >= animSpeed)
        {
            animTick = 0;
            animIndex++;
            if (animIndex >= GetSpriteAmount(playerAction))
            {
                animIndex = 0;
                isAttacking = false;
            }
        }
    }

    private void setAnimation()
    {
        int startAnim = playerAction;

        if (isMoving)
            playerAction = Constants.PlayerConstants.PlayerAnimations.RUNNING_WEAPON.getIndex();
        else
            playerAction = Constants.PlayerConstants.PlayerAnimations.IDLE.getIndex();

        if (isAttacking)
            playerAction = Constants.PlayerConstants.PlayerAnimations.SHOOT.getIndex();

        if (startAnim != playerAction)
            resetAnim();
    }

    private void resetAnim()
    {
        animTick = 0;
        animIndex = 0;
    }

    private void updatePos()
    {
        isMoving = false;

        if (left && !right)
        {
            x -= speed;
            isMoving = true;
        }
        else if (!left && right)
        {
            x += speed;
            isMoving = true;
        }

        if (down && !up)
        {
            y += speed;
            isMoving = true;
        }
        else if (!down && up)
        {
            y -= speed;
            isMoving = true;
        }
    }

    private void loadAnimations()
    {
        InputStream is = getClass().getResourceAsStream("/player_sprites.png");

        try
        {
            BufferedImage img = ImageIO.read(is);

            animations = new BufferedImage[14][10];
            for (int j = 0; j < animations.length; j++)
            {
                for (int i = 0; i < animations[j].length; i++)
                {
                    animations[j][i] = img.getSubimage(i * 75, j * 48, 75, 48);
                }
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void resetDirBooleans()
    {
        left = false;
        right = false;
        up = false;
        down = false;
    }

    //region Getters and Setters

    public boolean isAttacking() {
        return isAttacking;
    }

    public void setAttacking(boolean attacking) {
        isAttacking = attacking;
    }


    public boolean isLeft() {
        return left;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public boolean isUp() {
        return up;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public boolean isRight() {
        return right;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    public boolean isDown() {
        return down;
    }

    public void setDown(boolean down) {
        this.down = down;
    }

    //endregion


/*
    public void changeXDelta(int value)
    {
        x += value;
    }

    public void changeYDelta(int value)
    {
        y += value;
    }
    */
}
