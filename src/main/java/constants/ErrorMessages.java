package constants;

public enum ErrorMessages {
	INVALID_INPUT("입력 형식이 올바르지 않습니다.");

	private static final String prefix = "[ERROR]";

	private final String message;

	ErrorMessages(String message) {
		this.message = message;
	}

	public String getMessage() {
		return prefix + message;
	}
}
