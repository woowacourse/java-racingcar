package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.util.RandomGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class GameManager {

    private static final int MAX_RANDOM_NUMBER = 9;
    private static final int MINIMUM_MOVEMENT_CONDITION = 4;

    OutputView outputView = new OutputView();
    InputView inputView = new InputView();

    public void run() {
        outputView.printCarNameInputMessage();
        List<String> carNames = inputView.getCarName();
        Cars cars = makeNewCars(carNames);
        outputView.printTryCountInputMessage();
        int tryCount = inputView.getTryCount();
        outputView.printTryResultMenu();
        for (int i = 0; i < tryCount; i++) {
            moveCars(cars);
            outputView.printTryResult(cars);
        }
        outputView.printWinners(cars);
    }

    private void moveCars(Cars cars) {
        for (Car car : cars.getCars()) {
            moveCar(car);
        }
    }

    private void moveCar(Car car) {
        if (RandomGenerator.generateRandomNumber(MAX_RANDOM_NUMBER + 1) >= MINIMUM_MOVEMENT_CONDITION) {
            car.moveCar();
        }
    }

    private Cars makeNewCars(List<String> carNames) {
        return new Cars(carNames.stream()
                .map(Car::new)
                .toList());
    }
}
