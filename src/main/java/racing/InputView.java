package racing;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
	public static final int MAX_LENGTH = 5;
	public static final int MIN_LENGTH = 1;

	public Scanner input() {
		return new Scanner(System.in);
	}

	public static String inputCarNames(Scanner input) {
		System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
		return input.nextLine();
	}

	public static int inputRoundNumber(Scanner input) {
		System.out.println("시도할 회수는 몇회인가요?");
		return input.nextInt();
	}

	public static List<String> splitAsComma(String value) {
		return Arrays.asList(value.split(","));
	}

	public static boolean checkLength(List<String> input) {
		return input.stream().allMatch(InputView::isRightLength);
	}

	private static boolean isRightLength(String input) {
		return input.length() >= MIN_LENGTH && input.length() <= MAX_LENGTH;
	}
}
