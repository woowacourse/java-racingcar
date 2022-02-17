package racingcar;

import java.util.List;

public class Referee {

	public static List<Car> judgeWinner(Cars cars, int maxPosition) {
		return cars.getSamePositionCar(maxPosition);
	}
}
