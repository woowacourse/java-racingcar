package domain;

public enum ExceptionMessages {
    EMPTY_CAR_NAME_EXCEPTION("[ERROR] 자동차 이름은 비어있을 수 없습니다."),
    TOO_LONG_CAR_NAME_EXCEPTION("[ERROR] 자동차 이름이 너무 깁니다."),
    SPECIAL_CHARACTER_CAR_NAME_EXCEPTION("[ERROR] 자동차 이름에는 특수문자가 들어갈 수 없습니다."),
    DUPLICATE_CAR_NAME_EXCEPTION("[ERROR] 자동차 이름은 중복될 수 없습니다."),
    TRY_COUNT_NUMBER_FORMAT_EXCEPTION("[ERROR] 시도 횟수는 숫자여야 합니다.");

    private final String message;

    ExceptionMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
