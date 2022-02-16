package racingcar;

import java.util.List;

public class Referee {
	private static final int MOVE_CRITERIA = 4;

	public static boolean canCarMove(int randomValue) {
		return randomValue >= MOVE_CRITERIA;
	}

	public static List<Car> judgeWinner(Cars cars, int maxPosition) {
		return cars.getSamePositionCar(maxPosition);
	}
}
