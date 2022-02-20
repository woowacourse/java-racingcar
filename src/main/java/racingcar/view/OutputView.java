package racingcar.view;

import java.util.List;

import racingcar.service.dto.CarDto;

public class OutputView {

	private static final String RESULT_MESSAGE = "실행결과";
	private static final String WINNER_MESSAGE = "가 최종 우승했습니다.";
	private static final String POSITION_BAR = "-";
	private static final String SEPARATOR_OF_CAR_NAMES = ", ";
	private static final String SEPARATOR_OF_RACE_INFO = " : ";

	public static void printResultMessage() {
		System.out.println();
		System.out.println(RESULT_MESSAGE);
	}

	public static void printRacingInfo(List<CarDto> carDtos) {
		for (CarDto carDto : carDtos) {
			System.out.print(carDto.getName() + SEPARATOR_OF_RACE_INFO);
			printPositionBar(carDto.getPosition());
		}
		System.out.println();
	}

	private static void printPositionBar(int position) {
		for (int i = 0; i < position; i++) {
			System.out.print(POSITION_BAR);
		}
		System.out.println();
	}

	public static void printWinnersMessage(List<String> winnerNames) {
		String names = String.join(SEPARATOR_OF_CAR_NAMES, winnerNames);
		System.out.println(names + WINNER_MESSAGE);
	}
}
