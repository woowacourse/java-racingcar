package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import racingcar.model.Car;

public class OutputView {

	private static final String RESULT_MESSAGE = "\n실행 결과";
	private static final String COLON = ":";
	private static final String DASH = "-";
	private static final String WINNER_MESSAGE = "최종 우승자 : ";
	private static final String COMMA = ", ";

	public void printResultMessage() {
		System.out.println(RESULT_MESSAGE);
	}

	public void printResult(final List<Car> cars) {
		cars.forEach(car -> System.out.println(createResultString(car)));
		System.out.println();
	}

	private String createResultString(final Car car) {
		return car.getCarName() + COLON + progress(car.getPosition());
	}

	private String progress(final int position) {
		return IntStream.range(0, position)
			.mapToObj(i -> DASH)
			.collect(Collectors.joining());
	}

	public void printWinners(final List<String> winners) {
		System.out.println(createWinnersString(winners));
	}

	private String createWinnersString(final List<String> winners) {
		return WINNER_MESSAGE + String.join(COMMA, winners);
	}
}
