package domain;

import utils.Engine;

public class Car {
    private final static int MOVE_STANDARD = 4;

    private final Name name;
    private final Position position;

    public Car(Name name) {
        this.name = name;
        this.position = new Position();
    }

    public void tryMove(Engine engine) {
        if (isMovable(engine.generatePower())) {
            position.move();
        }
    }

    private boolean isMovable(int number) {
        return number >= MOVE_STANDARD;
    }

    public Position getPosition() {
        return position;
    }

    public Name getName() {
        return name;
    }
}
