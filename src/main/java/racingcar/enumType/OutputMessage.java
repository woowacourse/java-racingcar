package racingcar.enumType;

import racingcar.util.EnumUtil;

public enum OutputMessage implements EnumUtil<String > {
    RESULT_MESSAGE("\n실행 결과")
    , WINNER_MESSAGE("가 최종 우승했습니다.");

    private final String message;

    OutputMessage(String message) {
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
