package carracing.view.messages;

public enum OutputMessage {
	INPUT_CAR_NAME("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."),
	INPUT_NUM_OF_GAMES("시도할 횟수는 몇회인가요?"),
	RESULT_MESSAGE("실행 결과"),
	ERROR_MESSAGE("[ERROR] ");

	private final String message;

	private OutputMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
