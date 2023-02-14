package domain;

public class Name {

    private static final String BLANK = " ";
    private static final int MAX_NAME_LENGTH = 5;

    private final String name;

    public Name(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        validateContainBlank(name);
        validateLength(name);
    }

    private void validateContainBlank(String name) {
        if (name.contains(BLANK)) {
            throw new IllegalArgumentException(String.format("이름에 공백을 포함할 수 없습니다. 입력값 : %s", name));
        }
    }

    private void validateLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(String.format("이름은 5자 이하여야합니다. 입력값 : %s", name));
        }
    }

    public String getName() {
        return name;
    }
}
