package domain;

public class RacingCarGame {
    private final Cars cars;
    private final Count count;

    private final RandomPowerGenerator randomPowerGenerator;

    public RacingCarGame(Cars cars, Count count, RandomPowerGenerator randomPowerGenerator) {
        this.cars = cars;
        this.count = count;
        this.randomPowerGenerator = randomPowerGenerator;
    }

    public void race() {
        for (int i = 0; i < count.getValue(); i++) {
            cars.move(randomPowerGenerator.generate());
        }
    }
}
