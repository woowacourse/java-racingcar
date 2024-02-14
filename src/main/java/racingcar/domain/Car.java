package racingcar.domain;

public class Car {
    private final String name;
    private int forward;

    Car(String name) {
        this.name = name;
        forward = 0;
    }

    String getName() {
        return name;
    }

    int getForward() {
        return forward;
    }
}
