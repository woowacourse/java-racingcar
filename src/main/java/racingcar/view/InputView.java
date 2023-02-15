package racingcar.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
	private static final String DELIMITER = ",";
	private static final Scanner scanner = new Scanner(System.in);

	public static List<String> readCarNames() {
		String carNames = scanner.nextLine();
		InputValidator.validateBlankedNames(carNames);
		return splitByDelimAndTrimNames(carNames, DELIMITER);
	}

	private static List<String> splitByDelimAndTrimNames(final String names, final String delimiter) {
		return Arrays.stream(names.split(delimiter))
			.map(s -> s.trim())
			.collect(Collectors.toList());
	}

	public static int readRoundCount() {
		String roundCount = scanner.nextLine();
		InputValidator.validateRoundCount(roundCount);
		System.out.println();
		return Integer.parseInt(roundCount);
	}
}
