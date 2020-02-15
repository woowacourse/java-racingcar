package racingcar.Domain;

import java.util.Objects;

/**
 * 클래스 이름 : .java
 *
 * @author
 * @version 1.0
 * <p>
 * 날짜 : 2020/02/14
 */
public class Name {
	private static final String CAR_NAME_CAN_NOT_HAVE_A_BLANK_STRING_EXCEPTION_MESSAGE = "자동차 이름에 공백이 포함될 수 없습니다.";
	private static final String CAR_NAME_CAN_NOT_BE_AN_EMPTY_STRING_EXCEPTION_MESSAGE = "자동차 이름이 빈문자열일 수 없습니다.";
	private static final String BLANK_STRING = " ";
	private static final String CAR_NAME_CAN_NOT_BE_NULL_EXCEPTION_MESSAGE = "자동차 이름은 null이 들어갈 수 없습니다.";
	private static final String EMPTY_STRING = "";
	private static final int MAX_CAR_NAME_LENGTH = 5;
	private static final String CAR_NAME_CAN_BE_LESS_THAN_SIX_LETTER_EXCEPTION_MESSAGE = "자동차 이름은 6자 미만만 가능합니다.";

	private final String name;

	public String getName() {
		return this.name;
	}

	public Name(final String inputName) {
		Objects.requireNonNull(inputName, CAR_NAME_CAN_NOT_BE_NULL_EXCEPTION_MESSAGE);
		validateInputName(inputName);
		this.name = inputName;
	}

	private void validateInputName(final String inputName) {
		validateInputNameIsEmpty(inputName);
		validateInputNameHasBlank(inputName);
		validateInputNameLength(inputName);
	}

	private void validateInputNameIsEmpty(final String inputName) {
		if (inputName.equals(EMPTY_STRING)) {
			throw new IllegalArgumentException(CAR_NAME_CAN_NOT_BE_AN_EMPTY_STRING_EXCEPTION_MESSAGE);

		}
	}

	private void validateInputNameHasBlank(final String inputName) {
		if (inputName.contains(BLANK_STRING)) {
			throw new IllegalArgumentException(CAR_NAME_CAN_NOT_HAVE_A_BLANK_STRING_EXCEPTION_MESSAGE);
		}
	}


	private void validateInputNameLength(final String inputName) {
		if (inputName.length() > MAX_CAR_NAME_LENGTH) {
			throw new IllegalArgumentException(CAR_NAME_CAN_BE_LESS_THAN_SIX_LETTER_EXCEPTION_MESSAGE);
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Name name1 = (Name) o;
		return Objects.equals(name, name1.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
}
