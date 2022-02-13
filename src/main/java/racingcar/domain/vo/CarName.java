package racingcar.domain.vo;

import java.util.Objects;

public class CarName {

	private static final int CAR_NAME_MAX_LENGTH = 5;
	private static final String EXCEED_LENGTH_ERROR_MESSAGE = "[ERROR] 이름은 최대 5자입니다.";
	private static final String ALLOWED_CHARACTERS = ".*[^\\w\\dㄱ-ㅎ가-힣]+.*";
	private static final String NOT_ALLOWED_FORMAT_MESSAGE = "[ERROR] 올바르지 않은 입력 형식입니다.";
	public static final String INVALID_CAR_NAME_SHOULD_BE_ONE_MORE_CHARACTER = "[ERROR] 자동차 이름은 최대 한 글자 이상입니다";

	private String name;

	public CarName(String name) {
		validateCarName(name);
		this.name = name;
	}

	public String get() {
		return name;
	}

	public static void validateCarName(String carName) {

		carName = carName.trim();

		isCarNameEmpty(carName);

		isCarNameExceed(carName);

		hasCarNameWrongFormat(carName);

	}

	private static void hasCarNameWrongFormat(String carName) {
		if (carName.matches(ALLOWED_CHARACTERS)) {
			throw new RuntimeException(NOT_ALLOWED_FORMAT_MESSAGE);
		}
	}

	private static void isCarNameExceed(String carName) {
		if (carName.length() > CAR_NAME_MAX_LENGTH) {
			throw new RuntimeException(EXCEED_LENGTH_ERROR_MESSAGE);
		}
	}

	private static void isCarNameEmpty(String carName) {
		if (carName.isEmpty()) {
			throw new RuntimeException(INVALID_CAR_NAME_SHOULD_BE_ONE_MORE_CHARACTER);
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		CarName carName = (CarName)o;
		return Objects.equals(name, carName.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public String toString() {
		return name;
	}
}
