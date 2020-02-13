package racingcar.view;

import racingcar.domain.Car;

public class OutputView {

	public static void printRoundResult(Car car) {
		System.out.println(car);
	}

	public static void printWinners(String winners) {
		System.out.println(winners + "가 최종 우승했습니다.");
	}

}
