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

    public static String getWinner(List<Car> cars) {
        int count = 0;
        List<String> name = new ArrayList<>();
        for (Car car : cars) {
            if (count == car.getForwardCount()) {
                name.add(car.getName());
            }
            if (count < car.getForwardCount()) {
                name.clear();
                count = car.getForwardCount();
                name.add(car.getName());
            }
        }
        return String.join(", ", name);
    }
}
