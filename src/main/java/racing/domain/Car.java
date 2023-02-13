package racing.domain;

public class Car {

    private static final int INITIAL_VALUE = 0;
    private static final int MOVABLE_VALUE = 4;

    private final Name name;
    private Position position;

    public Car(String name) {
        this.name = new Name(name);
        this.position = new Position(INITIAL_VALUE);
    }

    public void move(NumberGenerator numberGenerator) {
        if (numberGenerator.generate() >= MOVABLE_VALUE) {
            this.position = position.increase();
        }
    }

    public Name getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }
}
