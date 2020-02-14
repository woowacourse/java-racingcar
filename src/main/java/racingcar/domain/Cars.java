package racingcar.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

	private final List<Car> cars;

	public Cars(List<Car> cars) {
		this.cars = Collections.unmodifiableList(cars);
	}

	public void moveAll() {
		cars.forEach(car -> car.move(RandomGenerator.generateRandom()));
	}

	public List<Car> getWinners() {
		return cars.stream()
				.filter(car -> car.isMaxPosition(getMaxPosition()))
				.collect(Collectors.toUnmodifiableList());
	}

	private int getMaxPosition() {
		int maxPosition = Car.INITIAL_POSITION;
		for (Car car : cars) {
			maxPosition = car.getBiggerPosition(maxPosition);
		}

		return maxPosition;
	}

	public List<Car> getCars() {
		return cars;
	}
}
