package domain;

public class Name {
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
        return name.length() >= 1 && name.length() <= 5;
    }


    public static Name empty() {
        return new Name("");
    }

    public static Name from(String name) {
        return new Name(name);
    }

    public String getName() {
        return name;
    }
}
