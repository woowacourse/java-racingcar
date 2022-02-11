package racingcar;

import static racingcar.Input.*;
import static racingcar.Output.*;

public class RacingController {

    public void play() {
        Cars cars = Cars.toCars(getRightName());
        int trialCount = getRightNumber();
        printResultMessage();
        for (int i = 0; i < trialCount; i++) {
            cars.moveCars();
            printMessage(cars.toString());
        }
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
}
