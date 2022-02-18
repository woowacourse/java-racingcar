package racingcar.domain.enums;

public enum DomainErrorMessage {
    RANDOM_NUMBER_RANGE_OVER_ERROR_MESSAGE("최소, 최대 범위의 입력을 확인해 주세요"),
    DUPLICATE_CAR_NAME_ERROR_MESSAGE("자동차의 이름이 중복되었습니다."),
    NO_SUCH_CAR_ERROR_MESSAGE("저장된 자동차가 없습니다."),
    EMPTY_CAR_NAME_ERROR_MESSAGE("자동차 이름으로 공백을 입력할 수 없습니다."),
    TOO_LONG_CAR_NAME_ERROR_MESSAGE("입력한 자동차 이름이 너무 깁니다."),
    NUMBER_FORMAT_ERROR_MESSAGE("시도 회수는 숫자로 입력해야합니다."),
    NUMBER_NEGATIVE_ERROR_MESSAGE("시도 회수는 0이상이어야 합니다.");

    private final String message;

    DomainErrorMessage(String message) {
        this.message = message;
    }

    public String get() {
        return message;
    }
}
