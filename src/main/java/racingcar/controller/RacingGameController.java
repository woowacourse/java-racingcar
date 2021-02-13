package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.utils.RandomNumberGeneratingStrategy;
import racingcar.view.InputView;
import racingcar.view.GameResultView;

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
        GameResultView.printResultPrefix();
        GameResultView.printCarsBeforeRace(cars);

        race();
    }

    private void race() {
        for (int i = 0; i < turns; i++) {
            cars.driveAll(new RandomNumberGeneratingStrategy());
            GameResultView.printCars(cars.getCars());
        }
    }

    private void showResult() {
        GameResultView.printWinners(cars.getWinners());
    }
}
