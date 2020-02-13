package racing.view;

import java.util.List;
import java.util.stream.Collectors;

import racing.domain.Car;
import racing.domain.RacingGame;

public class OutputView {
	private static final String WINNER_NAME_DELIMITER = ",";
	public static final String POSITION_VIEWER = "-";

	public static void printRoundPosition(RacingGame racingGame) {
		System.out.println(racingGame.toString());
		System.out.println();
	}

	public static void printWinner(List<Car> winners) {
		String winnersName = winners.stream().map(Car::getName).collect(Collectors.joining(WINNER_NAME_DELIMITER));
		System.out.print(winnersName + " 최종 우승했습니다.");
	}
}
