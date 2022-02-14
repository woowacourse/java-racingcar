package racingcar.controller;

import static racingcar.view.InputView.insertName;
import static racingcar.view.InputView.insertNumber;
import static racingcar.view.OutputView.printMessage;
import static racingcar.view.OutputView.printResultMessage;
import static racingcar.view.OutputView.printTurnResult;
import static racingcar.view.OutputView.printWinners;

import racingcar.domain.Cars;
import racingcar.domain.TrialCount;
import racingcar.domain.Winners;
import racingcar.domain.movestrategy.RandomMoveStrategy;

public class RacingController {

    public void play() {
        try {
            Cars cars = new Cars(insertName(), new RandomMoveStrategy());
            TrialCount trialCount = insertNumber();

            progressTurns(cars, trialCount);
            printWinners(new Winners(cars));
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
