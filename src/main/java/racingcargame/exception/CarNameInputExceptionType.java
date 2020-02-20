package racingcargame.exception;

public enum CarNameInputExceptionType {
    NULL_INPUT("※Null이 입력되었습니다."),
    OVER_MAX_NAME_LENGTH("※허용된 길이(5자)를 초과하는 자동차 이름이 존재합니다. 자동차 이름은 모두 5자 이하로 입력해 주세요."),
    BLANK_NAME("※이름이 없는 자동차가 존재합니다. 쉼표(,)가 연속으로 입력(,,)되지 않았는지 확인 주세요.");

    private String errorMessage;

    CarNameInputExceptionType(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
