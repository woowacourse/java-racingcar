package com.woowacourse.racingGame.controller;

import java.util.List;

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
		moveCar();
		final List<Car> playedCar = cars.getCars();
		return new Result(new Cars(playedCar));
	}

	private void moveCar() {
		for (Car car : cars.getCars()) {
			car.move(RandomGenerator.generateRandomNumber());
		}
	}
}
