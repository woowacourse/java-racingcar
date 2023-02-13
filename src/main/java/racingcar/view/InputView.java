package racingcar.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
	private static final String DELIMITER = ",";
	private static final int ROUND_MIN = 1;
	private static final int ROUND_MAX = 10;
	private static final Scanner scanner = new Scanner(System.in);

	public static List<String> readCarNames() {
		final String carNames = scanner.nextLine();
		validateCarNames(carNames);
		return splitByDelimAndTrimNames(carNames, DELIMITER);
	}

	private static void validateCarNames(final String input) {
		if (input.isBlank()) {
			throw new IllegalArgumentException("[ERROR]: 공백을 입력할 수 없습니다.");
		}
	}

	private static List<String> splitByDelimAndTrimNames(final String names, final String delimiter) {
		return Arrays.stream(names.split(delimiter))
			.map(s -> s.trim())
			.collect(Collectors.toList());
	}

	public static int readRoundCount() {
		final String roundCount = scanner.nextLine();
		validateRoundCount(roundCount);
		System.out.println();
		return Integer.parseInt(roundCount);
	}

	private static void validateRoundCount(final String input) {
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
		if (num >= minInclusive && num <= maxInclusive) {
			return true;
		}
		return false;
	}
}
