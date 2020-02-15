package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Cars;

public class OutputView {
	private static final String NEW_LINE = "\n";
	private static final String COLON = " : ";
	private static final String POSITION_BAR = "-";

	public static void printExceptionMessage(Exception e) {
		System.out.println(e.getMessage());
	}

	public static void printCurrentPosition(Cars cars) {
		StringBuilder stringBuilder = new StringBuilder();

		for (Car car : cars.getCars()) {
			stringBuilder.append(car.getName()).append(COLON);
			for (int i = 0; i < car.getPosition(); i++) {
				stringBuilder.append(POSITION_BAR);
			}
			stringBuilder.append(NEW_LINE);
		}
		System.out.println(stringBuilder);
	}

	public static void printRaceStart() {
		System.out.println(NEW_LINE + "레이스 시작!!!!!!");
	}

	public static void printWinnersName(String winnersName) {
		System.out.println(winnersName + " 우승!!!!!!!!");
	}
}
