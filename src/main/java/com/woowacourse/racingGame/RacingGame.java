package com.woowacourse.racingGame;

import java.util.ArrayList;
import java.util.List;

import com.woowacourse.racingGame.domain.Car;
import com.woowacourse.racingGame.domain.Cars;

public class RacingGame {
	private int maxPosition = 7;

	public List<Car> getWinners(final Cars cars) {
		List<Car> winners = new ArrayList<>();

		for (Car car : cars.getCars()) {
			addIfWinner(winners, car);
		}
		return winners;
	}

	private void addIfWinner(List<Car> winners, final Car car) {
		if (car.isWinnerPosition(maxPosition)) {
			winners.add(car);
		}
	}
}
