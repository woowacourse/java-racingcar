package racingcar.domain;

public class Car {
    private final Name name;
    private Position position;

    public Car(Name name) {
        this.name = name;
        this.position = new Position(0);
    }
}
