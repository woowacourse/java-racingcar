package racingcar.view;

import racingcar.validator.InputValidator;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
	private static final Scanner scanner = new Scanner(System.in);

	public static List<String> inputCarNames() {
		System.out.println("경주할 자동차를 입력하세요. (이름은 쉼표(,) 기준으로 구분");
		String carNames;
		boolean result;

		do {
			carNames = scanner.nextLine();
			result = InputValidator.validateAll(carNames);
		}
		while (!result);

		return Arrays.asList(carNames.split(","));
	}

	public static int inputNumberOfTimes() {
		System.out.println("시도할 회수는 몇회인가요?");
		String numberOfTimes;
		boolean result;

		do {
			numberOfTimes = scanner.nextLine();
			result = InputValidator.validateNaturalNumber(numberOfTimes);
		}
		while (!result);

		return Integer.parseInt(numberOfTimes);
	}
}
