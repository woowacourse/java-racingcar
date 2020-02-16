package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.PowerGenerator;
import racingcar.domain.RandomPowerGenerator;
import racingcar.domain.Round;
import racingcar.domain.Winner;
import racingcar.view.OutputView;

/*
 * Copyright (c) 2020 by 또동페어
 * All rights reserved.
 *
 * RacingGame.java
 * 레이싱 컨트롤러
 *
 * @author      또동페어
 * @version     1.0
 * @date        16 Feb 2020
 *
 */

public class RacingGame {
	public static final int FIRST_ROUND_INDEX = 0;

	public void start(final Cars cars, final Round round) {
		PowerGenerator powerGenerator = new RandomPowerGenerator();
		OutputView.printGameResultMessage();

		for (int i = FIRST_ROUND_INDEX; round.nonFinalRound(i); i++) {
			cars.moveAll(powerGenerator);
			OutputView.printRoundResult(cars);
		}

		final Winner winner = new Winner(cars.findWinners());
		OutputView.printWinner(winner);
	}
}
