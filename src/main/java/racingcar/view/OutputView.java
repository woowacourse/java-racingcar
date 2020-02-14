package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import racingcar.domain.Car;

public class OutputView {
	private static final String GAGE = "-";
	private static final String COLON = " : ";
	private static final String COMMA = ", ";
	private static final String EMPTY = "";

	public static void showResult() {
		System.out.println("\n실행 결과");
	}

	public static void showRace(List<Car> cars) {
		for (Car car : cars) {
			String carName = car.getName();

			String resultOfMovement = Stream.generate(() -> GAGE)
				.limit(car.getPosition())
				.collect(Collectors.joining(EMPTY));

			System.out.println(String.join(COLON, carName, resultOfMovement));
		}
		System.out.println();
	}

	public static void showWinner(List<String> winners) {
		System.out.print(String.join(COMMA, winners));
		System.out.println("가 최종 우승했습니다.");
	}
}
