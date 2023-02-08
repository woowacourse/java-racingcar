package racingcar.exception;

public enum ErrorMessages {
	CAR_NAME_BLANK_EXCEPTION("[ERROR] 자동차 이름은 공백이거나 빌 수 없습니다."),
	CAR_NAME_LENGTH_EXCEPTION("[ERROR] 자동차 이름 길이는 5를 넘을 수 없습니다."),
	CAR_NAME_INPUT_EXCEPTION("[ERROR] 자동차 이름들을 다시 입력해주세요.");

	private final String message;

	ErrorMessages(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
