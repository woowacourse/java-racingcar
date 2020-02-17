package racingcar.movingstrategy;

import racingcar.domain.RandomNumber;
import racingcar.generator.RandomNumberGenerator;

/*
 * Copyright (c) 2020 by 또링
 * All rights reserved.
 *
 * RandomMovingStrategy.java
 * 랜덤한 값을 발생시켜 움직이는 전략
 *
 * @author      또링
 * @version     1.0
 * @date        17 Feb 2020
 *
 */
public class RandomMovingStrategy implements MovingStrategy {
    private static final int MINIMUM_NUMBER_TO_GO = 4;

    private static RandomMovingStrategy randomMovingStrategy = new RandomMovingStrategy();

    private RandomMovingStrategy() {
    }

    public static RandomMovingStrategy getInstance() {
        return randomMovingStrategy;
    }

    @Override
    public boolean isMovable() {
        RandomNumber randomNumber = new RandomNumber(RandomNumberGenerator.getRandomNumber());
        return randomNumber.getNumber() >= MINIMUM_NUMBER_TO_GO;
    }
}
