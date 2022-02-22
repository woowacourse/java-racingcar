package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Winners {
	private final List<Car> winners;

	public Winners(List<Car> cars) {
		this.winners = getWinners(cars);
	}

	private List<Car> getWinners(List<Car> cars) {
		return cars.stream()
			.filter(car -> car.isSamePosition(getMaxPosition(cars)))
			.collect(Collectors.toList());
	}

	private Position getMaxPosition(List<Car> cars) {
		int maxPosition = 0;
		for (Car car : cars) {
			maxPosition = Math.max(maxPosition, car.getPosition().toInt());
		}
		return new Position(maxPosition);
	}

	public List<String> getNames() {
		return winners.stream()
			.map(Car::getName)
			.map(Name::toString)
			.collect(Collectors.toList());
	}
}
