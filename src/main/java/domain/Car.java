package domain;

public class Car {
    public static final int MAX_NAME_LENGTH = 5;
    private final String name;

    public Car(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("[Error] 이름은 " + MAX_NAME_LENGTH + "자 이하여야 합니다. " +
                    "입력값 : "  + name);
        }
    }
}
