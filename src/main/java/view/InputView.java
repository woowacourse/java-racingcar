package view;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
	private static final int MIN_ROUND = 1;
	private static final int NAME_LENGTH_MAX = 5;
	private static final int NAME_LENGTH_MIN = 1;
	private static final Scanner SCANNER = new Scanner(System.in);
	private static final String CAR_NAMES_SPLIT_REGEX = ",";
	private static final String INPUT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
	private static final String INPUT_TOTAL_ROUND_MESSAGE = "시도할 회수는 몇 회인가요?";
	private static final String ILLEGAL_NUMBER_MESSAGE = "올바른 수를 입력해주세요.";
	private static final String ILLEGAL_ROUND_MESSAGE = "1 이상의 수를 입력해주세요.";
	private static final String NAME_LENGTH_OUT_OF_BOUNDS_EXCEPTION_MESSAGE = "1 ~ 5자의 이름을 입력해주세요.";
	private static final String DUPLICATED_NAME_EXCEPTION_MESSAGE = "중복되지 않은 이름을 입력해주세요.";
	private static final String NULL_NAMES_LENGTH_EXCEPTION_MESSAGE = "올바른 이름을 입력해주세요.";

	public static String[] inputCarNames() {
		System.out.println(INPUT_CAR_NAMES_MESSAGE);

		try {
			String[] carNames = SCANNER.nextLine().replaceAll(" ", "").split(CAR_NAMES_SPLIT_REGEX);
			validateCarNames(carNames);

			return carNames;
		} catch (IllegalArgumentException e) {
			OutputView.printIllegalArgumentMessage(e.getMessage());
			return inputCarNames();
		}
	}

	public static int inputTotalRound() {
		System.out.println(INPUT_TOTAL_ROUND_MESSAGE);
		try {
			int totalRound = Integer.parseInt(SCANNER.nextLine());

			if (!validateTotalRound(totalRound)) {
				System.out.println(ILLEGAL_ROUND_MESSAGE);
				return inputTotalRound();
			}
			return totalRound;

		} catch (NumberFormatException e) {
			System.out.println(ILLEGAL_NUMBER_MESSAGE);
			return inputTotalRound();
		}
	}

	private static void validateCarNames(String[] carNames) {
		if (hasDuplicatedNames(carNames)) {
			throw new IllegalArgumentException(DUPLICATED_NAME_EXCEPTION_MESSAGE);
		}
		if (carNames.length == 0) {
			throw new IllegalArgumentException(NULL_NAMES_LENGTH_EXCEPTION_MESSAGE);
		}
		Arrays.stream(carNames).forEach(carName -> {
			if (!checkCarNameLength(carName)) {
				throw new IllegalArgumentException(NAME_LENGTH_OUT_OF_BOUNDS_EXCEPTION_MESSAGE);
			}
		});
	}

	private static boolean hasDuplicatedNames(String[] carNames) {
		List<String> names = Arrays.stream(carNames).collect(Collectors.toList());
		return !(names.size() == new HashSet<String>(names).size());
	}

	private static boolean checkCarNameLength(String carName) {
		return carName.length() >= NAME_LENGTH_MIN && carName.length() <= NAME_LENGTH_MAX;
	}

	private static boolean validateTotalRound(int totalRound) {
		return totalRound >= MIN_ROUND;
	}
}
