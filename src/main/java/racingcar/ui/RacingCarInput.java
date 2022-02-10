package racingcar.ui;

import static racingcar.RacingCarMain.*;

public class RacingCarInput {
	private static final String CAR_NAME_INPUT_MESSAGE
		= "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
	private static final String ROUND_INPUT_MESSAGE
		= "시도할 회수는 몇회인가요?";

	public static String carNameInput() {
		System.out.println(CAR_NAME_INPUT_MESSAGE);
		return sc.nextLine();
	}

	public static String roundInput() {
		System.out.println(ROUND_INPUT_MESSAGE);
		return sc.nextLine();
	}
}
