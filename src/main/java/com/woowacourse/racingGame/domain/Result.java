package com.woowacourse.racingGame.domain;

import java.util.List;
import java.util.stream.Collectors;

import com.woowacourse.racingGame.utils.StringUtil;

public class Result {
	private final Cars cars;
	private final List<String> racingCarStatus;

	public Result(final Cars cars) {
		this.cars = cars;
		racingCarStatus = generateRacingCarStatus();
	}

	private List<String> generateRacingCarStatus() {
		return cars.getCars().stream()
			.map(car -> car.getName()
				+ " : "
				+ StringUtil.convertIntoDashBy(car.getPosition()))
			.collect(Collectors.toList());
	}

	public List<String> getWinners() {
		final int maxPosition = getMaxPosition();
		return cars.getCars().stream()
			.filter(car -> isWinner(car, maxPosition))
			.map(Car::getName)
			.collect(Collectors.toList());
	}

	private Integer getMaxPosition() {
		return cars.getCars().stream()
			.map(Car::getPosition)
			.max(Integer::compareTo)
			.get();
	}

	private boolean isWinner(final Car car, final int maxPosition) {
		return car.isSamePosition(maxPosition);
	}

	public List<String> getRacingCarStatus() {
		return racingCarStatus;
	}
}
