package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Winners {
	private static final int MIN_POSITION = 0;

	private final List<Car> winners;

	public Winners(List<Car> cars) {
		int maxPosition = getMaxPosition(cars);
		winners = cars.stream()
			.filter(car -> car.getPosition() == maxPosition)
			.collect(Collectors.toList());
	}

	private int getMaxPosition(List<Car> cars) {
		return cars.stream()
			.mapToInt(Car::getPosition)
			.max()
			.orElse(MIN_POSITION);
	}

	@Override
	public String toString() {
		List<String> names = new ArrayList<>();
		for (Car winner : winners) {
			names.add(winner.getName());
		}

		return String.join(", ", names) + "가 최종 우승했습니다.";
	}
}
