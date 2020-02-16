package racingGame.utils;

public class MovableNumberGenerator implements NumberGenerator {
    private static final int MOVABLE_NUMBER = 9;

    @Override
    public int generateNumber() {
        return MOVABLE_NUMBER;
    }
}
