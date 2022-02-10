package racingcar.view;

import java.util.ArrayList;
import java.util.List;

import racingcar.model.Car;

public class ResultView {
	private static final String BEFORE_GAME_RESULT_MESSAGE = "실행 결과";

	public static void printGameResult(List<Car> cars) {
		for (Car car : cars) {
			System.out.print(car.getName() + " : ");
			System.out.println("-".repeat(car.getPosition()));
		}
		System.out.println();
	}

	public static void printWinners(List<Car> cars) {
		List<String> winners = new ArrayList<>();
		for (Car car : cars) {
			winners.add(car.getName());
		}
		System.out.println(String.join(", ", winners) + "가 최종 우승했습니다.");
	}

	public static void printBeforeGameResult() {
		printEmptyLine();
		System.out.println(BEFORE_GAME_RESULT_MESSAGE);
	}

	public static void printEmptyLine() {
		System.out.println();
	}
}
