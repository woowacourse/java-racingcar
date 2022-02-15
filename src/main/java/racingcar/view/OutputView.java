package racingcar.view;

import java.util.List;

import racingcar.dto.CarDto;

public class OutputView {
	public static void printRaceResultUi() {
		System.out.format("%n실행 결과%n");
	}

	public static void printCarsUi(List<CarDto> carsInformation) {
		for (CarDto carInformation : carsInformation) {
			System.out.println(carInformation.getName() + " : " + "-".repeat(carInformation.getPosition()));
		}
	}

	public static void printEnterUi() {
		System.out.println();
	}

	public static void printWinnersUi(List<String> names) {
		System.out.printf("%s가 최종 우승했습니다.", String.join(", ", names));
	}

	public static void printErrorUi(Exception exception) {
		System.out.println(exception.getMessage());
	}
}
