package racingcar.view;

import racingcar.model.car.Cars;
import racingcar.model.car.Names;

public class OutputView {
	public static void printRaceResultUi() {
		System.out.format("%n실행 결과%n");
	}

	public static void printCarsUi(Cars cars) {
		System.out.printf(cars.result() + "%n");
	}

	public static void printEnterUi() {
		System.out.println();
	}

	public static void printWinnersUi(Names names) {
		System.out.printf("%s가 최종 우승했습니다.", names);
	}

	public static void printErrorUi(Exception exception) {
		System.out.println(exception.getMessage());
	}
}
