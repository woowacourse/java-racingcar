package racingcar.domain;

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
    private static final int MINIMUM_NUMBER_TO_GO = 4;
    private final int number;

    RandomNumber(int number) {
        if (isCorrectRange(number)) {
            throw new IllegalArgumentException();
        }
        this.number = number;
    }

    private boolean isCorrectRange(int number) {
        return (number < MINIMUM_OF_NUMBER) || (number > MAXIMUM_OF_NUMBER);
    }

    public boolean isMovable() {
        return number >= MINIMUM_NUMBER_TO_GO;
    }
}
