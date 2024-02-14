package domain;

public class PowerGenerator {
    private final RandomNumberGenerator randomNumberGenerator;

    public PowerGenerator(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }
    public Power generatePower() {
        return Power.from(randomNumberGenerator.generate());
    }
}
