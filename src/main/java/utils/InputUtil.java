package utils;

import java.util.Arrays;
import java.util.List;

public class InputUtil {
	public static final String SPACE = " ";
	public static final String EMPTY = "";
	public static final String COMMA = ",";

	public static void readCars(String input) {
		List<String> cars = Arrays.asList(input.replace(SPACE, EMPTY)
				.split(COMMA));

		validateCarNameLength(cars);
	}

	private static void validateCarNameLength(List<String> cars) {
		cars.stream()
				.filter(name -> (name.length() < 1) || (name.length() > 5))
				.findFirst()
				.ifPresent(value -> {
					throw new IllegalArgumentException(value + "의 길이가 1~5 사이에 있지 않습니다.");
				});
	}


}
