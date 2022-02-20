package racingcar.exception.car;

import racingcar.domain.car.condition.NameLength;
import racingcar.exception.ExceptionStatus;

public enum CarNameExceptionStatus implements ExceptionStatus {

    NAME_IS_DUPLICATED("중복될 수 없습니다."),
    NAME_IS_EMPTY("공백이 될 수 없습니다."),
    NAME_IS_NULL("NULL이 될 수 없습니다."),
    NAME_IS_TOO_LONG(String.format("%d자 이하여야 합니다.", NameLength.ALLOWED_MAXIMUM_LENGTH.getLength()));

    private static final String MESSAGE_PREFIX = "자동차의 이름은 ";
    private final String message;

    CarNameExceptionStatus(final String message) {
        this.message = MESSAGE_PREFIX + message;
    }

    public String getMessage() {
        return this.message;
    }

}
