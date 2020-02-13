package racing.view;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import racing.domain.Car;

public class OutputView {
	private static final String WINNER_NAME_DELIMITER = ",";
	private static final String POSITION_VIEWER = "-";

	private static void printEachPosition(Car car) {
		System.out.println(car.getName() + " : "
				+ IntStream.range(0, car.getPosition())
					.mapToObj(x -> POSITION_VIEWER)
					.collect(Collectors.joining()));
	}

	public static void printAllPosition(List<Car> cars) {
		cars.forEach(OutputView::printEachPosition);
		System.out.println();
	}

	public static void printWinner(List<Car> winners) {
		String winnersName = winners.stream().map(Car::getName).collect(Collectors.joining(WINNER_NAME_DELIMITER));
		System.out.print(winnersName + " 최종 우승했습니다.");
	}
}
