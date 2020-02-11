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

public class Inputs {

    private final static String BLANK = " ";
    private final static String DELIMITER = ",";
    private static List<String> inputs;

    public Inputs(String input) throws Exception {
        blank(input);
        inputs = split(input);
    }

    private static void blank(String input) {
        if (input.contains(BLANK)) {
            throw new IllegalArgumentException("공백은 허용되지 않았습니다.");
        }
    }

    private static List<String> split(String input) {
        return Arrays.asList(input.split(DELIMITER));
    }

    public static List<String> getInputs() {
        return inputs;
    }
}
