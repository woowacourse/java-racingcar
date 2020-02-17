package racingcar.domain;

import racingcar.message.Message;

/*
 * Copyright (c) 2020 by 또링
 * All rights reserved.
 *
 * RandomNumber.java
 * RandomNumber 테스트
 *
 * @author      또링
 * @version     1.0
 * @date        16 Feb 2020
 *
 */
public class RandomNumber {
    private static final int MINIMUM_OF_NUMBER = 0;
    private static final int MAXIMUM_OF_NUMBER = 9;
    private final int number;

    public RandomNumber(int number) {
        if (isWrongRange(number)) {
            throw new IllegalArgumentException(Message.EXCEPTION_WRONG_RANGE_OF_RANDOM.getMessageText());
        }
        this.number = number;

    }

    private boolean isWrongRange(int number) {
        return (number < MINIMUM_OF_NUMBER) || (number > MAXIMUM_OF_NUMBER);
    }

    public int getNumber() {
        return number;
    }
}
