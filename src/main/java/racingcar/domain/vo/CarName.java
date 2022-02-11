package racingcar.domain.vo;

import java.util.Objects;

public class CarName {

	private static final int CAR_NAME_MAX_LENGTH = 5;
	private static final String EXCEED_LENGTH_ERROR_MESSAGE = "이름은 최대 5자입니다.";
	private static final String ALLOWED_CHARACTERS = ".*[^0-9a-zA-Zㄱ-ㅎ가-힣_]+.*";
	private static final String NOT_ALLOWED_FORMAT_MESSAGE = "올바르지 않은 입력 형식입니다.";

	String name;

	public CarName(String name) {
		validateCarName(name);
		this.name = name;
	}

	public String get() {
		return name;
	}

	public static void validateCarName(String carName) {

		if (carName.length() > CAR_NAME_MAX_LENGTH) {
			throw new RuntimeException(EXCEED_LENGTH_ERROR_MESSAGE);
		}

		if (carName.matches(ALLOWED_CHARACTERS)) {
			throw new RuntimeException(NOT_ALLOWED_FORMAT_MESSAGE);
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
