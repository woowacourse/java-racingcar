/*
 * Copyright (c) 2020 by 티거, 제이미
 * All rights reserved.
 *
 * @author      티거, 제이미
 * @version     1.0
 * @date        12 Feb 2020
 *
 */

package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Racing {

    private final static String NEW_LINE = "\n";
    private final static int RANDOM_NUMBER_RANGE = 10;
    private final static String CAR_DELIMITER = " : ";
    private final static String CAR_PROGRESS_SIGN = "-";

    private final List<Car> cars;
    private final int tryCount;

    public Racing(List<String> carNames, int tryCount) {
        this.cars = setCars(carNames);
        this.tryCount = tryCount;
    }

    private List<Car> setCars(List<String> carNames) {
        List<Car> returnCars = new ArrayList<>();
        for (String carName : carNames) {
            returnCars.add(new Car(carName));
        }
        return returnCars;
    }

    public String run() {
        StringBuilder executionResult = new StringBuilder();
        for (int i = 0; i < tryCount; i++) {
            playRacing(executionResult);
        }
        return executionResult.toString();
    }

    private void playRacing(StringBuilder racingProgress) {
        racingProgress.append(NEW_LINE);
        for (Car car : cars) {
            if (isForwardByRandom()) {
                car.forward();
            }
            racingProgress.append(car.getProgress(CAR_DELIMITER, CAR_PROGRESS_SIGN));
        }
    }

    private boolean isForwardByRandom() {
        Random random = new Random();
        return Director.isForward(random.nextInt(RANDOM_NUMBER_RANGE));
    }

    public String getWinner(String delimiter) {
        Winner winner = new Winner(cars);
        return winner.getWinnerWithDelimiter(delimiter);
    }
}
