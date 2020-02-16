package racingcar.domain;

import racingcar.message.RacingCarMessage;

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

	private final int totalRound;

	public Round(int totalRound) {
		validateRound(totalRound);
		this.totalRound = totalRound;
	}

	private void validateRound(int totalRound) {
		if (totalRound < MINIMUM_NUMBER_OF_ROUND) {
			throw new IllegalArgumentException(RacingCarMessage.EXCEPTION_ROUND_IS_NOT_POSITIVE.getMessageText());
		}
	}

	public boolean isNonFinalRound(int round) {
		return round < totalRound;
	}
}
