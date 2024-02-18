package common;

public enum Exception {
    INPUT_NULL_BLANK("입력은 없거나 null일 수 없습니다."),
    INPUT_NUMERIC("숫자가 입력되지 않았습니다."),
    POSITIVE("숫자는 양수만 가능합니다."),
    DUPLICATE("자동차의 이름은 중복될 수 없습니다."),

    CAR_NAME_NULL_BLANK("자동차의 이름은 없거나 null일 수 없습니다."),
    CAR_NAME_LENGTH("자동차의 이름은 5글자 이내여야 합니다.");

    private final String message;

    Exception(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
