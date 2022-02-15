package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;

import racingcar.model.CarDto;

public class ResultView {
	private static final String BEFORE_GAME_RESULT_MESSAGE = "실행 결과";
	private static final String JOIN_DELIMITER = ", ";
	private static final String WINNERS_RESULT_SUFFIX = "가 최종 우승했습니다.";

	public static void printGameResult(List<CarDto> cars) {
		cars.stream()
			.map(car -> car.getName() + " : " + "-".repeat(car.getPosition()))
			.forEach(System.out::println);
		printEmptyLine();
	}

	public static void printWinners(List<CarDto> cars) {
		List<String> winners = cars.stream()
			.map(CarDto::getName)
			.collect(Collectors.toList());
		System.out.println(String.join(JOIN_DELIMITER, winners) + WINNERS_RESULT_SUFFIX);
	}

	public static void printBeforeGameResult() {
		printEmptyLine();
		System.out.println(BEFORE_GAME_RESULT_MESSAGE);
	}

	public static void printEmptyLine() {
		System.out.println();
	}
}
