package racingcar.domain;

import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;

import java.util.List;

public class Referee {

	public static List<Car> judgeWinner(Cars cars, int maxPosition) {
		return cars.getSamePositionCar(maxPosition);
	}
}
