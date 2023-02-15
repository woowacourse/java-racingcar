package racingcar.exception;

public enum ExceptionMessage {
    OUT_OF_CAR_NAME_LENGTH("자동차의 이름은 6글자를 넘길 수 없습니다."),
    BLANK_CAR_NAME("자동차의 이름이 공백이 될 수 없습니다."),
    DUPLICATE_CAR_NAME("자동차의 이름이 중복됩니다."),
    EMPTY_CARS("자동차들이 존재하지 않습니다."),
    ILLEGAL_TRY_COUNT("시도 횟수는 0 이상의 정수여야 합니다."),
    ILLEGAL_POSITION("자동차의 위치는 음수가 아니어야 합니다.");

    private final static String EXCEPTION_HEADER = "[ERROR] ";
    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return EXCEPTION_HEADER + message;
    }
}
