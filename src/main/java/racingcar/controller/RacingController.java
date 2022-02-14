package racingcar.controller;

import static racingcar.view.InputView.insertName;
import static racingcar.view.InputView.insertNumber;
import static racingcar.view.OutputView.printMessage;
import static racingcar.view.OutputView.printResultMessage;
import static racingcar.view.OutputView.printTurnResult;

import racingcar.domain.Cars;
import racingcar.domain.TrialCount;

public class RacingController {

    public void play() {
        try {
            Cars cars = new Cars(insertName());
            TrialCount trialCount = insertNumber();

            progressTurns(cars, trialCount);
            printMessage(cars.getWinners());
        } catch (IllegalArgumentException e) {
            printMessage(e.getMessage());
        }
    }

    private void progressTurns(Cars cars, TrialCount trialCount) {
        printResultMessage();

        for (int i = 0; i < trialCount.getTrialCount(); i++) {
            cars.moveCars();
            printTurnResult(cars);
        }
    }

}
