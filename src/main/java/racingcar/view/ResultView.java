package racingcar.view;

import racingcar.model.CarDto;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
	private static final String BEFORE_GAME_RESULT_MESSAGE = "실행 결과";
	private static final String JOIN_DELIMITER = ", ";
	private static final String WINNERS_RESULT_SUFFIX = "가 최종 우승했습니다.";
	private static final String SUFFIX_PRINT_RESULT_CAR_NAME = " : ";
	private static final String CAR_POSITION_STATUS_EXPRESSION = "-";

	public static void printGameResult(List<CarDto> cars) {
		for (CarDto car: cars) {
			System.out.println(car.getName() + SUFFIX_PRINT_RESULT_CAR_NAME + CAR_POSITION_STATUS_EXPRESSION.repeat(car.getPosition()));
		}
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
