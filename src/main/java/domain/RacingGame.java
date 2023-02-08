package domain;

public class RacingGame {

    private static final int MOVABLE_MIN_NUMBER = 4;

    private NumberGenerator numberGenerator;
    private Cars cars;

    public RacingGame(NumberGenerator numberGenerator, Cars cars) {
        this.numberGenerator = numberGenerator;
        this.cars = cars;
    }

    public void playRound() {
        for (Car car : cars.getCars()) {
            isMovable(car);
        }
    }

    public Cars getCars() {
        return cars;
    }

    private void isMovable(Car car) {
        if (numberGenerator.generate() >= MOVABLE_MIN_NUMBER) {
            car.increasePosition();
        }
    }
}
