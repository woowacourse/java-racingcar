package racingcar.view;

import java.util.Scanner;

import racingcar.util.Converter;

public class InputView {

	private static final String CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
	private static final String ATTEMPT_NUMBER_MESSAGE = "시도할 회수는 몇회인가요?";

	private static final Scanner scanner = new Scanner(System.in);

	public static String getCarNames() {
		System.out.println(CAR_NAMES_MESSAGE);
		return scanner.nextLine();
	}

	public static int getAttemptNumber() {
		System.out.println(ATTEMPT_NUMBER_MESSAGE);
		return Converter.toInteger(scanner.nextLine());
	}
}