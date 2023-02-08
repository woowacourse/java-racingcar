package racingcar.enumType;

import racingcar.util.EnumUtil;

import static racingcar.enumType.CarConstant.NAME_MAX_LENGTH;

public enum ExceptionMessage implements EnumUtil<String> {
    BLANK_MESSAGE("이름이 비어있을 수 없습니다.")
    , LENGTH_MESSAGE(String.format("%d글자를 초과하였습니다.", NAME_MAX_LENGTH.getValue()))
    , INPUT_MESSAGE("프로그램에서 예기치 못한 오류가 발생하였습니다. 예외 메시지: %s")
    , TYPE_MESSAGE("%s는 숫자만 입력할 수 있습니다.")
    , RANGE_MESSAGE("1 이상의 값을 입력해 주세요.");

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

