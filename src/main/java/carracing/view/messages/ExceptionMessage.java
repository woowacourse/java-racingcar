package carracing.view.messages;

public enum ExceptionMessage {
	PREFIX("[ERROR] "),
	INPUT_NUMBER_ZERO_EXCEPTION("시도할 횟수는 1 이상이어야 합니다."),
	INPUT_EMPTY_STRING_EXCEPTION("빈 문자열을 입력하면 안됩니다."),
	INPUT_NOT_NUMBER_EXCEPTION("시도할 횟수는 숫자만 입력 가능합니다.");

	private final String message;

	ExceptionMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
