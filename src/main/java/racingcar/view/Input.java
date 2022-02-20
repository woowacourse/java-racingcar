package racingcar.view;

import java.util.Scanner;

public class Input {

	private static final String REQUEST_CARS_NAME = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
	private static final String REQUEST_COUNT = "시도할 회수는 몇회인가요?";
	private static final Scanner scanner = new Scanner(System.in);

	public String inputCarNames() {
		System.out.println(REQUEST_CARS_NAME);
		return scanner.nextLine();
	}

	public String inputCount() {
		System.out.println(REQUEST_COUNT);
		return scanner.nextLine();
	}

}
