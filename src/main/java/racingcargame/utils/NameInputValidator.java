package racingcargame.utils;

import java.util.Arrays;

public class NameInputValidator {

	private NameInputValidator() {
	}

	public static String validateCarNames(final String carNames) {
		if (hasBlankInCarNames(carNames) && isNotEmptyCarNames(carNames) && isOverCarNamesLimitSize(carNames)) {
			return carNames;
		}
		throw new IllegalArgumentException();
	}

	private static boolean hasBlankInCarNames(final String carNames) {
		if (carNames == null) {
			throw new IllegalArgumentException("[error] 입력된 자동차 이름이 없습니다.");
		}
		return true;
	}

	private static boolean isNotEmptyCarNames(final String carNames) {
		String[] cars = carNames.split(",");
		int count = (int)Arrays.stream(cars)
			.filter(String::isBlank).count();
		if (count > 0) {
			throw new IllegalArgumentException("[error] 입력된 자동차 이름 중 이름이 없는 자동차가 있습니다.");
		}
		return true;
	}

	private static boolean isOverCarNamesLimitSize(final String carNames) {
		String[] cars = carNames.split(",");
		int count = (int)Arrays.stream(cars)
			.filter(car -> car.length() > 5).count();
		if (count > 0) {
			throw new IllegalArgumentException("[error] 자동차 이름을 5자 이하로 입력해주세요.");
		}
		return true;
	}
}
