package racingcar.views;

import java.util.List;

import racingcar.models.Car;

public class Output {
	private static final String TURN_RESULT = "실행결과";
	private static final String CAR_POSITION = "-";
	private static final String WINNER = "가 최종 우승했습니다.";
	private static final String NAME_POSITION_SPLITTER = " : ";

	public void printResultMessage() {
		System.out.println(TURN_RESULT);
	}

	public void printTurnResult(List<Car> carList) {
		carList.forEach(this::printCarPosition);
		System.out.println();
	}

	private void printCarPosition(Car car) {
		System.out.println(car.getName() + NAME_POSITION_SPLITTER);
		for (int i = 0; i < car.getPosition(); i++) {
			System.out.print(CAR_POSITION);
		}
	}

	public void printWinner(String winners) {
		System.out.println(winners + WINNER);
	}

}
