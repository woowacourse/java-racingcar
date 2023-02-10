package utils.constants;

public enum ErrorMessages {
    NAME_LENGTH("5글자 까지만 가능합니다."),
    NUMBER_FORMAT("숫자만 입력 가능합니다."),
    DUPLICATED_NAME("중복된 이름은 사용할 수 없습니다.");


    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
