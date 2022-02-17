package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;

public class Winners {

	private int maxPosition;

	private void findMaxPosition(List<Car> cars) {
		this.maxPosition = cars.stream().mapToInt(Car::getPosition).max().orElse(0);
	}

	public List<Name> findWinner(List<Car> cars) {
		findMaxPosition(cars);
		return cars.stream()
			.filter(car -> car.matchPosition(maxPosition))
			.map(Car::getName)
			.collect(Collectors.toUnmodifiableList());
	}

}