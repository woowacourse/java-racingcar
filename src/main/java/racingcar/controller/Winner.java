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

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;

public class Winner {

    public static List<String> getWinners(Cars cars) {
        List<String> winners = new ArrayList<>();
        int maxPosition = cars.getMaxPosition();
        for (Car car : cars.getCars()) {
            if (car.isEqualPosition(maxPosition)) {
                winners.add(car.getName());
            }
        }
        return winners;
    }
}
