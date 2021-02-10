package racingcar.domain.car;

import racingcar.domain.engine.Engine;

public class Car {

    private static final int GO_FORWARD_DISTANCE = 1;
    public static final int DEFAULT_CAR_POSITION = 0;

    private Name name;
    private Engine engine;
    private Position position;

    public Car(String name, Engine engine) {
        this.name = Name.of(name);
        this.engine = engine;
        this.position = Position.of(DEFAULT_CAR_POSITION);
    }

    public void move() {
        if (engine.isMove()) {
            this.position = position.plus(GO_FORWARD_DISTANCE);
        }
    }

    public boolean isOn(int max) {
        return position.isOn(max);
    }

    public Position getPosition() {
        return position;
    }

    public Name getName() {
        return name;
    }
}
