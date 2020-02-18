package domain;

public class GameManager {
    private final Cars cars;
    private final AttemptNumber attemptNumber;

    public GameManager(Cars cars, AttemptNumber attemptNumber) {
        this.cars = cars;
        this.attemptNumber = attemptNumber;
    }

    public RacingResults playGame() {
        if (attemptNumber.reduce())
            return cars.moveCars();
        return null;
    }

    public Cars findWinners() {
        int maxPosition = cars.getMaxPosition();
        return new Cars(cars.findByPosition(maxPosition));
    }

    public boolean isEnd() {
        return attemptNumber.isEnd();
    }
}
