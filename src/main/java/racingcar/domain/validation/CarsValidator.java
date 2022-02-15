package racingcar.domain.validation;

import java.util.List;

import racingcar.domain.Car;
import racingcar.util.Constant;

public class CarsValidator {

	public static void carsValid(List<Car> cars) {
		if (!isCars(cars)) {
			throw new IllegalArgumentException(Constant.CARS_ERROR_MESSAGE);
		}
		if (isDuplicated(cars)) {
			throw new IllegalArgumentException(Constant.CAR_DUPLICATED_ERROR_MESSAGE);
		}
	}

	private static boolean isCars(List<Car> cars) {
		return cars.size() >= Constant.CAR_LIMIT;
	}

	private static boolean isDuplicated(List<Car> cars) {
		return cars.stream()
			.distinct()
			.count() != cars.size();
	}
}
