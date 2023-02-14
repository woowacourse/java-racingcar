package domain;

import utils.Engine;

public class Car {
    private final Name name;
    private final Position position;
    private final Engine engine;

    public Car(Name name, Engine engine) {
        this.name = name;
        this.position = new Position();
        this.engine = engine;
    }

    public void tryMove() {
        if (engine.isMovable()) {
            position.move();
        }
    }

    public Position getPosition() {
        return position;
    }

    public Name getName() {
        return name;
    }
}
