package racingcargame.view;

import java.util.List;

import racingcargame.domain.Car;
import racingcargame.domain.CarStatus;

class OutputView {

	private static final String MARK = "-";
	private static final String SEPARATOR = " : ";
	private static final String DELIMITER = ", ";

	static void printRaceResultMessage() {
		System.out.println("\n실행 결과");
	}

	static void printRaceStatus(Car car) {
		StringBuilder sb = new StringBuilder();

		sb.append(car.getCarName());
		sb.append(SEPARATOR);
		printEachStatus(car, sb);
		System.out.println(sb);
	}

	private static void printEachStatus(Car car, StringBuilder sb) {
		for (int i = 0; i < car.getCarPosition(); i++) {
			sb.append(MARK);
		}
	}

	static void printRaceResult(List<CarStatus> carStatus) {
		carStatus.forEach(OutputView::printEachRaceStatus);
	}

	private static void printEachRaceStatus(CarStatus carStatus) {
		carStatus.getCars().forEach(OutputView::printRaceStatus);
		System.out.println();
	}

	static void printWinner(List<String> winners) {
		System.out.println(String.join(DELIMITER, winners) + "가 최종 우승했습니다.");
	}
}
