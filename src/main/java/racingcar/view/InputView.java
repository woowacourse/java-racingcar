package racingcar.view;

import java.util.Scanner;

public class InputView {
	private static final String GET_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
	private static final String GET_ITERATION_NO_MESSAGE = "시도할 회수는 몇회인가요?";
	private static final String ERROR_GET_POSITIVE_MESSAGE = "양수를 입력해주세요.";
	private static final String ERROR_GET_NOT_EMPTY_MESSAGE = "빈 값을 입력하셨습니다. 양수를 입력해주세요.";
	private static final String ERROR_GET_NON_ZERO_MESSAGE = "0을 입력하셨습니다. 양수를 입력해주세요.";
	private static final Scanner scanner = new Scanner(System.in);

	public static String getCarNames() {
		System.out.println(GET_CAR_NAMES_MESSAGE);
		return scanner.nextLine();
	}

	public static int getIterationNo() {
		System.out.println(GET_ITERATION_NO_MESSAGE);
		String input = scanner.nextLine();
		try {
			validIterationNo(input);
			return Integer.parseInt(input);
		} catch(RuntimeException e){
			System.out.println(e.getMessage());
			return getIterationNo();
		}
	}

	private static void validIterationNo(String input) {
		validEmptyInput(input);
		validPositiveInput(input);
		validNonZeroInput(input);
	}

	public static void validPositiveInput(String input) {
		if (!input.matches("[+]?\\d*(\\.\\d+)?")) {
			throw new RuntimeException(ERROR_GET_POSITIVE_MESSAGE);
		}
	}

	public static void validEmptyInput(String input) {
		if (input == null || input.isEmpty()) {
			throw new RuntimeException(ERROR_GET_NOT_EMPTY_MESSAGE);
		}
	}

	public static void validNonZeroInput(String input) {
		if (input.equals("0")) {
			throw new RuntimeException(ERROR_GET_NON_ZERO_MESSAGE);
		}
	}
}
