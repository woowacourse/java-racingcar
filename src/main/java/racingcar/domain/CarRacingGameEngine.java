package racingcar.domain;

import racingcar.domain.car.Car;
import racingcar.util.RandomUtils;

import java.util.List;

public class CarRacingGameEngine {

    private static final int MIN_RANDOM_VALUE = 0;
    private static final int MAX_RANDOM_VALUE = 9;

    private final CarRepository carRepository;

    public CarRacingGameEngine(List<Car> cars) {
        carRepository = new CarRepository(cars);
    }

    public void race() {
        updateAllCarsPosition(carRepository.cars());
    }

    public List<Car> cars() {
        return carRepository.cars();
    }

    public List<String> winnerNames() {
        return carRepository.winnerNames();
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
