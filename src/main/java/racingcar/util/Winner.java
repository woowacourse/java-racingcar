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

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.CarFactory;

public class Winner {

    public static List<String> getWinners(CarFactory carFactory) {
        List<String> winners = new ArrayList<>();
        int maxPosition = carFactory.getMaxPosition();
        for (Car car : carFactory.getCars()) {
            if (car.isEqualPosition(maxPosition)) {
                winners.add(car.getName());
            }
        }
        return winners;
    }
}
