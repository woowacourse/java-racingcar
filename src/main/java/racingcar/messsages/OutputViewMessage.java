package racingcar.messsages;

public enum OutputViewMessage {
	RESULT_MESSAGE(System.lineSeparator() + "실행결과"),
	GAME_RESULT_MESSAGE("가 최종 우승했습니다."),
	PATH("-"),
	WINNER_DELIMITER(", "),
	RESULT_SEPARATOR(" : ");

	private final String message;

	OutputViewMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
