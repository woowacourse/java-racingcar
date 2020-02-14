package racingcar.view;

import racingcar.domain.Car;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
	private static final String NEW_LINE = System.lineSeparator();
	private static final String COMMA_DELIMITER = ", ";
	private static final String DASH = "-";
	private static final String COLON = " : ";

	public static void printExceptionMessage(String message) {
		System.out.println(message);
	}

	public static void printCurrentPosition(List<Car> cars) {
		String currentPosition = cars.stream()
				.map(OutputView::positionToDash)
				.collect(Collectors.joining(NEW_LINE));

		System.out.println(currentPosition + NEW_LINE);
	}

	public static void printRaceStart() {
		System.out.println(NEW_LINE + "레이스 시작!!!!!!");
	}

	public static void printWinnersName(List<Car> winners) {
		String winnersName = winners.stream()
				.map(Car::getName)
				.collect(Collectors.joining(COMMA_DELIMITER));

		System.out.println(winnersName + " 우승!!!!!!!!");
	}

	private static String positionToDash(Car car) {
		StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append(car.getName()).append(COLON);
		for (int i = 0; i < car.getPosition(); i++) {
			stringBuilder.append(DASH);
		}

		return stringBuilder.toString();
	}
}
