package racingcar.views;

import java.util.List;

import racingcar.models.Car;

public class Output {

	private static final String TURN_RESULT = "\n실행결과";
	private static final String WINNER = "가 최종 우승했습니다.";
	private static final String CAR_POSITION = "-";
	private static final String NAME_POSITION_SPLITTER = " : ";

	public void printResultMessage() {
		System.out.println(TURN_RESULT);
	}

	public void printTurnResult(final List<Car> carList) {
		carList.forEach(this::printCarPosition);
		System.out.print("\n");
	}

	private void printCarPosition(final Car car) {
		System.out.print(car.getName() + NAME_POSITION_SPLITTER);
		for (int i = 0; i < car.getPosition(); i++) {
			System.out.print(CAR_POSITION);
		}
		System.out.print("\n");
	}

	public void printWinners(final String winners) {
		System.out.print(winners + WINNER);
	}
}
