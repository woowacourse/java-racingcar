package racingcar.controller;

import racingcar.domain.Car.Car;
import racingcar.domain.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingGameController {

    private final InputView inputView;
    private Cars cars;
    private Integer turns;

    public RacingGameController() {
        inputView = new InputView();
    }

    public void race() {
        setUpRace();
        startRace();
        showResult();
    }

    private void setUpRace() {
        cars = Cars.from(inputView.getInputCarsName());
        turns = inputView.getInputTurns();
    }

    private void startRace() {
        OutputView.printResultPrefix();
        OutputView.printCarsStatus(cars.getCars());
        for (int i = 0; i < turns; i++) {
            List<Car> afterDriveCars = cars.getCarsAfterDrive();
            OutputView.printCarsStatus(afterDriveCars);
        }
    }

    private void showResult() {
        OutputView.printWinners(cars.getWinners());
    }
}