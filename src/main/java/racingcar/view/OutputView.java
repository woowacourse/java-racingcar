package racingcar.view;

import racingcar.domain.Car;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
	private static final String CAR_NAME_REQUEST_MSG = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
	private static final String ROUND_COUNT_REQUEST_MSG = "시도할 회수는 몇회인가요?";
	private static final String ROUND_RESULT_MSG = "\n실행 결과";
	private static final String POSITION_DELIMITER = "-";
	private static final String CAR_DELIMITER = "\n";
	private static final String WINNERS_DELIMITER = ", ";
	private static final String RACING_RESULT_SUFFIX = "가 최종 우승했습니다.";

	public static void printCarNameRequestMsg() {
		System.out.println(CAR_NAME_REQUEST_MSG);
	}

	public static void printRoundCountRequestMsg() {
		System.out.println(ROUND_COUNT_REQUEST_MSG);
	}

	public static void printRoundResultMsg() {
		System.out.println(ROUND_RESULT_MSG);
	}

	public static void printRoundState(List<Car> cars) {
		String racingState = cars.stream()
				.map(OutputView::formatCarState)
				.collect(Collectors.joining(CAR_DELIMITER));
		System.out.println(racingState + CAR_DELIMITER);
	}

	private static String formatCarState(Car car) {
		StringBuilder sb = new StringBuilder(car.getName() + " : -");
		sb.append(POSITION_DELIMITER.repeat(Math.max(0, car.getPosition())));
		return sb.toString();
	}

	public static void printRacingResult(List<String> winners) {
		String winnersFormat = winners.stream()
				.collect(Collectors.joining(WINNERS_DELIMITER));
		System.out.println(winnersFormat + RACING_RESULT_SUFFIX);
	}
}
