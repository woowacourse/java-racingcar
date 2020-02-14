package tdd.racingcar.view;

import static java.util.stream.Collectors.*;

import java.util.List;

import tdd.racingcar.domain.Car;
import tdd.racingcar.domain.Record;

public class OutputView {
	private static final String COLON = " : ";
	private static final String POSITION_MARK = "-";
	private static final String DELIMITER = ", ";

	private OutputView() {
	}

	public static void printResultMessage() {
		System.out.println("실행 결과");
	}

	public static void printRecord(Record record) {
		record.forEach(OutputView::printCar);
		emptyLine();
	}

	private static void printCar(final String name, final int position) {
		System.out.println(name + COLON + POSITION_MARK.repeat(position));
	}

	private static void emptyLine() {
		System.out.println();
	}

	public static void printWinners(List<Car> winners) {
		System.out.println(
				winners.stream()
						.map(Car::getName)
						.collect(joining(DELIMITER)) +
						"가 최종 우승했습니다."
		);
	}
}
