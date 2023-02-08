package racingcar.domain;

public class Car {

    private final Name name;
    private Position position;

    public Car(final String name) {
        this.name = new Name(name);
        this.position = Position.init();
    }

    public Name getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }

    public void move(final int randomNumber) {
        this.position = this.position.move(randomNumber);
    }
}
