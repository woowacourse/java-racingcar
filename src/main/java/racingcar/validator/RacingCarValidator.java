package racingcar.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import racingcar.domain.Car;

public class RacingCarValidator {
	private static final int INVALID_CAR_NAMES_LENGTH = 1;

	private static final String CAR_NAMES_LENGTH_ERROR = "[ERROR] 자동차 이름을 한 대이상 입력해야 합니다.";
	private static final String CAR_NAMES_DUPLICATE_ERROR ="[ERROR] 자동차 이름은 중복될 수 없습니다.";

	public static void validateCars(List<Car> carNames) {
		if(carNames.size() == INVALID_CAR_NAMES_LENGTH) {
			throw new IllegalArgumentException(CAR_NAMES_LENGTH_ERROR);
		}

		Set<Car> overlapChecker = new HashSet<>();
		for (Car carName : carNames) {
			isDuplicate(carName, overlapChecker);
			overlapChecker.add(carName);
		}
	}

	private static void isDuplicate(Car carName, Set<Car> overlapChecker) {
		if(overlapChecker.contains(carName)) {
			throw new IllegalArgumentException(CAR_NAMES_DUPLICATE_ERROR);
		}
	}
}
