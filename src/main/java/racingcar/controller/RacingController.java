package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.MovementDecider;
import racingcar.domain.RandomMovementDecider;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingController {
    private final InputView inputView;
    private final OutputView outputView;

    public RacingController(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        final Cars cars = createCars();
        final int tryCount = readTryCount();

        outputView.printResultMsg();
        MovementDecider movementDecider = new RandomMovementDecider();
        for(int i = 0 ; i < tryCount; i++) {
            moveCars(cars, movementDecider);
        }

        final List<Car> winners = cars.determineWinner();
        outputView.printWinners(winners);
        inputView.closeScanner();
    }

    private Cars createCars() {
        try {
            List<String> carNames = inputView.readCarNames();
            return new Cars(carNames);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMsg(e.getMessage());
            return createCars();
        }
    }

    private int readTryCount() {
        try {
            return inputView.readTryCount();
        } catch (IllegalArgumentException e) {
            outputView.printErrorMsg(e.getMessage());
            return readTryCount();
        }
    }

    private void moveCars(final Cars cars, final MovementDecider movementDecider) {
        cars.moveAll(movementDecider);
        outputView.printCarPosition(cars);
    }
}
