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
            putWinnerNames(car.getName(), car.getPosition());
        }
        return String.join(COMMA_SPACE, winnerNames);
    }

    private static void putWinnerNames(String carName, int position) {
        setCountAndWinnerNames(position);
        addCarName(carName, position);
    }

    private static void setCountAndWinnerNames(int position) {
        if (count < position) {
            count = position;
            winnerNames.clear();
        }
    }

    private static void addCarName(String carName, int position) {
        if (count <= position) {
            winnerNames.add(carName);
        }
    }
}
