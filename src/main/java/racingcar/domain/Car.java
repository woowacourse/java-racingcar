package racingcar.domain;

public class Car {
    private static final int MAX_NAME_LENGTH = 5;

    private final String name;

    public Car(String name) {
        checkValidName(name);
        this.name = name;
    }

    private void checkValidName(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
        }
    }
}
