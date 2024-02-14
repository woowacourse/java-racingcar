package domain;

public class Car {
    private final String name;
    private int position;

    public Car(String name) {
        validate(name);
        position = 0;
        this.name = name;
    }

    private static void validate(String name) {
        // TODO: 자동차 이름 검증
    }

    public void move() {
        position++;
    }

    @Override
    public String toString() {
        return name + " : " + "-".repeat(position);
    }

}
