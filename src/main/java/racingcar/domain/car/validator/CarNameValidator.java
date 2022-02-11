package racingcar.domain.car.validator;

import java.util.Collections;
import java.util.List;

import racingcar.domain.car.NameLength;
import racingcar.exception.car.CarNameDuplicatedException;
import racingcar.exception.car.CarNameEmptyException;
import racingcar.exception.car.CarNameTooLongException;

public class CarNameValidator {

	public static CarNameValidator instance = new CarNameValidator();

	public static void validateCarNames(List<String> names) {
		instance.validateNameIsTooLong(names);
		instance.validateNameIsEmpty(names);
		instance.validateNameIsDuplicate(names);
	}

	private void validateNameIsTooLong(List<String> names) {
		if (names.stream().anyMatch(NameLength::isTooLong)) {
			throw new CarNameTooLongException();
		}
	}

	private void validateNameIsEmpty(List<String> names) {
		if (names.stream().anyMatch(String::isEmpty)) {
			throw new CarNameEmptyException();
		}
	}

	private void validateNameIsDuplicate(List<String> names) {
		if (names.stream().anyMatch(name -> isNameDuplicated(names, name))) {
			throw new CarNameDuplicatedException();
		}
	}

	private boolean isNameDuplicated(List<String> names, String name) {
		return (Collections.frequency(names, name) > 1);
	}

}
