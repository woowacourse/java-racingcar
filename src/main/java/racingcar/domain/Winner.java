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
        int maxNo = getMaxPosition(cars);
        findWinner(cars, maxNo);
        return String.join(COMMA_SPACE, winnerNames);
    }

    private static int getMaxPosition(Cars cars) {
        return cars.getCars().stream().mapToInt(Car::getPosition).max().getAsInt();
    }

    private static void findWinner(Cars cars, int maxNo) {
        cars.getCars().stream()
            .filter(t -> t.getPosition() == maxNo)
            .forEach(t -> winnerNames.add(t.getName()));
    }
}
