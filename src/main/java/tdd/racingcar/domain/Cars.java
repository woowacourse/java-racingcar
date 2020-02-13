package tdd.racingcar.domain;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class Cars  {
	private final List<Car> cars;

	public Cars(final List<Car> cars) {
		this.cars = cars;
	}

	public void move() {
		cars.forEach(tryToMove());
	}

	private Consumer<Car> tryToMove() {
		return car -> {
			final Power randomPower = PowerFactory.createRandomPower();
			car.move(randomPower);
		};
	}

	public int getMaxPosition() {
		return cars.stream()
			.mapToInt(Car::getPosition)
			.max()
			.orElseThrow(() -> new IllegalArgumentException("차가 존재하지 않습니다."));
	}

	public Stream<Car> stream() {
		return cars.stream();
	}
}
