package racingcar.util;

import racingcar.model.car.Car;

public class Format {
	private static final String CAR_POSITION_BAR = "-";

	public static String carResult(Car car) {
		return String.format(car.getName() + " : "
			+ CAR_POSITION_BAR.repeat(car.getPosition().toInt()));
	}
}
