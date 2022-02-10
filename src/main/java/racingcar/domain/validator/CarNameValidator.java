package racingcar.domain.validator;

import java.util.Collections;
import java.util.List;

import racingcar.domain.CarNameLength;

public class CarNameValidator {

	public static CarNameValidator instance = new CarNameValidator();

	public static void validateCarNames(List<String> names) {
		instance.validateNameIsTooLong(names);
		instance.validateNameIsEmpty(names);
		instance.validateNameIsDuplicate(names);
	}

	private void validateNameIsTooLong(List<String> names) {
		if (names.stream().anyMatch(CarNameLength::isTooLong)) {
			throw new IllegalArgumentException("자동차의 이름은 5자 이하여야 합니다.");
		}
	}

	private void validateNameIsEmpty(List<String> names) {
		if (names.stream().anyMatch(String::isEmpty)) {
			throw new IllegalArgumentException("자동차의 이름은 공백이 될 수 없습니다.");
		}
	}

	private void validateNameIsDuplicate(List<String> names) {
		if (names.stream().anyMatch(name -> isNameDuplicated(names, name))) {
			throw new IllegalArgumentException("자동차의 이름은 중복될 수 없습니다.");
		}
	}

	private boolean isNameDuplicated(List<String> names, String name) {
		return (Collections.frequency(names, name) > 1);
	}

}
