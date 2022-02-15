package racingcar.exception.status.car;

import racingcar.domain.car.condition.NameLength;
import racingcar.exception.status.ExceptionStatus;

public enum CarNameExceptionStatus implements ExceptionStatus {

    NAME_IS_DUPLICATED("자동차의 이름은 중복될 수 없습니다."),
    NAME_IS_EMPTY("자동차의 이름은 공백이 될 수 없습니다."),
    NAME_IS_NULL("자동차의 이름은 NULL이 될 수 없습니다."),
    NAME_IS_TOO_LONG(
            String.format("자동차의 이름은 %d자 이하여야 합니다.", NameLength.ALLOWED_MAXIMUM_LENGTH.getLength()));

    private final String message;

    CarNameExceptionStatus(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

}
