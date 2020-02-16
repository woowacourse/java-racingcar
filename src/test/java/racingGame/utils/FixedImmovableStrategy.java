package racingGame.utils;

public class FixedImmovableStrategy implements NumberGenerateStrategy {
    private static final int IMMOVABLE_NUMBER = 1;

    @Override
    public int generateNumber() {
        return IMMOVABLE_NUMBER;
    }
}
