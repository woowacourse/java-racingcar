package domain;

public class RandomMovementGenerator {
    public static final int MOVABLE_CRITERION = 4;
    public static final int MIN_VALUE = 0;
    public static final int MAX_VALUE = 9;
    private final NumberGenerator randomNumberGenerator;

    public RandomMovementGenerator(NumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public boolean generate() {
        return randomNumberGenerator.generate(MIN_VALUE, MAX_VALUE) >= MOVABLE_CRITERION;
    }
}
