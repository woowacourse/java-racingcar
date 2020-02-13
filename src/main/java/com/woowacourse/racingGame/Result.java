package com.woowacourse.racingGame;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.woowacourse.racingGame.domain.Car;
import com.woowacourse.racingGame.domain.Cars;
import com.woowacourse.racingGame.utils.StringUtil;

public class Result {
	private int maxPosition = 7;
	private final Cars cars;

	public Result(final Cars cars) {
		this.cars = cars;
	}

	public List<String> getRacingCarStatus() {
		return cars.getCars().stream()
			.map(StringUtil::convertCarStatus)
			.collect(Collectors.toList());
	}

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
