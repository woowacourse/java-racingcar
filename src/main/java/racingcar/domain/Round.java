package racingcar.domain;

import racingcar.message.Message;

/*
 * Copyright (c) 2020 by 또동페어
 * All rights reserved.
 *
 * Round.java
 * Round 객체
 *
 * @author      또동페어
 * @version     1.0
 * @date        12 Feb 2020
 *
 */
public class Round {
    private static final int MINIMUM_NUMBER_OF_ROUND = 1;

    private final int numberOfRound;
    private int currentRound;

    public Round(int numberOfRound) {
        if (numberOfRound < MINIMUM_NUMBER_OF_ROUND) {
            throw new IllegalArgumentException(Message.EXCEPTION_ROUND_IS_NOT_POSITIVE.getMessageText());
        }
        this.numberOfRound = numberOfRound;
        this.currentRound = 0;
    }

    public void goNextRound() {
        currentRound++;
    }

    public boolean isSameCurrent(int currentRound) {
        return this.currentRound == currentRound;
    }

    public boolean isFinalRound() {
        return currentRound == numberOfRound;
    }
}
