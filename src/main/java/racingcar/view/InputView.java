package racingcar.view;

import java.util.Scanner;

public class InputView {
	private static final int POSITIVE_CRITERIA = 1;
	private static final String EMPTY = "";
	private static final Scanner scanner = new Scanner(System.in);

	public static String receiveNameInput() {
		System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
		String input = scanner.nextLine();

		validateNullOrEmpty(input);

		return input;
	}

	public static int receiveCountInput() {
		System.out.println("시도할 회수는 몇회인가요?");
		String input = scanner.nextLine();

		validateNullOrEmpty(input);
		final int number = Integer.parseInt(input);
		validatePositiveNumber(number);
		return number;
	}

	private static void validateNullOrEmpty(String input) {
		if (EMPTY.equals(input) || input == null) {
			throw new IllegalArgumentException("입력이 없습니다.");
		}
	}

	private static void validatePositiveNumber(int countInput) {
		if (countInput < POSITIVE_CRITERIA) {
			throw new IllegalArgumentException(POSITIVE_CRITERIA + "이상의 수를 입력해야합니다.");
		}
	}

}
