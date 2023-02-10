package racingcar.domain.constant;

import racingcar.util.EnumUtil;

public enum RaceConstant implements EnumUtil<String, Integer> {

    MIN_RACE_CONDITION(0)
    , MAX_RACE_CONDITION(9)
    , RACE_MIN_TRY_COUNT(0);

    private final int number;

    RaceConstant(final int number) {
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
