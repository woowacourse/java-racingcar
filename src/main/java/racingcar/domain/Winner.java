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
    private static List<String> winnerNames = new ArrayList<>();
    private static int count;

    public static String getWinner(List<Car> cars) {
        count = 0;
        for (Car car : cars) {
            putWinnerNames(car);
        }
        return String.join(COMMA_SPACE, winnerNames);
    }

    private static void putWinnerNames(Car car) {
        int forwardCount = car.getForwardCount();
        String carName = car.getName();
        if (count == forwardCount) {
            winnerNames.add(carName);
        }
        if (count < forwardCount) {
            winnerNames.clear();
            count = forwardCount;
            winnerNames.add(carName);
        }
    }
}
