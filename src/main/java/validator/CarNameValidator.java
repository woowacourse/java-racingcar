package validator;

import java.util.Objects;

public class CarNameValidator {

    private static final int NAME_MAXIMUM_LENGTH = 5;
    private static final CharSequence BLANK = " ";

    public static void validate(final String name) {
        validateNullAndEmpty(name);
        validateLength(name);
        validateEachNameBlank(name);
    }

    private static void validateEachNameBlank(final String name) {
        if (name.contains(BLANK)) {
            throw new IllegalArgumentException("이름에는 공백을 입력할 수 없습니다.");
        }
    }

    private static void validateLength(final String name) {
        if (isCorrectLength(name)) {
            throw new IllegalArgumentException("1글자 이상 5글자 이하로 입력하세요.");
        }
    }

    private static void validateNullAndEmpty(final String name) {
        if (Objects.isNull(name) || name.isBlank()) {
            throw new IllegalArgumentException("빈 문자열 및 공백은 입력할 수 없습니다.");
        }
    }

    private static boolean isCorrectLength(final String name) {
        return name.length() > NAME_MAXIMUM_LENGTH;
    }
}