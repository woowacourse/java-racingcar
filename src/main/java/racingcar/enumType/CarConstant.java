package racingcar.enumType;

import racingcar.util.EnumUtil;

public enum CarConstant implements EnumUtil<Object> {
    FORWARD_NUMBER(4),
    NAME_MAX_LENGTH(5);

    private final int number;

    CarConstant(final int number) {
        this.number = number;
    }

    @Override
    public String getKey() {
        return name();
    }

    @Override
    public Integer getValue() {
        return number;
    }
}
