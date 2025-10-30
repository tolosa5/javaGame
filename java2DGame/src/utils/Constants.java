package utils;

import static utils.Constants.PlayerConstants.PlayerAnimations.*;

public class Constants
{
    public static class PlayerConstants
    {
        public enum PlayerAnimations
        {
            THROW (0),
            LAY (1),
            CROUCH (2),
            IDLE (3),
            IDLE_WEAPON (4),
            RUNNING_WEAPON (5),
            RUNNING (6),
            CLIMB (7),
            HIT (8),
            JUMP_WEAPON (9),
            SHOOT (10),
            CROUCH_WEAPON (11),
            SHOOT_CROUCH (12),
            JUMP (13);

            private final int index;

            PlayerAnimations(int i)
            {
                this.index = i;
            }

            public int getIndex() { return index; }
        }

        public static int GetSpriteAmount(int player_action)
        {
            return switch (player_action)
            {
                case RUNNING, RUNNING_WEAPON -> 10;
                case IDLE, IDLE_WEAPON -> 4;
                case JUMP_WEAPON -> 5;
                case JUMP, LAY, CLIMB -> 6;
                case CROUCH, CROUCH_WEAPON, HIT -> 3;
                case SHOOT, SHOOT_CROUCH -> 2;
                case THROW -> 8;
                default -> 1;
            };
        }
    }
}
