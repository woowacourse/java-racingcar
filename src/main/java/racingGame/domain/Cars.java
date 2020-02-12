package racingGame.domain;

import java.util.Arrays;
import java.util.List;

public class Cars {
	private final List<Car> cars;

	public Cars(final List<Car> cars) {
		checkDuplicate(cars);
		this.cars = cars;
	}

	private void checkDuplicate(final List<Car> cars) {
		if (cars.size() != getDistinctSize(cars)) {
			throw new IllegalArgumentException("중복된 이름이 존재합니다.");
		}
	}

	private long getDistinctSize(final List<Car> cars) {
		return Arrays.stream(cars.toArray())
			.distinct()
			.count();
	}

	public List<Car> getCars() {
		return cars;
	}
}
