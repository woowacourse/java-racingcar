package racingcar;

import static racingcar.Input.*;
import static racingcar.Output.*;

public class RacingController {

    public void play() {
        Cars cars = createCars();
        int trialCount = getRightNumber();
        printResultMessage();
        for (int i = 0; i < trialCount; i++) {
            cars.moveCars();
            printMessage(cars.toString());
        }
        printMessage(cars.getWinners());
    }

    private Cars createCars() {
        String[] carNames = getRightName();
        Cars cars = new Cars();
        for (String carName : carNames) {
            cars.addCar(new Car(carName));
        }
        return cars;
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
