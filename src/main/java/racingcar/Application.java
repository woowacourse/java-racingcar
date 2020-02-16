package racingcar;

import racingcar.controller.RacingGame;
import racingcar.domain.Cars;
import racingcar.domain.Round;
import racingcar.domain.PowerGenerator;
import racingcar.domain.RandomPowerGenerator;
import racingcar.domain.CarsFactory;
import racingcar.view.InputView;

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

			PowerGenerator powerGenerator = new RandomPowerGenerator();
			RacingGame gameController = new RacingGame(powerGenerator);
			gameController.start(cars, round);
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
			System.exit(1);
		}
	}
}
