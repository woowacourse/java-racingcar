package domain;

public class RandomMovementGenerator {
    public static final int MOVABLE_CRITERION = 4;
    private final RandomNumberGenerator randomNumberGenerator;

    public RandomMovementGenerator(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public boolean generate() {
        return randomNumberGenerator.generate() >= MOVABLE_CRITERION;
    }
}
