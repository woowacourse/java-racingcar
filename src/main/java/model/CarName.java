package model;

public class CarName {

    private static final int MAX_NAME_LENGTH = 5;
    private final String name;

    public CarName(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (isInvalidNameLength(name)) {
            throw new IllegalArgumentException("[ERROR] 이름 길이는 1 이상 5 이하여야 합니다.");
        }
    }

    private static boolean isInvalidNameLength(String name) {
        return name == null || name.isBlank() || name.length() > MAX_NAME_LENGTH;
    }

    public String getName() {
        return name;
    }
}
