package racingcar.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
	private static final String DELIMITER = ",";
	private static final Scanner scanner = new Scanner(System.in);

	public static List<String> readCarNames() {
		String carNames = scanner.nextLine();
		try {
			validateCarNames(carNames);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		return splitByDelimiter(carNames);
	}

	public static int readRoundCount() {
		String roundCount = scanner.nextLine();
		try {
			validateRoundCount(roundCount);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		return Integer.parseInt(roundCount);
	}

	private static List<String> splitByDelimiter(String carNames) {
		return List.of(carNames.split(DELIMITER));
	}

	// TODO: validate input length
	private static void validateCarNames(String input) {
	}

	private static void validateRoundCount(String input) {
		if(!input.matches("[1-9]+")) {
			throw new IllegalArgumentException("[ERROR]");
		}
		// TODO: validate max round count
	}
}
