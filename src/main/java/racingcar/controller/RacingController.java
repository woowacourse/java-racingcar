package racingcar.controller;

import static racingcar.view.InputView.insertRightName;
import static racingcar.view.InputView.insertRightNumber;
import static racingcar.view.OutputView.printMessage;
import static racingcar.view.OutputView.printResultMessage;

import racingcar.domain.Cars;

public class RacingController {

    public void play() {
        try {
            Cars cars = new Cars(insertRightName());
            int trialCount = getRightNumber();
            progressTurns(cars, trialCount);
            printMessage(cars.getWinners());
        } catch (IllegalArgumentException e) {
            printMessage(e.getMessage());
        }
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
        printResultMessage();
        for (int i = 0; i < trialCount; i++) {
            cars.moveCars();
            printMessage(cars.toString());
        }
    }

}
