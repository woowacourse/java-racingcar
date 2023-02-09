package validation;

public enum ErrorMessage {

    WRONG_NAME_SIZE("자동차 이름은 1~5 글자입니다."),
    NOT_DIGIT_INPUT("숫자를 입력해주세요."),
    WRONG_NUMBER_SIZE("1 이상의 시도 횟수를 입력해주세요.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getErrorMessage() {
        return this.message;
    }
}
