package domain;

public class MovementManager {
    private static final int MOVING_CONDITION = 4;

    public boolean isGo(int power) {
        return power >= MOVING_CONDITION;
    }

}
