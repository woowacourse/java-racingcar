package racingcar.controller;

import static racingcar.view.InputView.insertName;
import static racingcar.view.InputView.insertNumber;
import static racingcar.view.OutputView.printMessage;
import static racingcar.view.OutputView.printResultMessage;

import racingcar.domain.Cars;

public class RacingController {

    public void play() {
        try {
            Cars cars = new Cars(insertName());
            int trialCount = insertNumber();

            progressTurns(cars, trialCount);
            printMessage(cars.getWinners());
        } catch (IllegalArgumentException e) {
            printMessage(e.getMessage());
        }
    }

    private void progressTurns(Cars cars, int trialCount) {
        printResultMessage();
        for (int i = 0; i < trialCount; i++) {
            cars.moveCars();
            printMessage(cars.toString());
        }
    }

}
