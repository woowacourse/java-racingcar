package model;

public class Name {
    private final String name;

    public Name(String name) {
        validateNameLength(name);
        this.name = name;
    }

    private void validateNameLength(String name) {
        if (name.isBlank() || name.length() > 5) {
            throw new IllegalArgumentException("이름의 길이는 1~5글자 사이만 가능합니다.");
        }
    }

    public String getName() {
        return name;
    }
}
