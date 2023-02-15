package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
	private static final String CAR_NAME_REQUEST_MSG = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
	private static final String ROUND_COUNT_REQUEST_MSG = "시도할 회수는 몇회인가요?";
	private static final String RESULT_STARTING_MSG = "실행 결과";
	private static final String RESULT_SUFFIX = "가 최종 우승했습니다.";

	public static void printCarNameRequestMsg() {
		System.out.println(CAR_NAME_REQUEST_MSG);
	}

	public static void printRoundCountRequestMsg() {
		System.out.println(ROUND_COUNT_REQUEST_MSG);
	}

	public static void printOutputMsg() {
		System.out.println(RESULT_STARTING_MSG);
	}

	public static void printRacingState(final String state) {
		System.out.println(state + "\n");
	}

	public static void printRacingResult(final List<String> result) {
		String racingResult = result.stream()
			.collect(Collectors.joining(", "));
		System.out.println(racingResult + RESULT_SUFFIX);
	}

	public static void printErrorMsg(final String errorMsg) {
		System.out.println(errorMsg);
	}
}
