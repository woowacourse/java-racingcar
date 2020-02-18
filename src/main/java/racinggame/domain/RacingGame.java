package racinggame.domain;

public class RacingGame {
    public static final int NUMBER_BOUND = 10;
    private Cars cars;

    public RacingGame(Cars cars) {
        this.cars = cars;
    }

    public int moveCars(Strategy randomGenerator) {
        int maxPosition = 0;
        for (Car car : cars) {
            if (car.move(randomGenerator)) {
                maxPosition = car.getMaxPosition(maxPosition);
            }
        }
        return maxPosition;
    }
}
