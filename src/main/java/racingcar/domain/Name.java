package racingcar.domain;

public class Name {
    public static final int NAME_MAX_LENGTH = 5;
    public static final int NAME_MIN_LENGTH = 0;

    private final String name;

    public Name(String name) {
        validateNameLength(name);
        validateNameFormat(name);
        this.name = name;
    }

    private void validateNameLength(String name) {
        int nameMinLength = NAME_MIN_LENGTH;
        int nameMaxLength = NAME_MAX_LENGTH;

        if (name.length() > nameMaxLength || name.length() <= nameMinLength) {
            throw new IllegalArgumentException(String.format("[ERROR] 자동차 이름의 길이는 %d부터 %d 사이여야 합니다.", nameMinLength, nameMaxLength));
        }
    }

    private void validateNameFormat(String name) {
        if (!name.matches("^[a-zA-Z0-9]*$")) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 영숫자로 이루어져야 합니다.");
        }
    }

    public String getName() {
        return name;
    }
}
