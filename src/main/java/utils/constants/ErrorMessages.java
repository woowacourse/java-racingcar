package utils.constants;

public enum ErrorMessages {
    NAME_LENGTH("자동차 이름은 공백제외 1글자 이상 5글자 이하로 지어주세요."),
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
