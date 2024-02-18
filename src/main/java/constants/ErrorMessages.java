package constants;

public enum ErrorMessages {
	INVALID_INPUT("입력 형식이 올바르지 않습니다."),
	INVALID_CAR_NAME("이름의 길이는 1~5글자여야 합니다."),
	INVALID_CAR_LOCATION("위치값은 음수가 될 수 없습니다");

	private static final String prefix = "[ERROR]";

	private final String message;

	ErrorMessages(String message) {
		this.message = message;
	}

	public String getMessage() {
		return prefix + message;
	}
}
