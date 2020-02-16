package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarGenerator {
	private static final String COMMA = ",";
	private static final int MIN_LENGTH = 1;
	private static final String NOT_INPUT_MESSAGE = "이름을 입력하지 않았습니다.";

	public static List<Car> create(String carsName) {
		String[] carNames = carsName.split(COMMA);
		validateLength(carNames);

		List<Car> cars = new ArrayList<>();
		Arrays.stream(carNames)
			.forEach(name -> cars.add(new Car(name)));

		return cars;
	}

	private static void validateLength(String[] carNames) {
		if (carNames.length < MIN_LENGTH) {
			throw new IllegalArgumentException(NOT_INPUT_MESSAGE);
		}
	}
}
