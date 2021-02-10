package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.utils.RandomNumberGeneratingStrategy;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {

    private Cars cars;
    private int turns;

    public void startGame() {
        setUpGame();
        startRace();
        showResult();
    }

    private void setUpGame() {
        cars = Cars.from(InputView.getInputCarsName());
        turns = InputView.getInputTurns();
    }

    private void startRace() {
        OutputView.printResultPrefix();
        OutputView.printCarsBeforeRace(cars);

        race();
    }

    private void race() {
        for (int i = 0; i < turns; i++) {
            cars.driveAll(RandomNumberGeneratingStrategy.getInstance());
            OutputView.printCars(cars.getCars());
        }
    }

    private void showResult() {
        OutputView.printWinners(cars.getWinners());
    }
}
