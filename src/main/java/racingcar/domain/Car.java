package racingcar.domain;

public class Car {

    private final String name;

    public Car(String name) {
        validateNameLength(name);
        this.name = name;
    }

    private void validateNameLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 다섯 자 이내로 입력해 주세요.");
        }
    }
}
