package validation;

public enum ErrorMessage {

    WRONG_INPUT_NAME("자동차 이름은 1~5 글자를 입력해주세요."),
    WRONG_INPUT_NUMBER("시도 횟수는 1이상의 숫자를 입력해주세요.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getErrorMessage() {
        return this.message;
    }
}
