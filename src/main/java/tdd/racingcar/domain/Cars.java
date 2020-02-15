package tdd.racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Cars {
	private List<Car> cars;

	public Cars(List<Car> cars) {
		this.cars = List.copyOf(cars);
	}

	public void move() {
		for (Car car : cars) {
			final Power randomPower = PowerFactory.createRandomPower();
			car.move(randomPower);
		}
	}

	public List<Name> getWinnerNames() {
		final Position maxPosition = getMaxPosition();
		return cars.stream()
			.filter(car -> car.getPosition().equals(maxPosition))
			.map(Car::getName)
			.collect(Collectors.toUnmodifiableList());
	}

	private Position getMaxPosition() {
		return cars.stream()
			.map(Car::getPosition)
			.reduce(Position::getGreater)
			.orElseThrow(() -> new NullPointerException("차가 존재하지 않습니다."));
	}

	public Stream<Car> stream() {
		return cars.stream();
	}
}
