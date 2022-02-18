package carracing.model.exception;

public enum CarExceptionMessage {
	NAME_LENGTH_EXCEPTION("자동차 이름의 길이는 한 글자 이상, 다섯 글자 이하여야합니다."),
	NAME_BLANK_EXCEPTION("자동차의 이름에 공백은 포함될 수 없습니다."),
	NAME_DUPLICATE_EXCEPTION("자동차 이름은 중복이 되면 안됩니다.");

	private final String message;

	CarExceptionMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
