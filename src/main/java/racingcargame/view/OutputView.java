package racingcargame.view;

import java.util.List;

import racingcargame.domain.RacingResult;
import racingcargame.domain.RacingLog;
import racingcargame.domain.car.CarDto;

public class OutputView {
	private static final String MARK = "-";
	private static final String SEPARATOR = " : ";
	private static final String DELIMITER = ", ";

	private OutputView() {
	}

	public static void printRaceResultMessage() {
		System.out.println("\n실행 결과");
	}

	private static void printRaceStatus(CarDto carDto) {
		StringBuilder sb = new StringBuilder();

		sb.append(carDto.getName());
		sb.append(SEPARATOR);
		markRaceStatus(carDto, sb);
		System.out.println(sb);
	}

	private static void markRaceStatus(CarDto carDto, StringBuilder sb) {
		for (int i = 0; i < carDto.getPosition(); i++) {
			sb.append(MARK);
		}
	}

	public static void printRaceResult(RacingResult racingResult) {
		racingResult.getRacingResult().stream()
			.map(RacingLog::getRacingLog)
			.forEach(carDtos -> {
				carDtos.forEach(OutputView::printRaceStatus);
				System.out.println();
			});
	}

	public static void printWinner(List<String> winners) {
		System.out.println(String.join(DELIMITER, winners) + "가 최종 우승했습니다.");
	}
}
