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

    public static String getWinner(Cars cars) {
        count = 0;
        for (Car car : cars.getCars()) {
            putWinnerNames(car);
        }
        return String.join(COMMA_SPACE, winnerNames);
    }

    private static void putWinnerNames(Car car) {
        int position = car.getPosition();
        String carName = car.getName();

        if (count == position) {
            winnerNames.add(carName);
        }
        if (count < position) {
            winnerNames.clear();
            count = position;
            winnerNames.add(carName);
        }
    }
}
