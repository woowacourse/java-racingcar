package racingcar.view;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import racingcar.model.Car;

public class ResultView {
	private static final String BEFORE_GAME_RESULT_MESSAGE = "실행 결과";
	private static final String JOIN_DELIMITER = ", ";
	private static final String WINNERS_RESULT_SUFFIX= "가 최종 우승했습니다.";
	public static void printGameResult(List<Car> cars) {
		for (Car car : cars) {
			System.out.print(car.getName() + " : ");
			System.out.println("-".repeat(car.getPosition()));
		}
		System.out.println();
	}

	public static void printWinners(List<Car> cars) {
		List<String> winners = cars.stream()
			.map(Car::getName)
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
