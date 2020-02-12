package tdd.racingcar.domain;

import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

public class Cars {
	private final List<Car> cars;

	public Cars(final List<Car> cars) {
		this.cars = cars;
	}

	public void move() {
		final Power randomPower = PowerFactory.createRandomPower();
		cars.forEach(tryToMove(randomPower));

	}

	public Consumer<Car> tryToMove(final Power power) {
		return car -> car.move(power);
	}

	public int getMaxPosition() {
		return cars.stream()
			.mapToInt(Car::getPosition)
			.max()
			.orElseThrow(() -> new IllegalArgumentException("차가 존재하지 않습니다."));
	}

	public List<Car> toList() {
		return Collections.unmodifiableList(cars);
	}
}
