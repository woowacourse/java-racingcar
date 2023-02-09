package exception;

public enum ErrorMessage {

    ERROR_TAG("[ERROR] "),
    ENTER_NAME_WITH_COMMA("쉼표로 이름을 구분해주세요."),
    ENTER_NAME_CORRECT_LENGTH("이름은 5글자 이하로 입력해주세요."),
    ENTER_POSITIVE_INTEGER("양의 정수를 입력해주세요.");

    private final String errorMessage;

    ErrorMessage(final String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString() {
        return ERROR_TAG.errorMessage + this.errorMessage;
    }
}
