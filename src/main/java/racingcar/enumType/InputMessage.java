package racingcar.enumType;

import racingcar.util.EnumUtil;

public enum InputMessage implements EnumUtil<String, String> {

    GET_CAR_NAMES_MESSAGE("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
    , GET_TRY_COUNT_MESSAGE("시도할 회수는 몇회인가요?");

    private final String message;

    InputMessage(final String message) {
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
