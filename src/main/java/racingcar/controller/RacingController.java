package racingcar.controller;

import static racingcar.view.InputView.insertName;
import static racingcar.view.InputView.insertNumber;
import static racingcar.view.OutputView.printErrorMessage;
import static racingcar.view.OutputView.printResultMessage;
import static racingcar.view.OutputView.printTurnResult;
import static racingcar.view.OutputView.printWinners;

import racingcar.domain.Cars;
import racingcar.domain.TrialCount;
import racingcar.domain.Winners;
import racingcar.domain.movestrategy.MovingStrategy;
import racingcar.domain.movestrategy.RandomMovingStrategy;

public class RacingController {

    public void play() {
        try {
            Cars cars = Cars.fromNames(insertName());
            TrialCount trialCount = new TrialCount(insertNumber());

            progressTurns(cars, trialCount, new RandomMovingStrategy());
            printWinners(new Winners(cars));
        } catch (IllegalArgumentException e) {
            printErrorMessage(e.getMessage());
        }
    }

    private void progressTurns(Cars cars, TrialCount trialCount, MovingStrategy movingStrategy) {
        printResultMessage();

        for (int i = 0; trialCount.canContinue(i); i++) {
            cars.moveCarsForward(movingStrategy);
            printTurnResult(cars);
        }
    }

}
