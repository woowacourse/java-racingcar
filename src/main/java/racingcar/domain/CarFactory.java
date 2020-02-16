/*
 * Copyright (c) 2020 by 티거, 제이미
 * All rights reserved.
 *
 * @author      티거, 제이미
 * @version     1.0
 * @date        11 Feb 2020
 *
 */

package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarFactory {

    private final static String DELIMITER = ",";

    public static List<Car> createCar(String input) {
        List<Car> cars = new ArrayList<>();
        List<String> inputs = Arrays.asList(input.split(DELIMITER));
        for (String carName : inputs) {
            cars.add(new Car(carName, 0));
        }
        return cars;
    }
}
