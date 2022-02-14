package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class Referee {
	private static final int MOVE_CRITERIA = 4;

	public static void moveCar(Car car, int randomValue) {
		if (randomValue >= MOVE_CRITERIA) {
			car.move();
		}
	}

	public static List<Car> judgeWinner(Cars cars) {
		return cars.getCars().stream()
			.filter(car -> car.isPosition(cars.getMaxPosition()))
			.collect(Collectors.toList());
	}
}
