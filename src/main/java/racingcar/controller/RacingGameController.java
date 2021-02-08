package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.view.OutputView;

import java.util.List;

public class RacingGameController {
    public void play(final Cars carsInGame, final int trialNumber) {
        OutputView.printOutputMessage();
        for (int i = 0; i < trialNumber; i++) {
            printSingleMoveResult(carsInGame.singleMove());
        }
        OutputView.printWinner(carsInGame.getWinner());
    }

    private void printSingleMoveResult(final List<Car> carsAfterSingleMove) {
        for (Car car : carsAfterSingleMove) {
            OutputView.printCarInformation(car.getName(), car.getDistance());
        }
        OutputView.printNewLine();
    }
}

