package racingcargame.utils;

import java.util.regex.Pattern;

public class RaceCountInputValidator {
	private static final String RACE_COUNT_PATTERN = "[0-9]+";
	private static final String INCORRECT_START_COUNT = "0";
	private static final String NOT_RIGHT_COUNT_ERROR_MESSAGE = "[error] 경주횟수는 0부터 9까지의 숫자만 입력해주세요.";
	private static final String RACE_COUNT_START_ZERO_ERROR_MESSAGE = "[error] 경주횟수는 1이상의 값을 입력해주세요.";
	private static final String EMPTY_RACE_COUNT_ERROR_MESSAGE = "[error] 경주횟수를 입력해주세요.";

	private RaceCountInputValidator() {
	}

	public static String validateRaceCount(String raceCount) {
		if (isRightNumberRaceCount(raceCount)) {
			return raceCount;
		}
		throw new IllegalArgumentException();
	}

	private static boolean isRightNumberRaceCount(String raceCount) {
		if (!Pattern.matches(RACE_COUNT_PATTERN, raceCount)) {
			throw new IllegalArgumentException(NOT_RIGHT_COUNT_ERROR_MESSAGE);
		}
		if (raceCount.startsWith(INCORRECT_START_COUNT)) {
			throw new IllegalArgumentException(RACE_COUNT_START_ZERO_ERROR_MESSAGE);
		}
		if (raceCount == null) {
			throw new IllegalArgumentException(EMPTY_RACE_COUNT_ERROR_MESSAGE);
		}

		return true;
	}
}
