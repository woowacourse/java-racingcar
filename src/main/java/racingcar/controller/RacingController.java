package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.RandomNumberImpl;
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
        cars.moveAllCars(new RandomNumberImpl());
        outputView.printCarPosition(cars);
    }

    public void run() {
        List<String> carNames = readCarNames();
        Cars cars = new Cars(carNames);
        int tryCount = readTryCount();

        outputView.printResultMsg();
        for(int i = 0 ; i < tryCount; i++) {
            moveCars(cars);
        }

        List<Car> winners = cars.determineWinner();
        outputView.printWinners(winners);
    }
}
