package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;

import racingcar.model.CarDto;

public class ResultView {
	private static final String JOIN_DELIMITER = ", ";

	private ResultView() {
	}

	public static void printGameResult(List<List<CarDto>> gameResult) {
		printBeforeGameResult();
		for (List<CarDto> OneGameResult : gameResult) {
			printOneGameResult(OneGameResult);
		}
	}

	private static void printOneGameResult(List<CarDto> cars) {
		cars.stream()
			.map(car -> car.getName() + " : " + "-".repeat(car.getPosition()))
			.forEach(System.out::println);
		printEmptyLine();
	}

	public static void printWinners(List<CarDto> cars) {
		List<String> winners = cars.stream()
			.map(CarDto::getName)
			.collect(Collectors.toList());
		System.out.println(String.join(JOIN_DELIMITER, winners) + "가 최종 우승했습니다.");
	}

	public static void printBeforeGameResult() {
		printEmptyLine();
		System.out.println("실행 결과");
	}

	public static void printEmptyLine() {
		System.out.println();
	}
}
