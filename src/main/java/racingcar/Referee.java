package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class Referee {
	private static final int MOVE_CRITERIA = 4;

	public static boolean canCarMove(int randomValue) {
		return randomValue >= MOVE_CRITERIA;
	}

	public static List<Car> judgeWinner(List<Car> cars, int maxPosition) {
		return cars.stream()
			.filter(car -> car.isPosition(maxPosition))
			.collect(Collectors.toList());
	}
}
