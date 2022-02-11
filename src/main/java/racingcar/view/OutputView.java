package racingcar.view;

import static java.lang.System.*;

import racingcar.domain.Car;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

	private static final String DECLARE_WINNER_MESSAGE = "가 최종 우승했습니다.";
	private static final String EXECUTION_RESULT_MESSAGE = "실행 결과";

	public static void showGameResult(List<Car> winners) {
		String winnerNames = winners.stream()
			.map(Car::getName)
			.collect(Collectors.joining(","));
		out.println(winnerNames + DECLARE_WINNER_MESSAGE);
	}

	public static void showCurrentStatus(List<Car> cars) {
		cars.forEach(out::println);
		out.println();
	}

	public static void printResultMessage() {
		out.println(EXECUTION_RESULT_MESSAGE);
	}
}
