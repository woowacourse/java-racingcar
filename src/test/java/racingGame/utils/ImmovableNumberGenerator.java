package racingGame.utils;

public class ImmovableNumberGenerator implements NumberGenerator {
    private static final int IMMOVABLE_NUMBER = 1;

    @Override
    public int generateNumber() {
        return IMMOVABLE_NUMBER;
    }
}
