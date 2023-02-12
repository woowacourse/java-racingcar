package racingcar.enumType;

import racingcar.util.EnumUtil;


public enum ExceptionMessage implements EnumUtil<String, String> {

    BLANK_MESSAGE("%s은(는) 빈 값이 들어올 수 없습니다.")
    , LENGTH_MESSAGE("%d글자를 초과하였습니다.")
    , INPUT_MESSAGE("입력 중에 예기치 못한 오류가 발생하였습니다. 예외 메시지: %s")
    , TYPE_MESSAGE("%s은(는) 숫자만 입력할 수 있습니다.")
    , RANGE_MESSAGE("%d 이상의 값을 입력해 주세요.")
    , DUPLICATE_MESSAGE("중복된 값을 입력할 수 없습니다.")
    , NO_RESOURCE_MESSAGE("%s(이)가 존재하지 않습니다.");

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

