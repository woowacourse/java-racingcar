package racingcar.exception;

import static racingcar.domain.car.CarName.MAX_NAME_LENGTH;
import static racingcar.domain.car.Position.MIN_POSITION;
import static racingcar.dto.request.RaceCountRequest.MAX_RACE_COUNT;
import static racingcar.dto.request.RaceCountRequest.MIN_RACE_COUNT;

public enum ErrorMessage {
    INPUT_NOT_A_NUMBER("입력 값은 숫자여야 합니다."),
    INVALID_CAR_NAME_LENGTH(String.format("자동차 이름은 %d자 이하여야 합니다.", MAX_NAME_LENGTH)),
    INVALID_RACE_COUNT_RANGE(String.format("시도 횟수는 %d~%d이어야 합니다.", MIN_RACE_COUNT, MAX_RACE_COUNT)),
    DUPLICATE_CAR_NAMES("중복된 자동차 이름이 존재합니다."),
    INVALID_POSITION(String.format("위치는 %d 이상이어야 합니다.", MIN_POSITION)),
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
