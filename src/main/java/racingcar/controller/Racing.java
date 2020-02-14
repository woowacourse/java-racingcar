/*
 * Copyright (c) 2020 by 티거, 제이미
 * All rights reserved.
 *
 * @author      티거, 제이미
 * @version     1.0
 * @date        12 Feb 2020
 *
 */

package racingcar.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import racingcar.domain.Car;
import racingcar.domain.CarFactory;
import racingcar.domain.RacingResult;
import racingcar.domain.RacingResultFactory;
import racingcar.util.Director;

public class Racing {

    private final static int RANDOM_NUMBER_RANGE = 10;

    public static RacingResultFactory run(CarFactory carFactory, int tryCount) {
        RacingResultFactory racingResultFactory = new RacingResultFactory();
        for (int i = 0; i < tryCount; i++) {
            playRacing(carFactory.getCars(), racingResultFactory);
        }
        return racingResultFactory;
    }

    private static void playRacing(List<Car> cars, RacingResultFactory racingResultFactory) {
        LinkedHashMap<Car, Integer> racingResults = new LinkedHashMap<>();
        for (Car car : cars) {
            if (isForwardByRandom()) {
                car.forward();
            }
            racingResults.put(car, car.getPosition());
        }
        racingResultFactory.setResult(new RacingResult(racingResults));
    }

    private static boolean isForwardByRandom() {
        Random random = new Random();
        return Director.isForward(random.nextInt(RANDOM_NUMBER_RANGE));
    }
}
