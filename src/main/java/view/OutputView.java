package view;

import domain.Car;
import domain.Cars;

public class OutputView {
	private static final String DELIMITER = " : ";
	private static final String BAR = "-";
	private static final String TELL_FINAL_WINNER = "가 최종 우승했습니다";

	public void printResultMessage() {
		System.out.println();
		System.out.println("실행 결과");
	}

	public void printCarsDistance(Cars cars) {
		for (Car car : cars.getCars()) {
			String sb = car.getName()
				+ DELIMITER
				+ BAR.repeat(Math.max(0, car.getPosition()));
			System.out.println(sb);
		}
		System.out.println();
	}

	public void printWinner(String winners) {
		String result = winners + TELL_FINAL_WINNER;
		System.out.println(result);
	}
}
