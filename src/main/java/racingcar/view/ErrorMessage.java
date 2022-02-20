package racingcar.view;

public enum ErrorMessage {

    RANGE_OVER("최소, 최대 범위의 입력을 확인해 주세요"),
    INPUT_EMPTY("공백을 입력하셨습니다."),
    NUMBER_NEGATIVE("음수 값을 입력했습니다. 양수를 입력해 주세요."),
    CAR_NAME_EMPTY("자동차 이름으로 공백을 입력할 수 없습니다."),
    CAR_NAME_TOO_LONG("자동차 이름이 너무 깁니다."),
    CAR_NAME_DUPLICATE("자동차의 이름이 중복되었습니다."),
    CAR_NOT_FOUND("자동차가 없습니다.");

    private final String message;

    ErrorMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
