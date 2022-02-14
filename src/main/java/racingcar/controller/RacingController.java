package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.utils.NumberGenerator;
import racingcar.utils.RandomNumberGenerator;

import static racingcar.view.InputView.*;
import static racingcar.view.OutputView.*;

public class RacingController {

    public void play() {
        Cars cars = new Cars(getRightName());
        int trialCount = getRightNumber();

        printResultMessage();

        progressTurns(cars, trialCount);
        printWinners(cars);
    }

    private String[] getRightName() {
        try {
            return insertRightName();
        } catch (IllegalArgumentException e) {
            printMessage(e.getMessage());
            return getRightName();
        }
    }

    private int getRightNumber() {
        try {
            return insertRightNumber();
        } catch (IllegalArgumentException e) {
            printMessage(e.getMessage());
            return getRightNumber();
        }
    }

    private void progressTurns(Cars cars, int trialCount) {
        NumberGenerator numberGenerator = new RandomNumberGenerator();
        for (int i = 0; i < trialCount; i++) {
            cars.moveCars(numberGenerator);
            printCars(cars);
        }
    }

}
