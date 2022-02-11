package racingcar.domain.car.validator;

import java.util.Collections;
import java.util.List;

import racingcar.domain.car.NameLength;
import racingcar.exception.car.CarNameDuplicatedException;
import racingcar.exception.car.CarNameEmptyException;
import racingcar.exception.car.CarNameTooLongException;

public class CarNameValidator {

	public static CarNameValidator instance = new CarNameValidator();

	public static void validateNames(List<String> names) {
		instance.validate(names);
	}

	void validate(List<String> names) {
		validateNameIsTooLong(names);
		validateNameIsEmpty(names);
		validateNameIsDuplicate(names);
	}

	void validateNameIsTooLong(List<String> names) {
		if (names.stream().anyMatch(NameLength::isTooLong)) {
			throw new CarNameTooLongException();
		}
	}

	void validateNameIsEmpty(List<String> names) {
		if (names.stream().anyMatch(String::isEmpty)) {
			throw new CarNameEmptyException();
		}
	}

	void validateNameIsDuplicate(List<String> names) {
		if (names.stream().anyMatch(name -> isNameDuplicated(names, name))) {
			throw new CarNameDuplicatedException();
		}
	}

	private boolean isNameDuplicated(List<String> names, String name) {
		return (Collections.frequency(names, name) > 1);
	}

}
