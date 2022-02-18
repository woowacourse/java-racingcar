package racingcar.domain.vo;

import java.util.Objects;
import java.util.regex.Pattern;

public class CarName {

	public static final int CAR_NAME_MAX_LENGTH = 5;
	public static final String ALLOWED_CHARACTERS = "\\w\\dㄱ-ㅎ가-힣";
	public static final String NOT_ALLOWED_REGEXP_STRING = ".*[^" + ALLOWED_CHARACTERS + "]+.*";
	public static final String EXCEED_LENGTH_ERROR_MESSAGE = "[ERROR] 이름은 최대 5자입니다.";
	public static final String NOT_ALLOWED_FORMAT_MESSAGE = "[ERROR] 올바르지 않은 입력 형식입니다.";
	public static final String INVALID_CAR_NAME_SHOULD_BE_ONE_MORE_CHARACTER = "[ERROR] 자동차 이름은 최대 한 글자 이상입니다";
	public static final Pattern COMPILED_CAR_NAME_PATTERN = Pattern.compile(NOT_ALLOWED_REGEXP_STRING);

	private final String name;

	public CarName(final String name) {
		validateCarName(name);
		this.name = name;
	}

	public String get() {
		return name;
	}

	private static void validateCarName(String carName) {
		isCarNameNull(carName);
		carName = carName.trim();

		isCarNameEmpty(carName);
		isCarNameExceed(carName);
		hasCarNameWrongFormat(carName);
	}

	private static void isCarNameNull(String carName) {
		if (carName == null) {
			throw new RuntimeException(INVALID_CAR_NAME_SHOULD_BE_ONE_MORE_CHARACTER);
		}
	}

	private static void hasCarNameWrongFormat(final String carName) {
		if (doesNotMatchCarName(carName)) {
			throw new RuntimeException(NOT_ALLOWED_FORMAT_MESSAGE);
		}
	}

	private static boolean doesNotMatchCarName(String carName) {
		return COMPILED_CAR_NAME_PATTERN.matcher(carName).matches();
	}

	private static void isCarNameExceed(final String carName) {
		if (carName.length() > CAR_NAME_MAX_LENGTH) {
			throw new RuntimeException(EXCEED_LENGTH_ERROR_MESSAGE);
		}
	}

	private static void isCarNameEmpty(final String carName) {
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
