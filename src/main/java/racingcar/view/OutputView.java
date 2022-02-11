package racingcar.view;

import racingcar.domain.Car;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

	private static final String DECLARE_WINNER_MESSAGE = "가 최종 우승했습니다.";
	private static final String EXECUTION_RESULT_MESSAGE = "실행 결과";

	public static void showGameResult(List<Car> winners) {
		String winnerNames = winners.stream().map(car -> car.getName()).collect(Collectors.joining(","));
		System.out.println(winnerNames + DECLARE_WINNER_MESSAGE);
	}

	public static void showCurrentStatus(List<Car> cars) {
		cars.forEach(car -> car.printPosition());
		System.out.println();
	}

	public static void printResultMessage() {
		System.out.println(EXECUTION_RESULT_MESSAGE);
	}
}
