package racingcar.View;

/**
 * 클래스 이름 : OutputView.java
 *
 * @author 보스독
 * @author 작은곰
 * @author 토니
 * @version 1.0
 * <p>
 * 날짜 : 2020.02.13 목요일
 */

public class OutputView {
	private static final String RESULT_MESSAGE = "실행 결과";
	private static final String CAR_NAMES_INPUT_GUIDE_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)";
	private static final String TRIAL_TIME_INPUT_GUIDE_MESSAGE = "시도할 횟수는 몇 회인가요?";
	private static final String IS_FINAL_WINNER = "가 최종 우승했습니다.";

	private OutputView() {
	}

	public static void printInputCarNamesMessage() {
		System.out.println(CAR_NAMES_INPUT_GUIDE_MESSAGE);
	}

	public static void printInputTrialTimeMessage() {
		System.out.println(TRIAL_TIME_INPUT_GUIDE_MESSAGE);
	}

	public static void printExceptionMessage(final String exceptionMessage) {
		System.out.println(exceptionMessage);
	}

	public static void printPositionByDash(final String outputValue) {
		System.out.println(outputValue);
	}

	public static void printResultMessage() {
		System.out.println(RESULT_MESSAGE);
	}

	public static void printNewLine() {
		System.out.println();
	}

	public static void printWinners(final String winners) {
		System.out.println(winners + IS_FINAL_WINNER);
	}
}
