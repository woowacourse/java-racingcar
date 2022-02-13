package racingcar.view;

import static java.lang.System.*;

import java.util.Scanner;

public class InputView {

	private static final String ASK_CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
	private static final String ASK_ROUND_NUMBER_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";

	private static final Scanner scanner = new Scanner(System.in);

	public static String inputCarNames() {
		out.println(ASK_CAR_NAME_INPUT_MESSAGE);
		return scanner.nextLine();
	}

	public static int inputRoundNumber() {
		System.out.println(ASK_ROUND_NUMBER_INPUT_MESSAGE);
		return Integer.parseInt(scanner.nextLine());
	}

	public static void terminateScanner() {
		scanner.close();
	}
}
