package racingcar.messsages;

public enum ExceptionMessage {
	CAR_NAME_BLANK_EXCEPTION("[ERROR] 자동차 이름은 공백이거나 빌 수 없습니다."),
	CAR_NAME_LENGTH_EXCEPTION("[ERROR] 자동차 이름 길이는 5를 넘을 수 없습니다."),
	CARS_SIZE_EXCEPTION("[ERROR] 2개 이상의 자동차 이름을 입력해 주세요."),
	CAR_NAME_DUPLICATE_EXCEPTION("[ERROR] 자동차 이름은 중복될 수 없습니다."),
	CAR_MOVEMENT_NUMBER_EXCEPTION("[ERROR] 자동차 이동 숫자 범위가 올바르지 않습니다."),
	CAR_NAME_INPUT_EXCEPTION("[ERROR] 자동차 이름들을 다시 입력해주세요."),
	GAME_ROUND_INPUT_EXCEPTION("[ERROR] 시도할 게임 회수를 다시 입력해주세요."),
	GAME_ROUND_INPUT_FORMAT_DIGIT_EXCEPTION("[ERROR] 시도할 게임 회수는 양의 정수이어야 합니다."),
	GAME_ROUND_INPUT_FORMAT_ZERO_EXCEPTION("[ERROR] 시도할 게임 회수는 0으로 시작할 수 없습니다."),
	GAME_ROUND_INPUT_BLANK_EXCEPTION("[ERROR] 시도할 게임 회수는 공백이거나 빌 수 없습니다.")
	;

	private final String message;

	ExceptionMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
