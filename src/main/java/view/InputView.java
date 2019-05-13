package view;

import java.util.Scanner;

public class InputView {
	private static final Scanner SCANNER = new Scanner(System.in);
	private static final String INPUT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
	private static final String INPUT_TOTAL_ROUND_MESSAGE = "시도할 회수는 몇 회인가요?";

	public static String inputCarNames() {
		System.out.println(INPUT_CAR_NAMES_MESSAGE);
		return SCANNER.nextLine();
	}

	public static int inputTotalRound() {
		System.out.println(INPUT_TOTAL_ROUND_MESSAGE);
		return Integer.parseInt(SCANNER.nextLine());
	}
}
