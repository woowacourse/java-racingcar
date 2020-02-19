package domain;

public class GameManager {
    private static final String OVER_ATTEPT_NUMBER_MESSAGE = "시도 횟수를 초과했습니다.";

    private final Cars cars;
    private final AttemptNumber attemptNumber;

    public GameManager(Cars cars, AttemptNumber attemptNumber) {
        this.cars = cars;
        this.attemptNumber = attemptNumber;
    }

    public RacingResults playGame() {
        if (attemptNumber.reduce())
            return cars.moveCars();
        throw new IllegalArgumentException(OVER_ATTEPT_NUMBER_MESSAGE);
    }

    public Cars findWinners() {
        int maxPosition = cars.getMaxPosition();
        return new Cars(cars.findByPosition(maxPosition));
    }

    public boolean isEnd() {
        return attemptNumber.isEnd();
    }
}
