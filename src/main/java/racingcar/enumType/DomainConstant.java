package racingcar.enumType;

import racingcar.util.EnumUtil;

public enum DomainConstant implements EnumUtil<Object> {
    CAR_FORWARD_NUMBER(4)
    , CAR_NAME_MAX_LENGTH(5)
    , RACE_MIN_TRY_COUNT(0);

    private final int number;

    DomainConstant(final int number) {
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
