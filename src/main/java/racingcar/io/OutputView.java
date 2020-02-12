package racingcar.io;

import racingcar.domain.Winners;

public class OutputView {
	public static void printResultTitle() {
		System.out.println("실행 결과\n");
	}

	public static void printWinners(Winners winners) {
		System.out.println(winners + "이(가) 우승했습니다.");
	}
}
