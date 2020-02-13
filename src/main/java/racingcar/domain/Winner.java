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

public class Winner {

    private final static String COMMA_SPACE = ", ";

    private final List<String> winnerNames;
    private int maxCount = 0;

    Winner(List<Car> cars) {
        winnerNames = setWinner(cars);
    }

    private List<String> setWinner(List<Car> cars) {
        List<String> winnerNames = new ArrayList<>();
        for (Car car : cars) {
            putWinnerNames(winnerNames, car.getName(), car.getForwardCount());
        }
        return winnerNames;
    }

    private void putWinnerNames(List<String> winnerNames, String carName, int carForwardCount) {
        if (maxCount == carForwardCount) {
            winnerNames.add(carName);
        }
        if (maxCount < carForwardCount) {
            maxCount = carForwardCount;
            winnerNames.clear();
            winnerNames.add(carName);
        }
    }

    @Override
    public String toString() {
        return String.join(COMMA_SPACE, winnerNames);
    }
}
