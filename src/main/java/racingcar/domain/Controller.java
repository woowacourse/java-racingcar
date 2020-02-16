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

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Controller {

    private final static String NEW_LINE = "\n";
    private final static int RANDOM_NUMBER_RANGE = 10;
    private final Cars cars;
    private final int tryCount;

    public Controller(List<Car> cars, int tryCount) {
        this.cars = new Cars(cars);
        this.tryCount = tryCount;
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
        for (Car car : cars.getCars()) {
            car.move(getRandomNo());
            racingProgress.append(car.toString());
        }
    }

    private int getRandomNo() {
        Random random = new Random();
        return random.nextInt(RANDOM_NUMBER_RANGE);
    }

    public String getWinner() {
        return Winner.getWinner(cars);
    }
}
