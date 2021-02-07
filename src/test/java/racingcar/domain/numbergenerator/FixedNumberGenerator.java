package racingcar.domain.numbergenerator;


public class FixedNumberGenerator implements NumberGenerator {
    private final int FIXED_NUMBER;

    public FixedNumberGenerator(int FIXED_NUMBER) {
        this.FIXED_NUMBER = FIXED_NUMBER;
    }

    public int generate() {
        return FIXED_NUMBER;
    }
}
