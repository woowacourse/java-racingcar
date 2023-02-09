package racingcar.domain;

public class RacingGame {

//    private static final int MOVABLE_MIN_NUMBER = 4;

//    private NumberGenerator numberGenerator;
    private Cars cars;

    public RacingGame(Cars cars) {
        this.cars = cars;
    }

    public void playRound() {
        for (Car car : cars.getCars()) {
            car.goForward();
        }
    }

    public Cars getCars() {
        return cars;
    }

//    private void isMovable(Car car) {
//        if (numberGenerator.generate() >= MOVABLE_MIN_NUMBER) {
//            car.increasePosition();
//        }
//    }
}
