package domain;

public class MovementManager {
    private static final Integer MOVING_CONDITION = 4;

    public boolean isGo(Integer power) {
        return power >= MOVING_CONDITION;
    }

}
