package racingcar;

public class MovableNumberGenerator implements NumberGenerator {
    private static final int MOVABLE_VALUE = 4;

    @Override
    public int generateNumber() {
        return MOVABLE_VALUE;
    }
}
