package validation;


public enum ErrorMessages {
    INVALID_CAR_NAME_LENGTH("1에서 5사이의 길이의 자동차 이름으로 다시 입력해주세요"),
    CONTAINS_IDENTIFIER("이름에는 - 를 포함시킬 수 없습니다. 다시 입력해주세요"),
    INVALID_COUNT("시도 횟수는 1이상 100,000,000미만 입니다. 다시 입력해주세요"),
    NOT_A_NUMBER("시도 횟수는 자연수여야 합니다 다시 입력해주세요.");
    private final String message;

    ErrorMessages(String content) {
        this.message = content;
    }

    public String getMessage() {
        return message;
    }
}
