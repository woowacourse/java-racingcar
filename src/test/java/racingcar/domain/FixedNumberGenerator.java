package racingcar.domain;


public class FixedNumberGenerator implements NumberGenerator {
    private final int FIXED_NUMBER = 5;

    public int generate() {
        return FIXED_NUMBER;
    }
}
