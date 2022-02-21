package carracing.view.messages;

public enum ExceptionMessage {
    PREFIX("[ERROR] "),
    CAR_NAME_LENGTH_EXCEPTION("자동차 이름의 길이는 한 글자 이상, 다섯 글자 이하여야합니다."),
    CAR_NAME_DUPLICATE_EXCEPTION("자동차 이름은 중복이 되면 안됩니다."),
    INPUT_EMPTY_STRING_EXCEPTION("빈 문자열을 입력하면 안됩니다."),
    INPUT_NOT_NUMBER_EXCEPTION("시도할 횟수는 양수만 입력 가능합니다.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
