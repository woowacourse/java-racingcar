package racingcar.view;

import java.util.List;

import racingcar.domain.Car;

public class OutputView {

	private static final String RESULT_MESSAGE ="실행결과";
	private static final String WINNER_MESSAGE = "가 최종 우승했습니다.";

	public static void printResultMessage() {
		System.out.println();
		System.out.println(RESULT_MESSAGE);
	}

	public static void printRacingInfo(List<Car> cars) {
		for (Car car : cars) {
			System.out.print(car.getName() + " : ");
			printPositionBar(car.getPosition());
		}
		System.out.println();
	}

	private static void printPositionBar(int position) {
		for (int i = 0; i < position; i++) {
			System.out.print("-");
		}
		System.out.println();
	}

	public void printWinnersMessage(List<String> winnerNames) {
		String names = String.join(", ", winnerNames);
		System.out.println(names + WINNER_MESSAGE);
	}
}
