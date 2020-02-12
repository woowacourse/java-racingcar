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

public class Director {

    private final static int BASE_NUMBER = 4;

    public static boolean isForward(int number) {
        return number >= BASE_NUMBER;
    }
}
