package com.woowacourse.racingGame.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.woowacourse.racingGame.utils.StringUtil;

public class Result {
	private final int maxPosition;
	private final Cars cars;
	private final List<String> racingCarStatus;

	public Result(final Cars cars) {
		this.cars = cars;
		this.maxPosition = generateMaxPosition();
		racingCarStatus = generateRacingCarStatus();
	}

	private List<String> generateRacingCarStatus() {
		return cars.getCars().stream()
			.map(StringUtil::convertCarStatus)
			.collect(Collectors.toList());
	}

	private Integer generateMaxPosition() {
		return cars.getCars().stream()
			.map(Car::getPosition)
			.max(Integer::compareTo)
			.get();
	}

	public List<String> getRacingCarStatus() {
		return racingCarStatus;
	}

	public List<String> getWinners() {
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
