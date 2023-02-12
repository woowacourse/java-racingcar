package utils;

public enum ErrorMessage {
    COMMON("[ERROR] "),
    WRONG_NAME_LENGTH("1에서 5사이의 이름 길이만 입력 가능합니다."),
    WRONG_TRY_TIMES_RANGE("시도 횟수는 최소 1회 이상입니다."),
    WRONG_TRY_TIMES_TYPE("시도 횟수는 숫자만 입력해야합니다."),
    WRONG_NAME_CONTAINS_BLANK("자동차 이름은 공백을 포함할 수 없습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String of() {
        return COMMON.message + message;
    }
}

