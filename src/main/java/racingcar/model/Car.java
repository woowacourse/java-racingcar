package racingcar.model;

import java.util.Objects;

public class Car {

    private final static int MOVABLE_NUMBER = 4;

    private final Name name;
    private final Location location;
    private final Moving moving;

    public Car(String name) {
        this.name = new Name(name);
        this.location = new Location();
        this.moving = new BiggerNumberMoving(MOVABLE_NUMBER);
    }

    public void tryMove(int number) {
        if (moving.canMove(number)) {
            this.location.increase();
        }
    }

    public int getCarPosition() {
        return location.getLocation();
    }

    public String getName() {
        return name.getName();
    }

    public boolean isSamePosition(int position) {
        return Objects.equals(position, getCarPosition());
    }
}
