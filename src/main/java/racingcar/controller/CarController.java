package racingcar.controller;

import java.util.Random;
import racingcar.domain.AttemptNumber;
import racingcar.domain.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class CarController {
    private Cars cars;
    private AttemptNumber attemptNumber;

    public void play() {
        init();
        OutputView.printNextLine();
        OutputView.printExecutionResultMessage();
        Random random = new Random();
        for (int i = 0; i < attemptNumber.getAttemptNumber(); i++) {
            cars.move(random);
            OutputView.printCarStateMessage(cars);
        }
        OutputView.printWinnerCarNamesMessage(cars.getWinners());
    }

    private void init() {
        cars = Cars.createCars(InputView.getCarNames());
        OutputView.printInputAttemptNumberMessage();
        attemptNumber = new AttemptNumber(InputView.getAttemptNumber());
    }
}