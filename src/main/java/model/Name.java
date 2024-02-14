package model;

public class Name {
    private final String name;

    public Name(String name) {
        verifyNameLength(name);
        this.name = name;
    }

    private void verifyNameLength(String name) {
        if (name.length() < 1 || name.length() > 5) {
            throw new IllegalArgumentException("이름은 1자 이상 5자 이하여야 합니다.");
        }
    }

    protected String getName() {
        return name;
    }
}
