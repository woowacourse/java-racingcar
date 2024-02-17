package io.validator;


import java.util.regex.Pattern;

public class InputValidator {
    private static final String CAR_NAMES_REGEX = "[가-힣a-zA-Z]{2,5}(,[가-힣a-zA-Z]{2,5})*";
    private static final Pattern CAR_NAMES_PATTERN = Pattern.compile(CAR_NAMES_REGEX);

    public void validateIntFormat(String text) {
        try {
            Integer.parseInt(text);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("입력 값이 정수형태가 아닙니다.");
        }
    }

    public void validateCarNamesFormat(String carNames) {
        if(CAR_NAMES_PATTERN.matcher(carNames).matches()) {
            return;
        }
        throw new IllegalArgumentException("자동차 이름은 \"이름,이름,...\" 형태로 입력해야 합니다.");
    }
}
