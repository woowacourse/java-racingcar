package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Winners {
	private final List<Car> winners;

	public Winners(List<Car> cars) {
		int maxPosition = getMaxPosition(cars);
		winners = cars.stream()
			.filter(car -> car.getPosition() == maxPosition)
			.collect(Collectors.toList());
	}

	private int getMaxPosition(List<Car> cars) {
		int max = Integer.MIN_VALUE;
		for (Car car : cars) {
			max = Math.max(max, car.getPosition());
		}
		return max;
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
