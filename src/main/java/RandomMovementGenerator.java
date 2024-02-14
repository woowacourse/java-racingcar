public class RandomMovementGenerator {
    private final RandomNumberGenerator randomNumberGenerator;

    public RandomMovementGenerator(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public boolean generate() {
        return randomNumberGenerator.generate() >= 4;
    }
}
