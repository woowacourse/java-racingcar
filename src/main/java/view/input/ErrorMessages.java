package view.input;


public enum ErrorMessages {
    EMPTY_INPUT("입력값이 없습니다."),
    NOT_PROPER_CAR_NAME_LENGTH(
        "자동차 이름 길이는 " + Validator.MIN_CAR_NAME_LENGTH + "자 이상, " + Validator.MAX_CAR_NAME_LENGTH + "자 이하여야합니다.");
    private final String content;

    ErrorMessages(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}