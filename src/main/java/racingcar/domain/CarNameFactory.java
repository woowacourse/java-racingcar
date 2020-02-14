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

public class CarNameFactory {

    private final static String DELIMITER = ",";

    private final List<CarName> carNames;

    public CarNameFactory(String input) throws IllegalArgumentException {
        carNames = split(input);
    }

    private static List<CarName> split(String input) {
        List<String> inputs = Arrays.asList(input.split(DELIMITER));
        List<CarName> carNames = new ArrayList<>();
        for (String carName : inputs) {
            carNames.add(new CarName(carName));
        }
        return carNames;
    }

    public List<CarName> getCarNames() {
        return carNames;
    }
}
