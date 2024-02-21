package domain;

public enum ErrorMessage {
    MULTIPLE_CARS_REQUIRED("[ERROR] 경주할 자동차를 두 대 이상 입력해주세요."),
    DUPLICATE_NAME("[ERROR] 중복된 이름이 존재합니다."),
    INTEGER_REQUIRED("[ERROR] 시도 횟수는 정수여야 합니다."),
    POSITIVE_NUMBER_REQUIRED("[ERROR] 시도 횟수는 양수여야 합니다."),
    NULL_NAME("[ERROR] 이름은 null일 수 없습니다."),
    LENGTH_EXCEEDED("[ERROR] 이름은 5자 이하여야 합니다."),
    EMPTY_NAME("[ERROR] 빈 이름은 사용할 수 없습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
