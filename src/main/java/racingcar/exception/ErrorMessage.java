package racingcar.exception;

import racingcar.domain.car.Position;

public enum ErrorMessage {
    INPUT_NOT_A_NUMBER("입력 값은 숫자여야 합니다."),
    INVALID_CAR_NAME_LENGTH("유효하지 않은 자동차 이름입니다."),
    INVALID_RACE_COUNT_RANGE("유효하지 않은 시도 횟수입니다."),
    DUPLICATE_CAR_NAMES("중복된 자동차 이름이 존재합니다."),
    INVALID_POSITION(String.format("위치는 %d 이상이어야 합니다.", Position.MIN_POSITION)),
    INVALID_CAR_NAME_FORMAT("자동차 이름에 한글, 영어, 숫자만 가능합니다."),
    ;

    private final String message;

    ErrorMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
