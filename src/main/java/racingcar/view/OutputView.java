package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;

import racingcar.domain.Car;

public class OutputView {
	private static final String STRING_JOIN_DELIMITER = " : ";
	private static final String MOVE_EXPRESSION = "-";
	public static final String RESULT_MESSAGE = "실행 결과";
	public static final String WINNER_MESSAGE = "가 최종 우승했습니다.";
	public static final String WINNER_JOIN_DELIMITER = ", ";

	public static void printCarPosition(List<Car> cars) {
		cars.stream()
			.map(car -> car.getName()
				+ STRING_JOIN_DELIMITER
				+ MOVE_EXPRESSION.repeat(Math.max(0, car.getPosition().toInt())))
			.forEach(System.out::println);
		System.out.println();
	}

	public static void printResultMessage() {
		System.out.println(RESULT_MESSAGE);
	}

	public static void printWinners(List<String> winners) {
		System.out.println(winners.stream()
			.collect(Collectors.joining(WINNER_JOIN_DELIMITER))
			+ WINNER_MESSAGE
		);
	}
}
