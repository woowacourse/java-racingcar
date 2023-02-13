package domain;

public class Name {
    public static final int MIN_LENGTH = 5;
    private final String name;

    private Name(String name) {
        validate(name);
        this.name = name;
    }

    public static Name of(String name) {
        return new Name(name);
    }

    private void validate(String name) {
        if (name.isBlank() || name.length() > MIN_LENGTH) {
            throw new IllegalArgumentException(String.format("이름은 %d글자 이하여야 합니다.", MIN_LENGTH));
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
