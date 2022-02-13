package racingcar.views;

import java.util.List;

import racingcar.models.Car;
import racingcar.utils.RacingGameMessage;

public class Output {

	public void printResultMessage() {
		System.out.println(RacingGameMessage.TURN_RESULT);
	}

	public void printTurnResult(final List<Car> carList) {
		carList.forEach(this::printCarPosition);
		System.out.print("\n");
	}

	private void printCarPosition(final Car car) {
		System.out.print(car.getName() + RacingGameMessage.NAME_POSITION_SPLITTER);
		for (int i = 0; i < car.getPosition(); i++) {
			System.out.print(RacingGameMessage.CAR_POSITION);
		}
		System.out.print("\n");
	}

	public void printWinner(final List<Car> winners) {
		System.out.print(joinWinnerNames(winners) + RacingGameMessage.WINNER);
	}

	private String joinWinnerNames(final List<Car> winners) {
		final String[] winnerNames = winners.stream()
			.map(Car::getName)
			.toArray(String[]::new);
		return String.join(", ", winnerNames);
	}
}
