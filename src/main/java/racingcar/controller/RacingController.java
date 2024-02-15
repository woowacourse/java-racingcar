package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.util.Parser;
import racingcar.util.Validator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
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
            Validator.validateDuplicatedNames(parsedCarNames);
            return parsedCarNames;
        } catch (IllegalArgumentException e) {
            outputView.printErrorMsg(e.getMessage());
            return readCarNames();
        }
    }

    private Cars createCars(List<String> names) {
        Cars cars = new Cars();
        for(String name: names) {
            Validator.validateCarNamesFormat(name);
            cars.addCar(name);
        }
        return cars;
    }

    public void run() {
        List<String> parsedCarNames = readCarNames();
        Cars cars = createCars(parsedCarNames);

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
