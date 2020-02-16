package racingcar;

import racingcar.controller.RacingGame;
import racingcar.domain.Cars;
import racingcar.domain.CarsFactory;
import racingcar.domain.Round;
import racingcar.view.InputView;
import racingcar.view.OutputView;

/*
 * Copyright (c) 2020 by 또동페어
 * All rights reserved.
 *
 * Application.java
 * 시작 클래스
 *
 * @author      또동페어
 * @version     1.0
 * @date        12 Feb 2020
 *
 */
public class Application {
	public static void main(String[] args) {
		try {
			Cars cars = CarsFactory.createCars(InputView.inputCarNames());
			Round round = new Round(InputView.inputNumberOfRound());

			RacingGame racingGame = new RacingGame();
			racingGame.start(cars, round);
		} catch (RuntimeException e) {
			OutputView.printErrorMessage(e.getMessage());
		}
	}
}
