package racingcar.domain;

import racingcar.message.Message;

/*
 * Copyright (c) 2020 by 또동페어
 * All rights reserved.
 *
 * RacingGame.java
 * 레이싱 게임을 담당하는 클래스
 *
 * @author      또동페어
 * @version     1.0
 * @date        12 Feb 2020
 *
 */
public class RacingGame {
    public static final int MINIMUM_NUMBER_OF_ROUND = 1;

    private final Cars cars;
    private final int numberOfRound;

    public RacingGame(Cars cars, int numberOfRound) {
        if (numberOfRound < MINIMUM_NUMBER_OF_ROUND) {
            throw new IllegalArgumentException(Message.EXCEPTION_ROUND_IS_NOT_POSITIVE.getMessageText());
        }
        this.cars = cars;
        this.numberOfRound = numberOfRound;
    }

    public void start() {
        for (int i = 0; i < numberOfRound; i++) {
            cars.run();
        }
    }
}
