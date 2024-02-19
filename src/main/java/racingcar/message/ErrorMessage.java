package racingcar.message;

public enum ErrorMessage {
    MESSAGE_NO_DUPLICATE_CAR_NAMES("중복된 자동차 이름은 사용할 수 없습니다."),
    MESSAGE_LENGTH_OF_CAR_NAME("자동차 이름은 1자 이상 5자 이하여야 합니다."),
    MESSAGE_NO_SPACE("중복된 자동차 이름은 사용할 수 없습니다."),
    MESSAGE_ONLY_NATURAL_NUMBER("시도할 회수는 자연수를 입력해 주세요."),
    MESSAGE_ONLY_NUMBER("시도할 회수는 숫자여야만 가능합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
