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
		validateCarNames(carNames);
		return splitByDelimAndTrimNames(carNames, DELIMITER);
	}

	private static void validateCarNames(String input) {
		if (input.length() == 0) {
			throw new IllegalArgumentException("[ERROR]: 공백을 입력할 수 없습니다.");
		}
	}

	private static List<String> splitByDelimAndTrimNames(String names, String delimiter) {
		return Arrays.stream(names.split(delimiter))
			.map(s -> s.trim())
			.collect(Collectors.toList());
	}

	public static int readRoundCount() {
		String roundCount = scanner.nextLine();
		validateRoundCount(roundCount);
		System.out.println();
		return Integer.parseInt(roundCount);
	}

	private static void validateRoundCount(String input) {
		if (input.equals("0") || !input.matches("[0-9]+")) {
			throw new IllegalArgumentException("[ERROR]: 자연수가 입력되어야 합니다.");
		}
	}
}
