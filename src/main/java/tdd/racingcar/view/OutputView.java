package tdd.racingcar.view;

import static java.util.stream.Collectors.*;

import java.util.List;

import tdd.racingcar.domain.Car;
import tdd.racingcar.domain.Record;
import tdd.racingcar.domain.Records;

public class OutputView {
	private static final String COLON = " : ";
	private static final String POSITION_MARK = "-";
	private static final String DELIMITER = ", ";

	private OutputView() {}

	public static void printRecords(Records records) {
		System.out.println("실행 결과");
		records.forEach(OutputView::printRecord);
	}

	public static void printRecord(Record record) {
		record.forEach(OutputView::printCar);
		System.out.println();
	}

	private static void printCar(final String name, final int position) {
		System.out.println(name + COLON + POSITION_MARK.repeat(position));
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
