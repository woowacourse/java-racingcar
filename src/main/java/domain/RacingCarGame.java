package domain;

public class RacingCarGame {
    private final Cars cars;
    private final Count count;

    public RacingCarGame(Cars cars, Count count) {
        this.cars = cars;
        this.count = count;
    }

    public void race() {
        for (int i = 0; i < count.getValue(); i++) {
            cars.move();
        }
    }
}
