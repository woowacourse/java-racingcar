package com.woowacourse.racingGame;

import java.util.ArrayList;
import java.util.List;

import com.woowacourse.racingGame.domain.Car;
import com.woowacourse.racingGame.domain.Cars;

public class Result {
	private int maxPosition = 7;

	public List<String> getWinners(final Cars cars) {
		List<String> winners = new ArrayList<>();

		for (Car car : cars.getCars()) {
			addWinningCar(winners, car);
		}
		return winners;
	}

	private void addWinningCar(List<String> winners, final Car car) {
		if (car.isWinnerPosition(maxPosition)) {
			winners.add(car.getName());
		}
	}
}
