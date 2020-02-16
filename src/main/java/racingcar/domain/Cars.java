/*
 * Copyright (c) 2020 by 티거
 * All rights reserved.
 *
 * @author      티거
 * @version     1.0
 * @date        16 Feb 2020
 *
 */

package racingcar.domain;

import java.util.List;

public class Cars {
    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }
}
