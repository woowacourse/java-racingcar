package racingcar;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Referee {
	private static final int MOVE_CRITERIA = 4;

	public static void moveCar(Car car, int randomValue) {
		if (randomValue >= MOVE_CRITERIA) {
			car.move();
		}
	}

	private static int getMaxPosition(Set<Car> cars) {
		return cars.stream()
			.mapToInt(Car::getPosition)
			.max()
			.getAsInt();
	}

	public static List<Car> judgeWinner(Set<Car> cars) {
		return cars.stream()
			.filter(car -> car.isPosition(getMaxPosition(cars)))
			.collect(Collectors.toList());
	}
}
