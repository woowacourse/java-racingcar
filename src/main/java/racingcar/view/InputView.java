package racingcar.view;

import java.util.Scanner;

public class InputView {
	private static final String EMPTY = "";
	private static Scanner scanner = new Scanner(System.in);

	public static String receiveNameInput() {
		System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
		String input = scanner.nextLine();

		validate(input);

		return input;
	}

	public static int receiveCountInput() {
		System.out.println("시도할 회수는 몇회인가요?");
		String input = scanner.nextLine();

		validate(input);

		return Integer.parseInt(input);
	}

	public static void validate(String input) {
		if (EMPTY.equals(input) || input == null) {
			throw new IllegalArgumentException("입력이 없습니다.");
		}
	}
}
