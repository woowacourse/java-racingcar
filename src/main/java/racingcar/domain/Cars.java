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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cars {

    private final static String DELIMITER = ",";

    private List<Car> cars;

    public Cars(String input) {
        List<Car> cars = new ArrayList<>();
        List<String> inputs = Arrays.asList(input.split(DELIMITER));
        for (String carName : inputs) {
            cars.add(new Car(carName, 0));
        }

        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }
}
