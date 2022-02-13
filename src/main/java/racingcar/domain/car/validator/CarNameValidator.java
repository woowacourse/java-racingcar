package racingcar.domain.car.validator;

import java.util.List;

import racingcar.domain.car.condition.DuplicateName;
import racingcar.domain.car.condition.NameLength;
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
		validateNameIsDuplicated(names);
	}

	void validateNameIsTooLong(List<String> names) {
		if (checkNameIsTooLong(names)) {
			throw new CarNameTooLongException();
		}
	}

	private boolean checkNameIsTooLong(List<String> names) {
		return names.stream()
				.anyMatch(NameLength::isTooLong);
	}

	void validateNameIsEmpty(List<String> names) {
		if (checkNameIsEmpty(names)) {
			throw new CarNameEmptyException();
		}
	}

	private boolean checkNameIsEmpty(List<String> names) {
		return names.stream()
				.anyMatch(String::isEmpty);
	}

	void validateNameIsDuplicated(List<String> names) {
		if (checkNameIsDuplicated(names)) {
			throw new CarNameDuplicatedException();
		}
	}

	private boolean checkNameIsDuplicated(List<String> names) {
		return names.stream()
				.anyMatch(name -> DuplicateName.isExcessiveDuplicated(names, name));
	}

}
