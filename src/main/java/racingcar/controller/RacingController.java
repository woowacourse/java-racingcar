package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Cars;
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

    public void run() {
        String carNames = inputView.readCarNames();
        Validator.validateNullName(carNames);
        List<String> parsedCarNames = Parser.parseCarNames(carNames);
        Validator.validateDuplicatedNames(parsedCarNames);

        Cars cars = new Cars();
        for(String name: parsedCarNames) {
            Validator.validateCarNamesFormat(name);
            cars.addCar(name);
        }

        String tryCount = inputView.readTryCount();
        int parsedTryCount = Validator.validateInteger(tryCount);
        Validator.validateTryCount(parsedTryCount);

        outputView.printResultMsg();
        for(int i = 0 ; i < parsedTryCount; i++) {
            moveCars(cars);
        }

        List<Car> winners = cars.determineWinner();
        outputView.printWinners(winners);
    }

    private void moveCars(final Cars cars) {
        cars.moveAllCars();
        outputView.printCarPosition(cars);
    }
}
