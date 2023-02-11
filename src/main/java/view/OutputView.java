package view;

import domain.Cars;
import domain.Winner;

public class OutputView {
	private static final String DELIMITER = " : ";
	private static final String JOIN_COMMA = ", ";
	private static final String FINAL_WINNER = "가 최종 우승했습니다";

	private static String drawDistance(Cars cars, int index) {
		String bar = "-";
		return bar.repeat(cars.getCar(index).getDistance());
	}

	public void printCarsDistance(Cars cars) {
		for (int i = 0; i < cars.getCarsSize(); i++) {
			String carName = cars.getCar(i).getCarName();
			System.out.println(carName + DELIMITER + drawDistance(cars, i));
		}
		System.out.println();
	}

	public void printWinner(Winner winner) {
		String result = String.join(JOIN_COMMA, winner.getWinners());
		System.out.println(result + FINAL_WINNER);
	}
}
