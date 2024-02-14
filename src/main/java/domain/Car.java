package domain;

public class Car {
    private String name;

    public Car(String name) {
        validate(name);
        this.name = name;
    }

    private static void validate(String name) {
        // TODO: 자동차 이름 검증
    }
}
