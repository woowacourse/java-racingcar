package racing.view;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import racing.domain.Car;
import racing.domain.RacingGame;

public class OutputView {
	private static final String WINNER_NAME_DELIMITER = ",";
	private static final String POSITION_VIEWER = "-";
	private static final String NEW_LINE = "\n";

	public static void printRoundPosition(RacingGame racingGame) {
		String carNameAndPosition = racingGame.getCars()
			.stream()
			.map(OutputView::joiningCarNameAndPositionAsView)
			.collect(Collectors.joining(NEW_LINE));
		System.out.println(carNameAndPosition + NEW_LINE);
	}

	private static String joiningCarNameAndPositionAsView(Car car) {
		return car.getName() + " : " + OutputView.showPosition(car.getPosition());
	}

	private static String showPosition(int position) {
		return IntStream.range(0, position)
			.mapToObj(x -> POSITION_VIEWER)
			.collect(Collectors.joining());
	}

	public static void printWinner(List<Car> winners) {
		String winnersName = winners.stream()
			.map(Car::getName)
			.collect(Collectors.joining(WINNER_NAME_DELIMITER));
		System.out.print(winnersName + " 최종 우승했습니다.");
	}
}
