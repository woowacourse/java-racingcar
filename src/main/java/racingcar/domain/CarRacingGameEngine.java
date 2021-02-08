package racingcar.domain;

import racingcar.util.RandomUtils;

import java.util.List;

public class CarRacingGameEngine {

    private static final int MIN_RANDOM_VALUE = 0;
    private static final int MAX_RANDOM_VALUE = 9;

    public CarRacingGameEngine(List<Car> cars) {
        CarRepository.saveAll(cars);
    }

    public void race() {
        updateAllCarsPosition(CarRepository.cars());
    }

    private void updateAllCarsPosition(List<Car> cars) {
        for (Car car : cars) {
            goForwardOrStopRandomly(car);
        }
    }

    private void goForwardOrStopRandomly(Car car) {
        int randomNumber = RandomUtils
                .generateRandomNumber(MIN_RANDOM_VALUE, MAX_RANDOM_VALUE);

        if (GoForwardOrStop.isGoForward(randomNumber)) {
            car.goForward();
        }
    }
}
