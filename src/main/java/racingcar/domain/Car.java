package racingcar.domain;

public class Car {
    private final String name;
    private int position = 0;

    public Car(final String name) {
        validateName(name);
        this.name = name.trim();
    }

    private void validateName(final String name) {
        validateNotNull(name);
        validateNameStyle(name);
        validateNameSize(name);
    }

    private void validateNotNull(final String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("자동차 이름에 공백을 입력할 수 없습니다.");
        }
    }

    private void validateNameStyle(final String name) {
        final String regex = "^[a-zA-Z0-9_-]";
        if (name.matches(regex)) {
            throw new IllegalArgumentException("올바르지 않은 자동차 이름입니다.");
        }
    }

    private void validateNameSize(final String name) {
        if (name.trim().length() > 5) {
            throw new IllegalArgumentException("자동차 이름의 길이가 5를 초과합니다");
        }
    }
}
