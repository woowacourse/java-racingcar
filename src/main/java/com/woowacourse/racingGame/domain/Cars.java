package com.woowacourse.racingGame.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Cars {
	private final List<Car> cars;

	public Cars(final List<Car> cars) {
		checkDuplicate(cars);
		this.cars = cars;
	}

	private void checkDuplicate(final List<Car> cars) {
		if (isDuplicateExist(cars)) {
			throw new IllegalArgumentException("중복된 이름이 존재합니다.");
		}
	}

	private boolean isDuplicateExist(final List<Car> cars) {
		return cars.size() != Arrays.stream(cars.toArray())
			.distinct()
			.count();
	}

	public void attemptMove() {
		for (Car car : cars) {
			car.attemptMoveThrough(RandomNo.valueOf(RandomGenerator.generateRandomNumber()));
		}
	}

	// NOTE : unmodifiable로 처리해주는 것이 의미를 가지는지 리뷰어님께 여쭤보기.
	public List<Car> getCars() {
		return Collections.unmodifiableList(cars);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Cars cars = (Cars)o;
		return Objects.equals(this.cars, cars.cars);
	}

	@Override
	public int hashCode() {
		return Objects.hash(cars);
	}
}
