package racingcar.validator;

import java.util.Objects;

public class CarNameValidator {

    private static final int NAME_MAXIMUM_LENGTH = 5;
    private static final CharSequence BLANK = " ";
    
    private CarNameValidator() {
        throw new IllegalStateException("생성할 수 없는 유틸 클래스입니다.");
    }

    public static void validate(String name) {
        validateNullAndEmpty(name);
        validateLength(name);
        validateEachNameBlank(name);
    }

    private static void validateEachNameBlank(String name) {
        if (name.contains(BLANK)) {
            throw new IllegalArgumentException("이름에는 공백을 입력할 수 없습니다.");
        }
    }

    private static void validateLength(String name) {
        if (isCorrectLength(name)) {
            throw new IllegalArgumentException("1글자 이상 5글자 이하로 입력하세요.");
        }
    }

    private static void validateNullAndEmpty(String name) {
        if (Objects.isNull(name) || name.isBlank()) {
            throw new IllegalArgumentException("빈 문자열 및 공백은 입력할 수 없습니다.");
        }
    }

    private static boolean isCorrectLength(String name) {
        return name.length() > NAME_MAXIMUM_LENGTH;
    }
}
