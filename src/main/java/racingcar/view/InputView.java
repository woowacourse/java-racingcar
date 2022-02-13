package racingcar.view;

import java.util.List;
import java.util.Scanner;
import racingcar.util.Utils;

public class InputView {
	private static final String REQUEST_CARS_NAME = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
	private static final String REQUEST_ROUND_VALUE = "시도할 회수는 몇회인가요?";
	private static final Scanner SCANNER = new Scanner(System.in);

	public static String getInput() {
		return SCANNER.nextLine();
	}

	public static List<String> getCarsName() {
		System.out.println(REQUEST_CARS_NAME);
		try {
			List<String> carsName = Utils.convertCarsName(getInput());
			Utils.validateCarsName(carsName);
			return carsName;
		} catch (IllegalArgumentException e) {
			OutputView.printErrorMessage(e);
			return getCarsName();
		}
	}


	public static int getRound() {
		System.out.println(REQUEST_ROUND_VALUE);
		try {
			String inputRound = getInput();
			Utils.validateRoundNumber(inputRound);
			Utils.validateRoundMinimumOne(inputRound);
			return Integer.parseInt(inputRound);
		} catch (IllegalArgumentException e) {
			OutputView.printErrorMessage(e);
			return getRound();
		}
	}

}
