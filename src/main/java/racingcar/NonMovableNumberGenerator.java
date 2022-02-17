package racingcar;

public class NonMovableNumberGenerator implements NumberGenerator {
    private static final int NON_MOVABLE_VALUE = 3;

    @Override
    public int generateNumber() {
        return NON_MOVABLE_VALUE;
    }
}
