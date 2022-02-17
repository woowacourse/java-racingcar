package racingcar.Util;

import java.util.Arrays;
import java.util.Random;

public class Utils {
	public static final String CAR_NAME_INPUT_REGEX = ",";
	public static final String ERROR_NOT_INTEGER = "[ERROR] 이동횟수는 숫자로 입력해야합니다.";
	public static final int RANDOM_NUMBER_BOUND = 10;

	public static String[] splitter(String names) {
		String[] splitNames = names.split(CAR_NAME_INPUT_REGEX);
		Arrays.setAll(splitNames, i -> splitNames[i].trim());
		return splitNames;
	}

	public static int strToInt(String givenString) {
		try {
			return Integer.parseInt(givenString);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(ERROR_NOT_INTEGER);
		}
	}

	public static int makeRandom() {
		Random random = new Random();
		return random.nextInt(RANDOM_NUMBER_BOUND);
	}
}
