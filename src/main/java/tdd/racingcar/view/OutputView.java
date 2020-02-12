package tdd.racingcar.view;

import static java.util.stream.Collectors.*;

import java.util.List;

import tdd.racingcar.domain.Car;
import tdd.racingcar.domain.Cars;

public class OutputView {
	private static final String COLON = " : ";
	private static final String POSITION_MARK = "-";
	private static final String DELIMITER = ", ";

	public static void printResultMessage() {
		System.out.println("실행 결과");
	}

	public static void printCars(final Cars cars) {
		cars.forEach(OutputView::printCar);
		emptyLine();
	}

	private static void printCar(final Car car) {
		System.out.println(car.getName() + COLON + POSITION_MARK.repeat(car.getPosition()));
	}

	private static void emptyLine() {
		System.out.println();
	}

	public static void printWinners(final List<Car> winners) {
		System.out.println(
			winners.stream()
				.map(Car::getName)
				.collect(joining(DELIMITER)) +
				"가 최종 우승했습니다."
		);
	}
}
