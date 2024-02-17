package domain;

public class Name {
    public static final int MIN_NAME_LENGTH = 1;
    public static final int MAX_NAME_LENGTH = 5;
    private final String name;

    public Name(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (!isValidSize(name)) {
            throw new IllegalArgumentException("이름은 1~5자로 입력해주세요.");
        }
    }

    private boolean isValidSize(String name) {
        return name.length() >= MIN_NAME_LENGTH && name.length() <= MAX_NAME_LENGTH;
    }



    public static Name from(String name) {
        return new Name(name);
    }

    public String getName() {
        return name;
    }
}
