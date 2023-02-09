package racingcar.messsages;

public enum InputViewMessage {
	CAR_NAMES_INPUT_MESSAGE("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."),
	GAME_ROUND_INPUT_MESSAGE("시도할 회수는 몇회인가요?");

	private final String message;

	InputViewMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
