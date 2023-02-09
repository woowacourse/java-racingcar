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
		return formatter(carNames);
	}

	public static int readRoundCount() {
		String roundCount = scanner.nextLine();
		validateRoundCount(roundCount);
		System.out.println();
		return Integer.parseInt(roundCount);
	}

	private static List<String> formatter(String carNames) {
		return Arrays.stream(carNames.split(DELIMITER))
			.map(s -> s.trim())
			.collect(Collectors.toList());
	}

	// TODO: validate input length
	private static void validateCarNames(String input) {
	}

	private static void validateRoundCount(String input) {
		if(input.equals("0") || !input.matches("[0-9]+")) {
			throw new IllegalArgumentException("[ERROR]: 자연수가 입력되어야 합니다.");
		}
		// TODO: validate max round count
	}
}
