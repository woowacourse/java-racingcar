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

public class Winner {

    private static int maxCount = 0;

    public static String getWinnerWithDelimiter(List<Car> cars, String delimiter) {
        maxCount = 0;
        List<String> winnerNames = setWinner(cars);
        return String.join(delimiter, winnerNames);
    }

    private static List<String> setWinner(List<Car> cars) {
        List<String> winnerNames = new ArrayList<>();
        for (Car car : cars) {
            putWinnerNames(winnerNames, car.getName(), car.getForwardCount());
        }
        return winnerNames;
    }

    private static void putWinnerNames(List<String> winnerNames, String carName, int carForwardCount) {
        if (maxCount == carForwardCount) {
            winnerNames.add(carName);
        }
        if (maxCount < carForwardCount) {
            maxCount = carForwardCount;
            winnerNames.clear();
            winnerNames.add(carName);
        }
    }
}
