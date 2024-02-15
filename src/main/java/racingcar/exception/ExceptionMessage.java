package racingcar.exception;

import static racingcar.config.RacingCarConfig.MAX_CARS_SIZE;
import static racingcar.config.RacingCarConfig.MAX_NAME_LENGTH;
import static racingcar.config.RacingCarConfig.MAX_TRY_COUNT;
import static racingcar.config.RacingCarConfig.MIN_CARS_SIZE;

public enum ExceptionMessage {
    NOT_NULL("공백을 입력할 수 없습니다."),
    NOT_NULL_CAR_NAME("자동차 이름에 공백을 입력할 수 없습니다."),
    ONLY_POSITIVE_NUMBER("시도 횟수는 양의 정수를 입력해야 합니다."),
    INVALID_TRY_COUNT(
            String.format(
                    "시도 횟수는 %d 이하여야 합니다.",
                    MAX_TRY_COUNT.getValue()
            )),
    NOT_DUPLICATED_CAR_NAME("자동차 이름은 중복될 수 없습니다."),
    INVALID_CARS_SIZE(
            String.format(
                    "자동차 대수는 %d대 이상 %d대 이하여야 합니다.",
                    MIN_CARS_SIZE.getValue(),
                    MAX_CARS_SIZE.getValue()
            )),
    INVALID_CAR_NAME("올바르지 않은 자동차 이름입니다."),
    INVALID_CAR_NAME_SIZE(
            String.format(
                    "자동차 이름의 길이가 %d를 초과합니다",
                    MAX_NAME_LENGTH.getValue()
            ));

    public static final String BASE_MESSAGE = "[ERROR] ";

    private final String message;

    ExceptionMessage(String message) {
        this.message = BASE_MESSAGE + String.format(message);
    }

    public String getMessage() {
        return message;
    }
}
