package racingcar.constant;

public enum ViewMessage {

	INPUT_CAR_NAMES("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."),
	INPUT_TRY_COUNT("시도할 회수는 몇회인가요?"),
	OUTPUT_ROUND_RESULTS_INTRO("\n실행 결과"),
	OUTPUT_ROUND_RESULT_FORMAT("%s : %s\n"),
	OUTPUT_WINNERS("%s가 최종 우승했습니다."),
	OUTPUT_EXCEPTION_PREFIX("[ERROR] ");
	private final String message;

	ViewMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
