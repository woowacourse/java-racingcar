
package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;
import java.util.Scanner;

public class RacingGameController {
    public void play(Scanner scanner) {
        final Cars carsInGame = InputView.getUserCarInput(scanner);
        final int trialNumber = InputView.getUserTrialNumberInput(scanner);

        playEveryTrial(carsInGame, trialNumber);
        announceWinner(carsInGame);
    }

    private void playEveryTrial(final Cars carsInGame, final int trialNumber) {
        OutputView.printOutputMessage();
        for (int i = 0; i < trialNumber; i++) {
            playSingleTrial(carsInGame.singleTrial());
        }
    }

    private void playSingleTrial(final List<Car> carsAfterSingleTrial) {
        for (Car car : carsAfterSingleTrial) {
            OutputView.printCarInformation(car.getName(), car.getDistance());
        }
        OutputView.printNewLine();
    }

    private void announceWinner(Cars carsInGame) {
        OutputView.printWinner(carsInGame.getWinner());
    }
}
