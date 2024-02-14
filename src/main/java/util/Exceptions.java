package util;

public enum Exceptions {
    MAX_NAME_EXCEPTION("이름은 5글자를 초과할 수 없습니다."),
    DUPLICATED_NAME_EXCEPTION("자동차 이름은 중복될 수 없습니다.");

    private static final String ERROR_PREFIX = "[ERROR] ";
    private final String message;

    Exceptions(String message) {
        this.message = ERROR_PREFIX + message;
    }

    public String getMessage() {
        return message;
    }
}
