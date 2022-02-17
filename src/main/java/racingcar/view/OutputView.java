package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;

import racingcar.domain.Car;

public class OutputView {
	public static final String RESULT_MESSAGE = "실행 결과";
	public static final String WINNER_MESSAGE = "가 최종 우승했습니다.";
	public static final String WINNER_JOIN_DELIMITER = ", ";

	public static void printCarPosition(List<String> cars) {
		cars.forEach(System.out::println);
		System.out.println();
	}

	public static void printResultMessage() {
		System.out.println(RESULT_MESSAGE);
	}

	public static void printWinners(List<Car> winners) {
		System.out.println(winners.stream()
			.map(Car::getName)
			.collect(Collectors.joining(WINNER_JOIN_DELIMITER))
			+ WINNER_MESSAGE
		);
	}
}
