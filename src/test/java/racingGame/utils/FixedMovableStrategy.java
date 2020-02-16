package racingGame.utils;

public class FixedMovableStrategy implements NumberGenerateStrategy {
    private static final int MOVABLE_NUMBER = 9;

    @Override
    public int generateNumber() {
        return MOVABLE_NUMBER;
    }
}
