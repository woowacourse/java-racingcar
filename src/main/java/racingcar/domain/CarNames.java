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

import java.util.Arrays;
import java.util.List;

public class CarNames {

    private final static String BLANK = " ";
    private final static String DELIMITER = ",";
    private final static int NAME_LENGTH_LIMIT = 5;
    private List<String> carNames;

    public CarNames(String input) {
        validateHasBlank(input);
        carNames = split(input);
    }

    private static void validateHasBlank(String input) {
        if (input.contains(BLANK)) {
            throw new IllegalArgumentException("공백은 허용되지 않습니다.");
        }
    }

    private static void validateNameLength(String input) {
        if (input.length() > NAME_LENGTH_LIMIT) {
            throw new IllegalArgumentException("5자 이상 이름은 허용되지 않습니다.");
        }
    }

    private static List<String> split(String input) {
        List<String> inputs = Arrays.asList(input.split(DELIMITER));
        for (String carName : inputs) {
            validateNameLength(carName);
        }
        return inputs;
    }

    public List<String> getCarNames() {
        return carNames;
    }
}
