package tdd.racingcar.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Cars implements Iterable<Car> {
	private final List<Car> cars = new ArrayList<>();

	public Cars(final List<Car> cars) {
		this.cars.addAll(cars);
	}

	public void move() {
		cars.forEach(car -> {
			final Power power = PowerFactory.createRandomPower();
			car.move(power);
		});
	}

	public List<Car> getWinners() {
		final int maxPosition = getMaxPosition();
		return cars.stream()
				.filter(car -> car.isPosition(maxPosition))
				.collect(Collectors.toList());
	}

	private int getMaxPosition() {
		return cars.stream()
				.mapToInt(Car::getPosition)
				.max()
				.orElseThrow(() -> new IllegalArgumentException("차가 존재하지 않습니다."));
	}

	@Override
	public Iterator<Car> iterator() {
		return cars.iterator();
	}
}
