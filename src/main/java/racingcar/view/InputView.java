package racingcar.view;

import java.util.Scanner;

public class InputView {
	private static final String POSITIVE_REGEX = "^[1-9]+[0-9]*$";
	private static final String GET_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
	private static final String GET_ITERATION_NUMBER_MESSAGE = "시도할 회수는 몇회인가요?";
	private static final String ERROR_NOT_POSITIVE_MESSAGE = "양수를 입력해주세요.";
	private static final String ERROR_EMPTY_INPUT_MESSAGE = "빈 값을 입력하셨습니다. 양수를 입력해주세요.";

	private static final Scanner scanner = new Scanner(System.in);

	private InputView() {
	}

	public static String getCarNames() {
		System.out.println(GET_CAR_NAMES_MESSAGE);
		return scanner.nextLine();
	}

	public static int getIterationNumber() {
		System.out.println(GET_ITERATION_NUMBER_MESSAGE);
		String input = scanner.nextLine();
		try {
			validateIterationNumber(input);
			return Integer.parseInt(input);
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
			return getIterationNumber();
		}
	}

	static void validateIterationNumber(String input) {
		validateEmptyInput(input);
		validatePositiveInput(input);
	}

	private static void validatePositiveInput(String input) {
		if (!input.matches(POSITIVE_REGEX)) {
			throw new RuntimeException(ERROR_NOT_POSITIVE_MESSAGE);
		}
	}

	private static void validateEmptyInput(String input) {
		if (input == null || input.isEmpty()) {
			throw new RuntimeException(ERROR_EMPTY_INPUT_MESSAGE);
		}
	}
}
