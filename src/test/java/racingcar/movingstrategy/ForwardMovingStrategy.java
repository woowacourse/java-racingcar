package racingcar.movingstrategy;

/*
 * Copyright (c) 2020 by 또링
 * All rights reserved.
 *
 * ForwardMovingStrategy.java
 * 무조건 전진하는 전략
 *
 * @author      또링
 * @version     1.0
 * @date        17 Feb 2020
 *
 */
public class ForwardMovingStrategy implements MovingStrategy {
    private static ForwardMovingStrategy forwardMovingStrategy = new ForwardMovingStrategy();

    private ForwardMovingStrategy() {
    }

    public static ForwardMovingStrategy getInstance() {
        return forwardMovingStrategy;
    }

    @Override
    public boolean isMovable() {
        return true;
    }
}
