package racingcar.domain;

public class Car {
    private final String name;

    public Car(String name) {
        checkValidName(name);
        this.name = name;
    }

    private void checkValidName(String name) {

        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
        }

    }
}
