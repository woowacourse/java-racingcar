package racingcar.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import racingcar.domain.Car;

public class RacingCarValidator {
	private static final int INVALID_CAR_NAMES_LENGTH = 1;
	private static final int NEGATIVE_NUMBER_CHECK = 0;
	private static final int CAR_NAME_LIMITED_LENGTH = 5;

	private static final String CAR_NAME_INPUT_ERROR = "[ERROR] 이름은 공백, 빈 값, null일 수 없습니다.";
	private static final String CAR_NAME_LENGTH_ERROR = "[ERROR] 이름은 5자를 초과할 수 없습니다.";
	private static final String CAR_NAMES_LENGTH_ERROR = "[ERROR] 자동차 이름을 한 대이상 입력해야 합니다.";
	private static final String CAR_NAMES_DUPLICATE_ERROR ="[ERROR] 자동차 이름은 중복될 수 없습니다.";

	public static void validateCount(int number) {
		// TODO: 숫자가 아닐 경우 exception 추가

		if (number < NEGATIVE_NUMBER_CHECK) {
			throw new IllegalArgumentException();
		}
	}

	public static void validateCarName(String name) {
		if (name == null || name.isEmpty() || name.isBlank()) {
			throw new IllegalArgumentException(CAR_NAME_INPUT_ERROR);
		}

		if (name.length() > CAR_NAME_LIMITED_LENGTH) {
			throw new IllegalArgumentException(CAR_NAME_LENGTH_ERROR);
		}
	}

	public static void validateCars(List<Car> carNames) {
		if(carNames.size() == INVALID_CAR_NAMES_LENGTH) {
			throw new IllegalArgumentException(CAR_NAMES_LENGTH_ERROR);
		}

		Set<Car> overlapChecker = new HashSet<>(carNames);
		if(overlapChecker.size() != carNames.size()) {
			throw new IllegalArgumentException(CAR_NAMES_DUPLICATE_ERROR);
		}
	}
}
