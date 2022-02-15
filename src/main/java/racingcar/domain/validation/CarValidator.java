package racingcar.domain.validation;

public class CarValidator extends Validator {
	private static final String CAR_BLANK_ERROR_MESSAGE = "자동차 이름은 %s일 수 없습니다.";
	private static final String CAR_NAME_LENGTH_ERROR_MESSAGE = "자동차의 이름은 5글자를 초과할 수 없습니다.";
	private static final int CAR_LENGTH_LIMIT = 5;

	public void carValid(String name) {
		checkBlank(name, CAR_BLANK_ERROR_MESSAGE);
		validLength(name);
	}

	private void validLength(String name) {
		if (!(name.trim().length() <= CAR_LENGTH_LIMIT)) {
			throw new IllegalArgumentException(CAR_NAME_LENGTH_ERROR_MESSAGE);
		}
	}
}
