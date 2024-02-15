package util;

import static enums.Delimiter.COMMA;

import java.util.regex.Pattern;

public class CarNamesValidator extends InputValidator {
    private static final Pattern CAR_NAMES_PATTERN = Pattern.compile(COMMA.getRegex());

    @Override
    void validateCustom(String input) {
        if (!CAR_NAMES_PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException(
                    String.format("자동차 이름은 %s(%s)를 기준으로 구분해야 합니다.", COMMA.getKorName(), COMMA.getValue()));
        }
    }
}
