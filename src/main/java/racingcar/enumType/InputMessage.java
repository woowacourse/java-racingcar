package racingcar.enumType;

import racingcar.util.EnumUtil;

public enum InputMessage implements EnumUtil<String> {
    GET_CAR_NAMES_MESSAGE("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");

    private final String message;

    InputMessage(String message) {
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
