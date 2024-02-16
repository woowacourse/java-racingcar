package domain;

import java.util.regex.Pattern;

public class Name {
    private static final int MAX_NAME_LENGTH = 5;
    private static final Pattern NAME_CONDITION = Pattern.compile("^[가-힣a-zA-Z]*$");

    private final String name;

    private Name(String name) {
        this.name = name;
    }

    public static Name from(String name) {
        validate(name);
        return new Name(name);
    }

    private static void validate(String name) {
        validateNull(name);
        validateCarNameLength(name);
        validateBlank(name);
        validateStartsWithBlank(name);
        validateEndsWithBlank(name);
        validateEnglishOrKorean(name);
    }

    private static void validateCarNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(String.format("자동차 이름은 %d글자를 넘을 수 없습니다.", MAX_NAME_LENGTH));
        }
    }

    private static void validateBlank(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("자동차 이름은 공백이나 스페이스일 수 없습니다.");
        }
    }

    private static void validateNull(String name) {
        if (name == null) {
            throw new IllegalArgumentException("자동차 이름은 null일 수 없습니다.");
        }
    }

    private static void validateStartsWithBlank(String name) {
        if (name.startsWith(" ")) {
            throw new IllegalArgumentException("자동차 이름은 공백으로 시작할 수 없습니다.");
        }
    }

    private static void validateEndsWithBlank(String name) {
        if (name.endsWith(" ")) {
            throw new IllegalArgumentException("자동차 이름은 공백으로 끝날 수 없습니다.");
        }
    }

    private static void validateEnglishOrKorean(String name) {
        if (!NAME_CONDITION.matcher(name).matches()) {
            throw new IllegalArgumentException("자동차 이름은 영어 또는 한글만 가능합니다.");
        }
    }

    public String getName() {
        return name;
    }
}
