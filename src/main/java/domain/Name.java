package domain;

public class Name {

    private static final int MIN_CAR_NAME_LENGTH = 1;

    private static final int MAX_CAR_NAME_LENGTH = 5;

    private final String name;

    private Name(String name) {
        validateName(name);
        this.name = name;
    }

    public static Name fromName(String name) {
        return new Name(name);
    }

    private void validateName(String name) {

        if (isNull(name) || isEmptyName(name)) {
            throw new IllegalArgumentException("자동차 이름은 빈칸일 수 없습니다.");
        }

        if (isExceedMaxLength(name) || isExceedMinLength(name)) {
            throw new IllegalArgumentException("자동차 이름은 1글자 이상 5글자 이하로 작성해주세요.");
        }
    }

    private boolean isEmptyName(String name) {

        return name.isBlank();
    }

    private boolean isExceedMaxLength(String name) {

        return name.length() > MAX_CAR_NAME_LENGTH;
    }

    private boolean isExceedMinLength(String name) {

        return name.length() < MIN_CAR_NAME_LENGTH;
    }

    private boolean isNull(String name) {

        return name == null;
    }
}
