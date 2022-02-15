package racingcar.domain.validation;

import java.util.List;

import racingcar.domain.Car;

public class CarsValidator {
	private static final int CAR_LIMIT = 2;
	private static final String CARS_ERROR_MESSAGE = "자동차를 두 개 이상 입력해주세요.";
	private static final String CAR_DUPLICATED_ERROR_MESSAGE = "자동차 이름을 모두 다르게 입력해주세요.";

	public void carsValid(List<Car> cars) {
		if (!isCars(cars)) {
			throw new IllegalArgumentException(CARS_ERROR_MESSAGE);
		}
		if (isDuplicated(cars)) {
			throw new IllegalArgumentException(CAR_DUPLICATED_ERROR_MESSAGE);
		}
	}

	private boolean isCars(List<Car> cars) {
		return cars.size() >= CAR_LIMIT;
	}

	private boolean isDuplicated(List<Car> cars) {
		return cars.stream()
			.distinct()
			.count() != cars.size();
	}
}
