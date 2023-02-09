package racingcar.domain;

import racingcar.util.Validator;

public class Car {
    private static final int INIT_POSITION = 0;
    private static final int BOUNDARY = 4;

    private final Name name;
    private Position position;

    public Car(String name) {
        this.name = new Name(name);
        this.position = new Position(INIT_POSITION);
    }

    public void move(int moveNumber) {
        if (moveNumber >= BOUNDARY) {
            position.increase();
        }
    }

    public Position getPosition() {
        return position;
    }

    public Name getName() {
        return name;
    }

    public int getIntPosition(){
        return this.position.getPosition();
    }

}
