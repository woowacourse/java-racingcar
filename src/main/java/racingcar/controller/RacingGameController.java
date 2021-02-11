package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;
import java.util.Scanner;

public class RacingGameController {
    public void play(final Scanner scanner) {
        final Cars carsInGame = getCarsInGame(scanner);
        final int trialNumber = getTrialNumber(scanner);

        playEveryTrial(carsInGame, trialNumber);
        announceWinner(carsInGame);
    }

    private Cars getCarsInGame(final Scanner scanner) {
        try {
            final String[] carNames = InputView.getUserCarInput(scanner);
            return makeCars(carNames);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return getCarsInGame(scanner);
        }
    }

    private Cars makeCars(final String[] carNames) {
        return new Cars(carNames);
    }

    private int getTrialNumber(final Scanner scanner) {
        return InputView.getUserTrialNumberInput(scanner);
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

    private void announceWinner(final Cars carsInGame) {
        OutputView.printWinner(carsInGame.getWinner());
    }
}
