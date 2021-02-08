package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.view.OutputView;

import java.util.List;

public class RacingGameController {
    public void play(final Cars carsInGame, final int trialNumber) {
        OutputView.printOutputMessage();
        for (int i = 0; i < trialNumber; i++) {
            printSingleTrialResult(carsInGame.singleTrial());
        }
        OutputView.printWinner(carsInGame.getWinner());
    }

    private void printSingleTrialResult(final List<Car> carsAfterSingleTrial) {
        for (Car car : carsAfterSingleTrial) {
            OutputView.printCarInformation(car.getName(), car.getDistance());
        }
        OutputView.printNewLine();
    }
}

