package racingGame.controller;

import racingGame.domain.Cars;
import racingGame.domain.MovementNumber;
import racingGame.utils.CarFactory;
import racingGame.view.InputView;
import racingGame.view.OutputView;

public class RacingGame {
    public void run() {
        Cars cars = generateCars();
        final int movementNumber = generateMovementNumber().toInteger();

        for (int i = 0; i < movementNumber; i++) {
            cars.moveCars();
            OutputView.printCars(cars);
        }
        cars.updateMaximumPosition();
        OutputView.printWinners(cars.getWinnersList());
    }

    private Cars generateCars() {
        try {
            return new Cars(CarFactory.createByNames(InputView.getCarName()));
        } catch (IllegalArgumentException e) {
            return generateCars();
        }
    }

    private MovementNumber generateMovementNumber() {
        try {
            return new MovementNumber(InputView.getMovementNumber());
        } catch (IllegalArgumentException e) {
            return generateMovementNumber();
        }
    }
}
