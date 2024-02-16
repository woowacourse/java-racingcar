package util;

public enum Exceptions {
    MAX_NAME_EXCEPTION("이름은 5글자를 초과할 수 없습니다."),
    DUPLICATED_NAME_EXCEPTION("자동차 이름은 중복될 수 없습니다."),
    NAME_FORMAT_EXCEPTION("이름에 공백을 포함할 수 없습니다."),
    NULL_EXCEPTION("입력 값은 null일 수 없습니다."),
    NUMBER_FORMAT_EXCEPTION("숫자가 아닌 값은 입력할 수 없습니다."),
    NUMBER_RANGE_EXCEPTION("0 이하 숫자는 입력할 수 없습니다.");
    private static final String ERROR_PREFIX = "[ERROR] ";
    private final String message;

    Exceptions(String message) {
        this.message = ERROR_PREFIX + message;
    }

    public String getMessage() {
        return message;
    }
}
