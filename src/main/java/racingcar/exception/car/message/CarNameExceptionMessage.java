package racingcar.exception.car.message;

import racingcar.domain.car.condition.NameLength;

public enum CarNameExceptionMessage {

    NAME_IS_DUPLICATED("자동차의 이름은 중복될 수 없습니다."),
    NAME_IS_EMPTY("자동차의 이름은 공백이 될 수 없습니다."),
    NAME_IS_NULL("자동차의 이름은 NULL이 될 수 없습니다."),
    NAME_IS_TOO_LONG(String.format("자동차의 이름은 %d자 이하여야 합니다.", NameLength.getMaximum()));

    public final String message;

    CarNameExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
