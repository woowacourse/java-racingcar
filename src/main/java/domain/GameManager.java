package domain;

public class GameManager {
    private final Cars cars;
    private final AttemptNumber attemptNumber;

    public GameManager(Cars cars, AttemptNumber attemptNumber) {
        this.cars = cars;
        this.attemptNumber = attemptNumber;
    }

    public void playGame() {
        int repeatCount = attemptNumber.getNumber();
        for (int count = 0; count < repeatCount; count++) {
            cars.moveCars();
        }
    }

    public Cars findWinners() {
        int maxPosition = cars.getMaxPosition();
        return new Cars(cars.findByPosition(maxPosition));
    }
}
