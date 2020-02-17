/*
 * Copyright (c) 2020 by 티거, 제이미
 * All rights reserved.
 *
 * @author      티거, 제이미
 * @version     1.0
 * @date        18 Feb 2020
 *
 */

package racingcar.domain;

import java.util.Random;

public class RandomNumber {
    private final static int RANDOM_NUMBER_RANGE = 10;

    public static int getRandomNo() {
        Random random = new Random();
        return random.nextInt(RANDOM_NUMBER_RANGE);
    }
}
