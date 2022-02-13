package racingcar.exception.car.message;

import racingcar.domain.car.condition.NameLength;

public class CarNameExceptionMessage {

    public static String NAME_DUPLICATED_EXCEPTION_MESSAGE = "자동차의 이름은 중복될 수 없습니다.";
    public static String NAME_EMPTY_EXCEPTION_MESSAGE = "자동차의 이름은 공백이 될 수 없습니다.";
    public static String NAME_TOO_LONG_EXCEPTION_MESSAGE =
            String.format("자동차의 이름은 %d자 이하여야 합니다.", NameLength.getMaximum());

}
