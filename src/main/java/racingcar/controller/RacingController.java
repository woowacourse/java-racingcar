package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.RandomNumberGeneratorImpl;
import racingcar.util.Parser;
import racingcar.util.Validator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingController {
    private final InputView inputView;
    private final OutputView outputView;

    public RacingController(
            final InputView inputView,
            final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        final List<String> carNames = readCarNames();
        final Cars cars = new Cars(carNames);
        final int tryCount = readTryCount();

        outputView.printResultMsg();
        for(int i = 0 ; i < tryCount; i++) {
            moveCars(cars);
        }

        final List<Car> winners = cars.determineWinner();
        outputView.printWinners(winners);
        inputView.closeScanner();
    }

    private List<String> readCarNames() {
        try {
            String carNames = inputView.readCarNames();
            Validator.validateNullName(carNames);
            List<String> parsedCarNames = Parser.parseCarNames(carNames);
            Validator.validateCarNames(parsedCarNames);
            return parsedCarNames;
        } catch (IllegalArgumentException e) {
            outputView.printErrorMsg(e.getMessage());
            return readCarNames();
        }
    }

    private int readTryCount() {
        try {
            String tryCount = inputView.readTryCount();
            int parsedTryCount = Validator.validateInteger(tryCount);
            Validator.validateTryCount(parsedTryCount);
            return parsedTryCount;
        } catch (IllegalArgumentException e) {
            outputView.printErrorMsg(e.getMessage());
            return readTryCount();
        }
    }

    private void moveCars(final Cars cars) {
        cars.moveAllCars(new RandomNumberGeneratorImpl());
        outputView.printCarPosition(cars);
    }
}
