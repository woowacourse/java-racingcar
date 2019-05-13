package racingcar.validator;

import racingcar.utils.StringUtils;

import java.util.Objects;

public class InputValidator {
    private InputValidator() {
    }

    public static void checkNull(String input) {
        if (Objects.isNull(input)) {
            throw new IllegalArgumentException("잘못된 입력값입니다. 입력을 확인해 주세요.");
        }
    }

    public static void checkBlank(String input) {
        if (input.matches(StringUtils.BLANK_REGEX)) {
            throw new IllegalArgumentException("해당 입력값은 공백 등이 될 수 없습니다. 입력을 확인해 주세요.");
        }
    }
}
