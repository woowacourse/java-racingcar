package racingcar.domain;

public class Name {

    private static final int MAX_LENGTH = 5;
    private final String name;

    public Name(String name) {
        validateLength(name);
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    private void validateLength(String name) {
        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("각 이름은 5글자 이하여야 합니다.");
        }
    }
}
