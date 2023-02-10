package racingcar.view;

import java.util.List;

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

	public static void printRacingState(String state) {
		System.out.println(state + "\n");
	}

	public static void printRacingResult(List<String> result) {
		StringBuilder sb = new StringBuilder();
		for (String s : result) {
			sb.append(s).append(", ");
		}
		sb.setLength(sb.length()-2);
		System.out.println(sb.append(RESULT_SUFFIX));
	}
}
