/*
 * Copyright (c) 2020 by 티거, 제이미
 * All rights reserved.
 *
 * @author      티거, 제이미
 * @version     1.0
 * @date        12 Feb 2020
 *
 */

package racingcar.util;

import java.util.List;
import java.util.Random;
import racingcar.domain.Car;

public class Racing {

    private final static String NEW_LINE = "\n";
    private final static int RANDOM_NUMBER_RANGE = 10;
    private final static String CAR_DELIMITER = " : ";
    private final static String CAR_PROGRESS_SIGN = "-";

    public static StringBuilder run(List<Car> cars, int tryCount) {
        StringBuilder racingProgress = new StringBuilder();
        for (int i = 0; i < tryCount; i++) {
            playRacing(cars, racingProgress);
        }
        return racingProgress;
    }

    private static void playRacing(List<Car> cars, StringBuilder racingProgress) {
        racingProgress.append(NEW_LINE);
        for (Car car : cars) {
            if (isForwardByRandom()) {
                car.forward();
            }
            racingProgress.append(car.getProgress(CAR_DELIMITER, CAR_PROGRESS_SIGN));
        }
    }

    private static boolean isForwardByRandom() {
        Random random = new Random();
        return Director.isForward(random.nextInt(RANDOM_NUMBER_RANGE));
    }
}
