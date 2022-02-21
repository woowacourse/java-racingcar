package racingcar.util;

public class RacingCarMovableStrategy implements MovableStrategy {
    private static final int MIN_VALUE = 0;
    private static final int MAX_VALUE = 9;
    private static final int MOVABLE_STANDARD = 4;

    @Override
    public boolean isMovable() {
        return ((int)(Math.random() * (MAX_VALUE - MIN_VALUE + 1)) + MIN_VALUE) >= MOVABLE_STANDARD;
    }
}
