package racingcar.domain;

import racingcar.vo.Name;
import racingcar.vo.Position;

public class Car {
    private static final int INIT_POSITION = 0;
    private static final int BOUNDARY = 4;

    private final Name name;
    private Position position;

    public Car(String name) {
        this.name = new Name(name);
        this.position = new Position(INIT_POSITION);
    }

    public void move(int power) {
        if (power >= BOUNDARY) {
            position.increase();
        }
    }

    public int getPosition() {
        return position.getPosition();
    }

    public String getName() {
        return name.getName();
    }


}
