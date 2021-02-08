package racingcar.controller;

import racingcar.domain.AttemptNumber;
import racingcar.domain.Cars;
import racingcar.domain.RandomValueGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class CarController {
    private Cars cars;
    private AttemptNumber attemptNumber;

    public void play() {
        init();
        OutputView.printNextLine();
        OutputView.printExecutionResultMessage();
        for (int i = 0; i < attemptNumber.getAttemptNumber(); i++) {
            cars.move(new RandomValueGenerator());
            OutputView.printCarStateMessage(cars);
        }
        OutputView.printWinnerCarNamesMessage(cars.getWinners());
    }


    private void init() {
        cars = Cars.createCars(InputView.getCarNames());
        attemptNumber = InputView.getAttemptNumber();
    }
}