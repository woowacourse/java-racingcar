package racingcar.domain;

import racingcar.util.RandomUtils;
import racingcar.view.OutputView;

import java.util.List;

public class CarRacingGameEngine {

    private static final int MIN_RANDOM_VALUE = 0;
    private static final int MAX_RANDOM_VALUE = 9;

    private final int tryTime;

    public CarRacingGameEngine(List<Car> cars, int tryTime) {
        CarRepository.saveAll(cars);
        this.tryTime = tryTime;
    }

    public void race() {
        List<Car> cars = CarRepository.cars();

        OutputView.printRaceResult();

        for (int i = 0; i < tryTime; i++) {
            updateAllCarsPosition(cars);
            showAllCarsPosition(cars);
            OutputView.printNewLine();
        }

        OutputView.printWinner(CarRepository.winnerNames());
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

    private void showAllCarsPosition(List<Car> cars) {
        cars.forEach(car ->
                OutputView.printRaceResultEachCar(
                        car.getName(), car.getPosition()));
    }
}
