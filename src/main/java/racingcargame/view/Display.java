package racingcargame.view;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.IntStream;

public class Display {
	private static final String CAR_NAMES_INPUT_GUIDE_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
	private static final String RACE_COUNT_INPUT_GUIDE_MESSAGE = "시도할 회수는 몇회인가요?";
	private static final String NOW_RACE_PROGRESS_GUIDE_MESSAGE = "실행 결과";
	private static final String RACE_PROGRESS_OUTPUT_SEPARATOR = " : ";
	private static final String GAME_WINNER_MESSAGE = "가 최종 우승했습니다.";
	private static final String CAR_MOVE = "-";
	private static final String CAR_NAME_SEPARATOR = ", ";

	private Display() {
	}

	public static void showRacingCarNamesInputGuideMessage() {
		print(CAR_NAMES_INPUT_GUIDE_MESSAGE);
	}

	public static void showRaceCountInputGuideMessage() {
		print(RACE_COUNT_INPUT_GUIDE_MESSAGE);
	}

	public static void showRaceProgressGuideMessage() {
		print(NOW_RACE_PROGRESS_GUIDE_MESSAGE);
	}

	public static void showRaceProgress(HashMap<String, Integer> racingCarsInformation) {
		racingCarsInformation.forEach((racingCarName, racingCarPosition) -> {
			showRacingCarName(racingCarName);
			showRacingCarPosition(racingCarPosition);
		});
		newLine();
	}

	public static void showRacingCarName(String racingCarName) {
		System.out.print(racingCarName + RACE_PROGRESS_OUTPUT_SEPARATOR);
	}

	public static void showRacingCarPosition(int racingCarPosition) {
		IntStream.range(0, racingCarPosition).forEach(index -> System.out.print(CAR_MOVE));
		newLine();
	}

	public static void showGameWinner(List<String> winners) {
		Queue<String> winner = new LinkedList<>(winners);

		while (winner.size() > 1) {
			System.out.print(winner.poll() + CAR_NAME_SEPARATOR);
		}
		System.out.print(winner.poll() + GAME_WINNER_MESSAGE);
	}

	private static void print(String message) {
		System.out.println(message);
	}

	private static void newLine() {
		System.out.println();
	}
}
