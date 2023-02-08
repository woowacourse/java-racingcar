package exception;

public enum ErrorMessage {

    CANT_CONTAIN_SPACE("자동차 이름에 공백이 포함될 수 없습니다."),
    UNSUITABLE_LENGTH("자동차 이름은 1자~5자만 입력할 수 있습니다."),
    INPUT_ONLY_DIGIT("시도 회수는 숫자만 입력할 수 있습니다.");


    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
