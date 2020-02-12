package racingcar.domain;

public class Car {
	public static final int MINIMUM_LENGTH_OF_CAR_NAME = 1;
	public static final int MAXIMUM_LENGTH_OF_CAR_NAME = 5;

	private final String name;

	public Car(String name) {
		validateLengthOfCarName(name);
		this.name = name;
	}

	private void validateLengthOfCarName(String name) {
		if ((name.length() < MINIMUM_LENGTH_OF_CAR_NAME) || (name.length() > MAXIMUM_LENGTH_OF_CAR_NAME)) {
			throw new IllegalArgumentException(name + "의 길이가 1~5 사이에 있지 않습니다.");
		}
	}
}
