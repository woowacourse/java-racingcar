package racingcar.view;

import java.util.List;

import racingcar.domain.Car;

public class OutputView {

	private static final String RESULT_MESSAGE ="실행결과";

	public void printResultMessage() {
		System.out.println();
		System.out.println(RESULT_MESSAGE);
	}

	public void printRacingInfo(List<Car> cars) {
		for (Car car : cars) {
			System.out.print(car.getName() + " : ");
			printPositionBar(car.getPosition());
		}
		System.out.println();
	}

	private void printPositionBar(int position) {
		for (int i = 0; i < position; i++) {
			System.out.print("-");
		}
		System.out.println();
	}
}
