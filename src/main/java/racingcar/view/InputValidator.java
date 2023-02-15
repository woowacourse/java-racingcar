package racingcar.view;

public class InputValidator {
	private static final int ROUND_MIN = 1;
	private static final int ROUND_MAX = 10;

	public static void validateBlankedNames(final String input) {
		if (input.isBlank()) {
			throw new IllegalArgumentException("[ERROR]: 공백을 입력할 수 없습니다.");
		}
	}

	public static void validateRoundCount(final String input) {
		if (!isInputInGivenRange(input, ROUND_MIN, ROUND_MAX)) {
			throw new IllegalArgumentException("[ERROR]: 1 이상 10 이하의 자연수가 입력되어야 합니다.");
		}
	}

	private static boolean isInputInGivenRange(final String input, final int minInclusive, final int maxInclusive) {
		int parsedInput;
		try {
			parsedInput = Integer.parseInt(input);
			return isNumberInGivenRange(parsedInput, minInclusive, maxInclusive);
		} catch (IllegalArgumentException e) {
		}
		return false;
	}

	private static boolean isNumberInGivenRange(final int num, final int minInclusive, final int maxInclusive) {
		return num >= minInclusive && num <= maxInclusive;
	}
}
