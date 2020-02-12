package utils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class InputUtil {
	public static final String SPACE = " ";
	public static final String EMPTY = "";
	public static final String COMMA = ",";
	public static final int MINIMUM_NUMBER_OF_CARS = 2;
	public static final int LIMIT = -1;

	public static void readCars(String input) {
		List<String> cars = Arrays.asList(input.replace(SPACE, EMPTY)
				.split(COMMA, LIMIT));

		validateLengthOfCarName(cars);
		validateDuplicateCarName(cars);
		validateNumberOfCars(cars);
	}

	private static void validateLengthOfCarName(List<String> cars) {
		cars.stream()
				.filter(name -> (name.length() < 1) || (name.length() > 5))
				.findFirst()
				.ifPresent(value -> {
					throw new IllegalArgumentException(value + "의 길이가 1~5 사이에 있지 않습니다.");
				});
	}

	private static void validateDuplicateCarName(List<String> cars) {
		if (!cars.stream()
			.allMatch(new HashSet<>()::add)) {
			throw new IllegalArgumentException("중복된 이름이 존재합니다.");
		}
	}

	private static void validateNumberOfCars(List<String> cars) {
		if (cars.size() < MINIMUM_NUMBER_OF_CARS) {
			throw new IllegalArgumentException("자동차는 최소 2대 이상이어야 합니다.");
		}
	}
}
