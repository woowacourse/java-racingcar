package racingcar.view;

import java.util.Scanner;

public class InputView {

	private static final String CAR_NAME_REGEX = ",";
	private static final int NUMBER_OF_TURN_BOUND = 1;
	private static final String ERROR_NEGATIVE_NUM = "[ERROR] 횟수는 1이상이어야 합니다.";
	private static final String ERROR_STRING_INPUT = "[ERROR] 횟수는 문자로 입력할 수 없습니다.";
	private static final Scanner SCANNER = new Scanner(System.in);

	public static String[] getCarNames() {
		return splitByColon(SCANNER.nextLine());
	}

	private static String[] splitByColon(String input) {
		return input.split(CAR_NAME_REGEX);
	}

	public static int getNumberOfTurn() {
		return isValidNum(SCANNER.nextLine());
	}

	private static int isValidNum(String input) {
		final int numberOfTurn = isInteger(input);
		isPositive(numberOfTurn);

		return numberOfTurn;
	}

	private static void isPositive(int numberOfTurn) {
		if (numberOfTurn < NUMBER_OF_TURN_BOUND) {
			throw new IllegalArgumentException(ERROR_NEGATIVE_NUM);
		}
	}

	private static int isInteger(String input) {
		int numberOfTurn;

		try {
			numberOfTurn = Integer.parseInt(input);
		} catch (Exception e) {
			throw new IllegalArgumentException(ERROR_STRING_INPUT);
		}

		return numberOfTurn;
	}

}
