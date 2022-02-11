package racingcar.validator;

import java.util.List;

public class CarNameValidator {
	public static final int CAR_NAME_LENGTH_LIMIT = 5;

	public static void checkCarNamesLine(String carNamesLine) {
		if (carNamesLine.equals("")) {
			throw new RuntimeException("빈 문자열을 자동차 이름으로 입력할 수 없습니다.");
		}
	}

	public static void checkCarNames(List<String> carNames) {
		for (String carName : carNames) {
			carNameLengthException(carName);
			carNameIsEmptyException(carName);
			carNameIsSpaceException(carName);
		}
		carNameDuplicationException(carNames);
	}

	private static void carNameLengthException(String carName) {
		if (carName.length() > CAR_NAME_LENGTH_LIMIT) {
			throw new RuntimeException("자동차 이름은 5자 이하여야 합니다.");
		}
	}

	private static void carNameIsEmptyException(String carName) {
		if (carName.equals("")) {
			throw new RuntimeException("모든 자동차 이름은 반드시 존재해야 합니다.");
		}
	}

	private static void carNameIsSpaceException(String carName) {
		if (carName.trim().equals("")) {
			throw new RuntimeException("자동차 이름은 공백으로 설정할 수 없습니다.");
		}
	}

	private static void carNameDuplicationException(List<String> carNames) {
		if (carNames.stream().distinct().count() != carNames.size()) {
			throw new RuntimeException("자동차 이름은 중복될 수 없습니다.");
		}
	}
}
