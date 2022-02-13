package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.utils.NumberGenerator;

import static racingcar.view.InputView.*;
import static racingcar.view.OutputView.*;

public class RacingController {

    private final NumberGenerator numberGenerator;

    public RacingController(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public void play() {
        Cars cars = new Cars(getRightName());
        int trialCount = getRightNumber();

        printResultMessage();

        progressTurns(cars, trialCount);
        printMessage(cars.getWinners());
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
        for (int i = 0; i < trialCount; i++) {
            cars.moveCars(numberGenerator);
            printMessage(cars.toString());
        }
    }

}
