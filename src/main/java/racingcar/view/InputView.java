package racingcar.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
	private static final String SPLIT_DELIMITER = ",";
	private static final Scanner scanner = new Scanner(System.in);

	public static List<String> readCarNames() {
		String carNames = scanner.nextLine();
		validateCarNames(carNames);
		return splitCarNames(carNames);
	}

	private static void validateCarNames(String input) {
		if (input.length() == 0) {
			throw new IllegalArgumentException("[ERROR]: 공백을 입력할 수 없습니다.");
		}
	}

	private static List<String> splitCarNames(String carNames) {
		return Arrays.stream(carNames.split(SPLIT_DELIMITER))
			.map(String::trim)
			.collect(Collectors.toList());
	}

	public static int readRoundCount() {
		int roundCount = parseToInt(scanner.nextLine());
		validateRoundCount(roundCount);
		return roundCount;
	}

	private static int parseToInt(String input) {
		try {
			return Integer.parseInt(input);
		} catch (Exception e) {
			throw new NumberFormatException("[ERROR]: 숫자가 아닌 값을 입력하였습니다. 숫자로 입력해주세요");
		}
	}

	private static void validateRoundCount(int roundCount) {
		if (roundCount <= 0) {
			throw new IllegalArgumentException("[ERROR]: 1 이상의 값이 입력되어야 합니다.");
		}
	}
}
