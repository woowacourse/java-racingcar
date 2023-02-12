package racingcar.domain.constant;

import racingcar.util.EnumUtil;

public enum CarConstant implements EnumUtil<String, Integer> {
    INIT_POSITION(1)
    , CAR_FORWARD_NUMBER(4)
    , CAR_NAME_MAX_LENGTH(5);

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
