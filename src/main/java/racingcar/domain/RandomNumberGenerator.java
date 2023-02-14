package racingcar.domain;

public class RandomNumberGenerator implements NumberGenerator {
    private final int MINIMUM_NUMBER_OF_ENGINE;
    private final int MAXIMUM_NUMBER_OF_ENGINE;

    public RandomNumberGenerator(int MINIMUM_NUMBER_OF_ENGINE, int MAXIMUM_NUMBER_OF_ENGINE) {
        this.MINIMUM_NUMBER_OF_ENGINE = MINIMUM_NUMBER_OF_ENGINE;
        this.MAXIMUM_NUMBER_OF_ENGINE = MAXIMUM_NUMBER_OF_ENGINE;
    }

    @Override
    public int generate() {
        return (int) (Math.random() * (MAXIMUM_NUMBER_OF_ENGINE - MINIMUM_NUMBER_OF_ENGINE + 1))
                + MINIMUM_NUMBER_OF_ENGINE;
    }
}
