package com.woowacourse.racingGame.controller;

import com.woowacourse.racingGame.domain.Car;
import com.woowacourse.racingGame.domain.Cars;
import com.woowacourse.racingGame.domain.Result;
import com.woowacourse.racingGame.utils.RandomGenerator;

public class RacingGame {
	private final Cars cars;

	public RacingGame(final Cars cars) {
		this.cars = cars;
	}

	public Result play() {
		attemptMoveCars();
		return new Result(cars);
	}

	private void attemptMoveCars() {
		for (Car car : cars.getCars()) {
			car.attemptMoveThrough(RandomGenerator.generateRandomNumber());
		}
	}
}
