package racingcar.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public record CarName(String name) {
    private static final Pattern NAME_PATTERN = Pattern.compile("[^ㄱ-ㅎ가-힣a-zA-Z0-9_-]");
    private static final int MAX_NAME_LENGTH = 5;

    public CarName(String name) {
        validate(name);
        this.name = name.trim();
    }

    private void validate(final String name) {
        validateNotNull(name);
        validateNameStyle(name);
        validateNameLength(name);
    }

    private void validateNotNull(final String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("자동차 이름에 공백을 입력할 수 없습니다.");
        }
    }

    private void validateNameStyle(final String name) {
        Matcher matcher = NAME_PATTERN.matcher(name);

        if (matcher.find()) {
            throw new IllegalArgumentException("올바르지 않은 자동차 이름입니다.");
        }
    }

    private void validateNameLength(final String name) {
        if (name.trim().length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(
                    String.format("자동차 이름의 길이가 %d를 초과합니다", MAX_NAME_LENGTH)
            );
        }
    }
}
