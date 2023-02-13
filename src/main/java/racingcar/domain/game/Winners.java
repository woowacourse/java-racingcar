package racingcar.domain.game;

import static racingcar.messsages.ExceptionMessage.*;

import java.util.List;
import java.util.stream.Collectors;

import racingcar.domain.car.Car;
import racingcar.domain.car.Position;

public class Winners {
	private final List<Car> winners;

	public Winners(final List<Car> cars) {
		this.winners = findWinners(cars);
	}

	public List<String> getWinnerNames() {
		return winners.stream()
			.map(Car::getNameValue)
			.collect(Collectors.toUnmodifiableList());
	}

	private List<Car> findWinners(final List<Car> cars) {
		final int findMaxPosition = findMaxPosition(cars);
		final Position maxPosition = new Position(findMaxPosition);

		return cars.stream()
			.filter(car -> car.isSamePosition(maxPosition))
			.collect(Collectors.toList());
	}

	private int findMaxPosition(final List<Car> cars) {
		return cars
			.stream()
			.mapToInt(Car::getPositionValue)
			.max()
			.orElseThrow(() -> new IllegalStateException(CARS_EMPTY_EXCEPTION.getMessage()));
	}
}
