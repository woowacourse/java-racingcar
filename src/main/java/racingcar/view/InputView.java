package racingcar.view;

import java.util.Scanner;

public class InputView {
	public static final String REQUIRE_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
	public static final String REQUIRE_GAME_TURN_MESSAGE = "시도할 회수는 몇회인가요?";
	
	public static Scanner scanner = new Scanner(System.in);

	public static String getCarNames() {
		System.out.println(REQUIRE_CAR_NAMES_MESSAGE);
		return scanner.nextLine();
	}

	public static String getGameTurn() {
		System.out.println(REQUIRE_GAME_TURN_MESSAGE);
		return scanner.nextLine();
	}
}
