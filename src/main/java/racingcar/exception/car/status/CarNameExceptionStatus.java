package racingcar.exception.car.status;

import racingcar.domain.car.condition.NameLength;

public enum CarNameExceptionStatus {

    NAME_IS_DUPLICATED_EXCEPTION_STATUS("자동차의 이름은 중복될 수 없습니다."),
    NAME_IS_EMPTY_EXCEPTION_STATUS("자동차의 이름은 공백이 될 수 없습니다."),
    NAME_IS_NULL_EXCEPTION_STATUS("자동차의 이름은 NULL이 될 수 없습니다."),
    NAME_IS_TOO_LONG_EXCEPTION_STATUS(
            String.format("자동차의 이름은 %d자 이하여야 합니다.", NameLength.ALLOWED_MAXIMUM_LENGTH.getLength()));

    public final String message;

    CarNameExceptionStatus(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
