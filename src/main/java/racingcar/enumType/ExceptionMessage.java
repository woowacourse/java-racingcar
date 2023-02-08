package racingcar.enumType;

import racingcar.util.EnumUtil;

import static racingcar.enumType.CarConstant.NAME_MAX_LENGTH;

public enum ExceptionMessage implements EnumUtil {
    BLANK_MESSAGE("이름이 비어있을 수 없습니다."),
    LENGTH_MESSAGE(String.format("%d 글자를 초과하였습니다.", NAME_MAX_LENGTH.getValue()));

    private final String message;

    ExceptionMessage(final String message) {
        this.message = message;
    }


    @Override
    public String getKey() {
        return name();
    }

    @Override
    public String getValue() {
        return message;
    }
}

