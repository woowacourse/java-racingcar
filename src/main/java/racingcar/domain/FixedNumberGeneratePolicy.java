package racingcar.domain;

public class FixedNumberGeneratePolicy implements NumberGeneratePolicy {
    public static final int FIXED_NUMBER = 4;

    @Override
    public int generateNumber() {
        return FIXED_NUMBER;
    }
}
