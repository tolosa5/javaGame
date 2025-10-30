package utils;

public class Constants
{
    public static class PlayerConstants
    {
        public static final int THROW = 0;
        public static final int LAY = 1;
        public static final int CROUCH = 2;
        public static final int IDLE = 4;
        public static final int RUNNING = 5;
        public static final int HIT = 9;
        public static final int JUMP = 10;
        public static final int ATTACK_1 = 11;
        public static final int ATTACK_CROUCH = 13;

        public static int GetSpriteAmount(int player_action)
        {
            return switch (player_action)
            {
                case RUNNING -> 10;
                case IDLE -> 4;
                case JUMP, LAY -> 6;
                case CROUCH, HIT -> 3;
                case ATTACK_1, ATTACK_CROUCH -> 2;
                case THROW -> 8;
                default -> 1;
            };
        }
    }
}
