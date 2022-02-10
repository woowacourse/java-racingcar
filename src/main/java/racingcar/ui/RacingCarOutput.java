package racingcar.ui;

import java.util.List;
import java.util.stream.Collectors;

import racingcar.domain.Car;

public class RacingCarOutput {
	private static final String ROUND_RESULT = "실행 결과";
	private static final String WINNER_MESSAGE = "가 최종 우승했습니다.";
	private static final String CAR_INFO_SEPARATOR=" : ";
	private static final String CAR_POSITION_BAR = "-";

	public static void printRoundResultMessage() {
		System.out.println(ROUND_RESULT);
	}

	public static void printRoundResult(List<Car> cars) {
		cars.forEach(RacingCarOutput::printCarPositionInfo);
	}

	private static void printCarPositionInfo(Car car) {
		System.out.println(car.getName() + CAR_INFO_SEPARATOR + CAR_POSITION_BAR.repeat(Math.max(0, car.getPosition())));
	}

	public static void printWinners(List<Car> winners) {
		String winnerNames = winners.stream()
			.map(Car::getName)
			.collect(Collectors.joining(", "));
		System.out.println(winnerNames + WINNER_MESSAGE);
	}

}
